package co.dito.abako.abako.Adapters;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import co.dito.abako.abako.Activities.ActCarteraMenu;
import co.dito.abako.abako.DataBase.DBHelper;
import co.dito.abako.abako.Entities.CarteraSync;
import co.dito.abako.abako.Entities.ClienteInterface;
import co.dito.abako.abako.Entities.ClienteSync;
import co.dito.abako.abako.Entities.EntMenu;
import co.dito.abako.abako.Entities.MenuInterface;
import co.dito.abako.abako.R;

import static co.dito.abako.abako.Entities.EntMenu.getEntMenuStatic;


public class AdapterRecyclerClientes extends RecyclerView.Adapter<ClienteInterface> {

    private Activity context;
    private List<ClienteSync> clienteSyncs;
    private DBHelper mydb;
    private DecimalFormat format;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
    double sumaTotal;

    public AdapterRecyclerClientes(Activity context, List<ClienteSync> clienteSyncs, DBHelper mydb) {
        super();
        this.context = context;
        this.clienteSyncs = clienteSyncs;
        this.mydb = mydb;
    }

    @Override
    public ClienteInterface onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cliente_cartera, parent, false);

        format = new DecimalFormat("#,###");

        return new ClienteInterface(v, context);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(ClienteInterface holder, final int position) {

        final ClienteSync items = clienteSyncs.get(position);
        holder.nombre_comu.setText(items.getNombre_comun());
        holder.razon_social.setText(items.getRazon_social());
        holder.identificacion.setText(items.getIdentificacion());
        //holder.direccion.setText(items.getCantidad_dias());

        holder.fecha_ultimo_pago.setText(String.format("Fecha Ultimo Pago %s", formatDateString(items.getFchltmpg())));

        holder.ultimo_pago.setText(String.format("Ultimo Pago $ %s", format.format(items.getUltmpg())));

        holder.direccion.setText(items.getDireccion());

        cargarFacturasClienteDetalle(holder.list_view_factura, items.getId_empresa(), holder.total_cartera);

        holder.total_cartera.setText(String.format("$ %s", mydb.selectCarteraIdEmpresaSum(items.getId_empresa())));

    }

    private String formatDateString(String data){
        if (data != null) {
            String fechaFormat = data.replaceAll("/", "").replace("Date", "").replace("(", "").replace(")", "").trim();
            long l = Long.parseLong(fechaFormat);
            Date date = new Date(l);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dateFormatted = sdf.format(date);
            return dateFormatted;
        } else {
            return "";
        }
    }

    private void cargarFacturasClienteDetalle(LinearLayout list_view_factura, int id_empresa, TextView total_cartera) {

        final List<CarteraSync> carteraSyncList = mydb.selectCarteraIdEmpresa(id_empresa);

        sumaTotal = 0.0;

        for(int j = 0; j < carteraSyncList.size(); j++) {

            sumaTotal = (sumaTotal + carteraSyncList.get(j).getSld());

            LinearLayout ll = new LinearLayout(context);
            ll.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            ll.setOrientation(LinearLayout.HORIZONTAL);

            TextView factura = new TextView(context);
            factura.setText(carteraSyncList.get(j).getFac()+"");
            factura.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
            factura.setGravity(Gravity.LEFT);
            factura.setTypeface(factura.getTypeface(), Typeface.BOLD);
            factura.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            ll.addView(factura);

            TextView valor = new TextView(context);
            valor.setText(String.format("$ %s", carteraSyncList.get(j).getSld()));
            valor.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
            valor.setGravity(Gravity.RIGHT);
            valor.setTextColor(Color.parseColor("#2E9AFE"));
            valor.setTypeface(valor.getTypeface(), Typeface.BOLD);
            valor.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            ll.addView(valor);

            LinearLayout ll2 = new LinearLayout(context);
            ll2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            ll2.setPadding(0,0,0,20);
            ll2.setOrientation(LinearLayout.HORIZONTAL);

            TextView fecha_factura = new TextView(context);
            fecha_factura.setText(String.format("Creación: %s",formatDateString(carteraSyncList.get(j).getFecha_fac())));
            fecha_factura.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
            fecha_factura.setGravity(Gravity.LEFT);
            fecha_factura.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
            ll2.addView(fecha_factura);

            TextView fecha_vencimiento = new TextView(context);
            fecha_vencimiento.setText(String.format("Vencimiento: %s",formatDateString(carteraSyncList.get(j).getVenc())));
            fecha_vencimiento.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
            fecha_vencimiento.setGravity(Gravity.RIGHT);
            fecha_vencimiento.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
            ll2.addView(fecha_vencimiento);

            list_view_factura.addView(ll);

            list_view_factura.addView(ll2);

        }


    }

    @Override
    public int getItemCount() {
        if (clienteSyncs == null) {
            return 0;
        } else {
            return clienteSyncs.size();
        }
    }

}
