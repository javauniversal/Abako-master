package co.dito.abako.abako.Fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import co.dito.abako.abako.Activities.ActCarteraMenu;
import co.dito.abako.abako.Adapters.AdapterRecyclerClientes;
import co.dito.abako.abako.Adapters.ExpandableListAdapter;
import co.dito.abako.abako.Adapters.ExpandableListDataPump;
import co.dito.abako.abako.DataBase.DBHelper;
import co.dito.abako.abako.Entities.CanalSync;
import co.dito.abako.abako.Entities.ClienteSync;
import co.dito.abako.abako.Entities.FiltroCartera;
import co.dito.abako.abako.Entities.Frecuencia;
import co.dito.abako.abako.Entities.ZonaSync;
import co.dito.abako.abako.R;

public class FragmentRecibos extends Fragment {

    private RecyclerView recycler;
    private DBHelper mydb;
    private RecyclerView.Adapter adapter;
    private SwipeRefreshLayout refreshLayout;
    List<ClienteSync> filterList;
    private String filtertext = "";
    private List<ClienteSync> clienteSyncs;
    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private HashMap<String, List<String>> expandableListDetail;
    private ArrayList<String> expandableListTitle;

    private static String DB_PATH = "/data/data/co.dito.abako.abako/databases/";
    private static String DB_NAME = "MyDBName";

    public FragmentRecibos() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recibos, container, false);

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);

        recycler = (RecyclerView) view.findViewById(R.id.recycler_factura);
        //recycler.setHasFixedSize(true);
        // Usar un administrador para LinearLayout
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);

        mydb = new DBHelper(getActivity());

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setHasOptionsMenu(true);

        cargarClientes();

        refreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        refreshLayout.setRefreshing(false);
                    }
                }
        );

        try {
            BD_backup();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "dfgsaliugsd", Toast.LENGTH_LONG).show();
        }
    }

    private void copyDataBase(String pathFile) throws IOException {
        InputStream myInput = getActivity().getAssets().open("MyDBName.db");
        OutputStream myOutput = new FileOutputStream(pathFile);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }
    public static void BD_backup() throws IOException {
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

        String DATABASE_NAME = "MyDBName.db";

        final String inFileName = "/data/data/co.dito.abako.abako/databases/"+DATABASE_NAME;
        File dbFile = new File(inFileName);
        FileInputStream fis = null;

        fis = new FileInputStream(dbFile);

        String directorio = "/sdcard";
        File d = new File(directorio);
        if (!d.exists()) {
            d.mkdir();
        }
        String outFileName = directorio; //+ "/"+DATABASE_NAME + "_"+timeStamp;

        OutputStream output = new FileOutputStream(inFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            output.write(buffer, 0, length);
        }

        output.flush();
        output.close();
        fis.close();
    }

    private void cargarClientes() {

        new AsyncTask<String[], Long, Long>() {
            @Override
            protected Long doInBackground(String[]... params) {
                clienteSyncs = mydb.selectClientesSyncs();
                adapter = new AdapterRecyclerClientes(getActivity(), clienteSyncs, mydb);
                return null;
            }

            protected void onPreExecute() { }

            @Override
            public void onProgressUpdate(Long... value) { }

            @Override
            protected void onPostExecute(Long result) {
                recycler.setAdapter(adapter);
            }

        }.execute();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        MenuItem item2 = menu.add("Filtrar");
        item2.setIcon(R.drawable.ic_filter_list_white_24dp); // sets icon
        item2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        item2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                DialogMenu();
                return true;
            }
        });

        MenuItem item = menu.add("Search");
        item.setIcon(R.drawable.abc_ic_search_api_mtrl_alpha); // sets icon
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        SearchView sv = new SearchView(((ActCarteraMenu) getActivity()).getSupportActionBar().getThemedContext());

        int id = sv.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView textView = (TextView) sv.findViewById(id);
        textView.setHint("Buscar...");
        textView.setHintTextColor(getResources().getColor(R.color.color_gris));
        textView.setTextColor(getResources().getColor(R.color.actionBarColorText));

        // implementing the listener
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //doSearch(s);
                return s.length() < 4;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();

                filtertext = newText;

                filterList = getNewListFromFilter(newText);

                recycler.setLayoutManager(new LinearLayoutManager(getActivity()));

                adapter = new AdapterRecyclerClientes(getActivity(), filterList, mydb);
                recycler.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                return true;
            }
        });

        item.setActionView(sv);
    }

    private void DialogMenu() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialoglayout = inflater.inflate(R.layout.dialog_filter, null);
        expandableListView = (ExpandableListView) dialoglayout.findViewById(R.id.expandableListView);

        FiltroCartera filtroCartera = new FiltroCartera();

        List<Frecuencia> frecuenciaList = mydb.selectFrecuencia();
        List<ZonaSync> zonaSyncList = mydb.selectZona();
        List<CanalSync> canalSyncList = mydb.selectCanal();

        filtroCartera.setFrecuenciaList(frecuenciaList);
        filtroCartera.setZonaSyncList(zonaSyncList);
        filtroCartera.setCanalSyncList(canalSyncList);

        expandableListDetail = ExpandableListDataPump.getData(filtroCartera);

        expandableListTitle = new ArrayList<>(expandableListDetail.keySet());

        expandableListAdapter = new ExpandableListAdapter(getActivity(), expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setTitle("Filtro");
        builder.setView(dialoglayout).setPositiveButton("Filtrar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        builder.show();
    }

    private List<ClienteSync> getNewListFromFilter(CharSequence query) {
        query = query.toString().toLowerCase();

        List<ClienteSync> filteredList = new ArrayList<>();

        for (int i = 0; i < clienteSyncs.size(); i++) {

            if (clienteSyncs.get(i).getNombre_comun().toLowerCase().contains(query) || clienteSyncs.get(i).getIdentificacion().toLowerCase().contains(query) ||
                    clienteSyncs.get(i).getRazon_social().toLowerCase().contains(query) || clienteSyncs.get(i).getCodigo().toLowerCase().contains(query)) {
                filteredList.add(clienteSyncs.get(i));
            }
        }
        return filteredList;
    }
}
