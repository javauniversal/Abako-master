package co.dito.abako.abako.Adapters;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
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

    public AdapterRecyclerClientes(Activity context, List<ClienteSync> clienteSyncs, DBHelper mydb) {
        super();
        this.context = context;
        this.clienteSyncs = clienteSyncs;
        this.mydb = mydb;
    }

    @Override
    public ClienteInterface onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cliente_cartera, parent, false);
        return new ClienteInterface(v, context);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(ClienteInterface holder, final int position) {

        final ClienteSync items = clienteSyncs.get(position);
        holder.nombre_cliente.setText(items.getNombre_comun());

        cargarFacturasClienteDetalle(holder.list_view_factura, items.getId_empresa());

    }

    private void cargarFacturasClienteDetalle(LinearLayout list_view_factura, int id_empresa) {

        final List<CarteraSync> carteraSyncList = mydb.selectCarteraIdEmpresa(id_empresa);
        for(int j = 0; j < carteraSyncList.size(); j++) {
            LinearLayout ll = new LinearLayout(context);
            ll.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            ll.setOrientation(LinearLayout.HORIZONTAL);

            TextView factura = new TextView(context);
            factura.setText(carteraSyncList.get(j).getFac()+"");
            factura.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
            factura.setGravity(Gravity.LEFT);
            factura.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
            ll.addView(factura);

            TextView valor = new TextView(context);
            valor.setText(carteraSyncList.get(j).getDecimal_p()+"");
            valor.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
            valor.setGravity(Gravity.LEFT);
            valor.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
            ll.addView(valor);

            list_view_factura.addView(ll);
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
