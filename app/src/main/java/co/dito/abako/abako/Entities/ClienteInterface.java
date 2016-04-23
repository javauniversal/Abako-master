package co.dito.abako.abako.Entities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import co.dito.abako.abako.R;

public class ClienteInterface extends RecyclerView.ViewHolder{

    public TextView nombre_cliente;
    public TextView numero_recibo;
    public TextView direccion;
    public TextView total_cartera;
    public TextView ultimo_pago;
    public TextView fecha_ultimo_pago;
    public TextView btn_pagar;
    public LinearLayout list_view_factura;

    public ClienteInterface(View itemView, Context context) {
        super(itemView);

        this.nombre_cliente = (TextView) itemView.findViewById(R.id.nombre_cliente);
        //this.numero_recibo = (TextView) itemView.findViewById(R.id.numero_recibo);
        this.direccion = (TextView) itemView.findViewById(R.id.direccion);
        this.total_cartera = (TextView) itemView.findViewById(R.id.total_cartera);
        this.ultimo_pago = (TextView) itemView.findViewById(R.id.ultimo_pago);
        this.fecha_ultimo_pago = (TextView) itemView.findViewById(R.id.fecha_ultimo_pago);
        this.btn_pagar = (TextView) itemView.findViewById(R.id.btn_pagar);
        this.list_view_factura = (LinearLayout) itemView.findViewById(R.id.factura_linear);

    }

}
