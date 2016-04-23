package co.dito.abako.abako.Activities;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.dito.abako.abako.DataBase.DBHelper;
import co.dito.abako.abako.Entities.CarteraResponse;
import co.dito.abako.abako.Entities.ClientResponse;
import co.dito.abako.abako.Entities.ClienteSync;
import co.dito.abako.abako.Entities.ContactoResponse;
import co.dito.abako.abako.Entities.Empleado;
import co.dito.abako.abako.Entities.JsonCompress;
import co.dito.abako.abako.Entities.RuteroResponse;
import co.dito.abako.abako.Fragments.FragmentInformacion;
import co.dito.abako.abako.Fragments.FragmentInicio;
import co.dito.abako.abako.Fragments.FragmentRecibos;
import co.dito.abako.abako.Fragments.FragmentSincroniacion;
import co.dito.abako.abako.R;
import co.dito.abako.abako.Utils.ZipUtils;
import dmax.dialog.SpotsDialog;

import static co.dito.abako.abako.Entities.Empleado.getIp_select;

public class ActCarteraMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private FragmentInicio fragmentInicio;
    private FragmentRecibos fragmentRecibos;
    private FragmentInformacion fragmentInformacion;
    private FragmentSincroniacion fragmentSincroniacion;
    private RequestQueue requestQueue;
    private DBHelper mydb;
    private Empleado empleado = new Empleado();
    private Date pStart;
    private ZipUtils zipUtils = new ZipUtils();
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartera_menu);
        toolbar = (Toolbar) findViewById(R.id.toolbarhome);
        setSupportActionBar(toolbar);
        mydb = new DBHelper(this);
        empleado = mydb.recuperarInfoEmpleado();
        pStart = new Date();

        alertDialog = new SpotsDialog(this, R.style.Custom);
        alertDialog.setCancelable(false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        bloqueDescargaData();

        FragmentManager fManager = getFragmentManager();
        fragmentInicio = new FragmentInicio();

        fManager.beginTransaction().replace(R.id.contentPanel, fragmentInicio).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void bloqueDescargaData() {
        if (!mydb.validaDataTable("ClienteSync")) {
            descargaClientes();
        }
    }

    private void descargaClientes(){
        alertDialog.show();
        String url = String.format("%1$s%2$s", getIp_select(), "/GetClients");
        requestQueue = Volley.newRequestQueue(this);
        try {

            HashMap<String, Object> postParameters = new HashMap<>();
            postParameters.put("EsTodo", "S");
            postParameters.put("Fecha", "/Date(" + pStart.getTime() + "+0200)/");
            postParameters.put("IdPersona", empleado.getId_empleado());

            String jsonParameters = new Gson().toJson(postParameters);
            JSONObject jsonRootObject = new JSONObject(jsonParameters);

            JsonObjectRequest jsArrayRequest = new JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    jsonRootObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            parceJsonCliente(response);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                                Toast.makeText(ActCarteraMenu.this, "Error de tiempo de espera", Toast.LENGTH_LONG).show();
                            } else if (error instanceof AuthFailureError) {
                                Toast.makeText(ActCarteraMenu.this, "Error Servidor", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ServerError) {
                                Toast.makeText(ActCarteraMenu.this, "Server Error", Toast.LENGTH_LONG).show();
                            } else if (error instanceof NetworkError) {
                                Toast.makeText(ActCarteraMenu.this, "Error de red", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ParseError) {
                                Toast.makeText(ActCarteraMenu.this, "Error al serializar los datos", Toast.LENGTH_LONG).show();
                            }
                        }
                    }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Content-Type", "application/json; charset=utf-8");
                    return headers;
                }
            };

            requestQueue.add(jsArrayRequest);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parceJsonCliente(JSONObject response) {
        try {
            Gson gson = new Gson();
            JsonCompress fromJson = gson.fromJson(String.valueOf(response), JsonCompress.class);
            String json_final = zipUtils.decompress(fromJson.getContent());

            ClientResponse clientResponse = gson.fromJson(json_final, ClientResponse.class);

            if (clientResponse.getMsgiId() != -1) {
                if (mydb.insertClienteSync(clientResponse.getClientes()) && mydb.insertCanalSync(clientResponse.getCanales()) &&
                        mydb.insertZonaSync(clientResponse.getZonas()) && mydb.insertAtributosEspecialesSync(clientResponse.getAtributos_especiales()) &&
                        mydb.insertFormasPago(clientResponse.getDefaultMasters().getFormasPago()) && mydb.insertFrecuencia(clientResponse.getDefaultMasters().getFrecuencia()) &&
                        mydb.insertInicia(clientResponse.getDefaultMasters().getInicia()) && mydb.insertAtributosEspeciales(clientResponse.getDefaultMasters().getAtributosEspeciales())){

                    descargaCartera();
                }
            } else {
                Toast.makeText(this, clientResponse.getMsg_str(), Toast.LENGTH_LONG).show();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void descargaCartera(){
        String url = String.format("%1$s%2$s", getIp_select(), "/GetCartera");
        requestQueue = Volley.newRequestQueue(this);
        try {

            HashMap<String, Object> postParameters = new HashMap<>();
            postParameters.put("EsTodo", "S");
            postParameters.put("Fecha", "/Date(" + pStart.getTime() + "+0200)/");
            postParameters.put("IdPersona", empleado.getId_empleado());

            String jsonParameters = new Gson().toJson(postParameters);
            JSONObject jsonRootObject = new JSONObject(jsonParameters);

            JsonObjectRequest jsArrayRequest = new JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    jsonRootObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            parceJsonCartera(response);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                                Toast.makeText(ActCarteraMenu.this, "Error de tiempo de espera", Toast.LENGTH_LONG).show();
                            } else if (error instanceof AuthFailureError) {
                                Toast.makeText(ActCarteraMenu.this, "Error Servidor", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ServerError) {
                                Toast.makeText(ActCarteraMenu.this, "Server Error", Toast.LENGTH_LONG).show();
                            } else if (error instanceof NetworkError) {
                                Toast.makeText(ActCarteraMenu.this, "Error de red", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ParseError) {
                                Toast.makeText(ActCarteraMenu.this, "Error al serializar los datos", Toast.LENGTH_LONG).show();
                            }
                        }
                    }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Content-Type", "application/json; charset=utf-8");
                    return headers;
                }
            };

            requestQueue.add(jsArrayRequest);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parceJsonCartera(JSONObject response) {
        try {
            Gson gson = new Gson();
            JsonCompress fromJson = gson.fromJson(String.valueOf(response), JsonCompress.class);
            String json_final = zipUtils.decompress(fromJson.getContent());

            CarteraResponse carteraResponse = gson.fromJson(json_final, CarteraResponse.class);

            if (carteraResponse.getMsg_id() != -1){
                if (mydb.insertCartera(carteraResponse.getCartera()) && mydb.insertEstadoCartera(carteraResponse.getDefault_masters().getEstadoCarteras())) {
                    descargaContacto();
                }
            } else {
                Toast.makeText(this, carteraResponse.getMsg_str(), Toast.LENGTH_LONG).show();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void descargaContacto(){
        String url = String.format("%1$s%2$s", getIp_select(), "/GetContacto");
        requestQueue = Volley.newRequestQueue(this);
        try {

            HashMap<String, Object> postParameters = new HashMap<>();
            postParameters.put("EsTodo", "S");
            postParameters.put("Fecha", "/Date(" + pStart.getTime() + "+0200)/");
            postParameters.put("IdPersona", empleado.getId_empleado());

            String jsonParameters = new Gson().toJson(postParameters);
            JSONObject jsonRootObject = new JSONObject(jsonParameters);

            JsonObjectRequest jsArrayRequest = new JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    jsonRootObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            parceJsonContacto(response);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                                Toast.makeText(ActCarteraMenu.this, "Error de tiempo de espera", Toast.LENGTH_LONG).show();
                            } else if (error instanceof AuthFailureError) {
                                Toast.makeText(ActCarteraMenu.this, "Error Servidor", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ServerError) {
                                Toast.makeText(ActCarteraMenu.this, "Server Error", Toast.LENGTH_LONG).show();
                            } else if (error instanceof NetworkError) {
                                Toast.makeText(ActCarteraMenu.this, "Error de red", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ParseError) {
                                Toast.makeText(ActCarteraMenu.this, "Error al serializar los datos", Toast.LENGTH_LONG).show();
                            }
                        }
                    }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Content-Type", "application/json; charset=utf-8");
                    return headers;
                }
            };

            requestQueue.add(jsArrayRequest);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parceJsonContacto(JSONObject response) {
        try {
            Gson gson = new Gson();
            JsonCompress fromJson = gson.fromJson(String.valueOf(response), JsonCompress.class);
            String json_final = zipUtils.decompress(fromJson.getContent());

            ContactoResponse contactoResponse = gson.fromJson(json_final, ContactoResponse.class);

            if (contactoResponse.getMsg_id() != -1) {
                if (mydb.insertContacto(contactoResponse.getContacto()))
                    descargaRutero();
            }  else {
                Toast.makeText(this, contactoResponse.getMsg_str(), Toast.LENGTH_LONG).show();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void descargaRutero(){
        String url = String.format("%1$s%2$s", getIp_select(), "/GetRutero");
        requestQueue = Volley.newRequestQueue(this);
        try {

            HashMap<String, Object> postParameters = new HashMap<>();
            postParameters.put("EsTodo", "S");
            postParameters.put("Fecha", "/Date(" + pStart.getTime() + "+0200)/");
            postParameters.put("IdPersona", empleado.getId_empleado());

            String jsonParameters = new Gson().toJson(postParameters);
            JSONObject jsonRootObject = new JSONObject(jsonParameters);

            JsonObjectRequest jsArrayRequest = new JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    jsonRootObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            parceJsonRutero(response);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                                Toast.makeText(ActCarteraMenu.this, "Error de tiempo de espera", Toast.LENGTH_LONG).show();
                            } else if (error instanceof AuthFailureError) {
                                Toast.makeText(ActCarteraMenu.this, "Error Servidor", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ServerError) {
                                Toast.makeText(ActCarteraMenu.this, "Server Error", Toast.LENGTH_LONG).show();
                            } else if (error instanceof NetworkError) {
                                Toast.makeText(ActCarteraMenu.this, "Error de red", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ParseError) {
                                Toast.makeText(ActCarteraMenu.this, "Error al serializar los datos", Toast.LENGTH_LONG).show();
                            }
                        }
                    }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Content-Type", "application/json; charset=utf-8");
                    return headers;
                }
            };

            requestQueue.add(jsArrayRequest);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parceJsonRutero(JSONObject response) {
        try {
            Gson gson = new Gson();
            JsonCompress fromJson = gson.fromJson(String.valueOf(response), JsonCompress.class);
            String json_final = zipUtils.decompress(fromJson.getContent());

            RuteroResponse ruteroResponse = gson.fromJson(json_final, RuteroResponse.class);
            if (ruteroResponse.getMsgId() != -1) {
                if (mydb.inserTRutero(ruteroResponse.getRutero())){
                    alertDialog.dismiss();
                }
            }  else {
                Toast.makeText(this, ruteroResponse.getMsgStr(), Toast.LENGTH_LONG).show();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fManager = getFragmentManager();

        if (id == R.id.nav_inicio) {
            toolbar.setTitle("Modulo Cartera");
            if (fragmentInicio == null)
                fragmentInicio = new FragmentInicio();

            fManager.beginTransaction().replace(R.id.contentPanel, fragmentInicio).commit();
        } else if (id == R.id.nav_recibos) {
            toolbar.setTitle("Recibos");
            if (fragmentRecibos == null)
                fragmentRecibos = new FragmentRecibos();

            fManager.beginTransaction().replace(R.id.contentPanel, fragmentRecibos).commit();

        } else if (id == R.id.nav_sincronizar) {
            toolbar.setTitle("Sincronizar");
            if (fragmentSincroniacion == null)
                fragmentSincroniacion = new FragmentSincroniacion();

            fManager.beginTransaction().replace(R.id.contentPanel, fragmentSincroniacion).commit();

        } else if (id == R.id.nav_informacion) {
            toolbar.setTitle("Información");
            if (fragmentInformacion == null)
                fragmentInformacion = new FragmentInformacion();

            fManager.beginTransaction().replace(R.id.contentPanel, fragmentInformacion).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/
        startActivity(new Intent(this, ActMenu.class));
        finish();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (requestQueue != null)
            requestQueue.cancelAll("");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (requestQueue != null)
            requestQueue.cancelAll("");
    }

}
