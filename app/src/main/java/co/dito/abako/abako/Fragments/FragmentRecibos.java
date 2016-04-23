package co.dito.abako.abako.Fragments;


import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import co.dito.abako.abako.Adapters.AdapterRecyclerClientes;
import co.dito.abako.abako.Adapters.AdapterRecyclerMenu;
import co.dito.abako.abako.DataBase.DBHelper;
import co.dito.abako.abako.Entities.ClienteSync;
import co.dito.abako.abako.R;

public class FragmentRecibos extends Fragment {

    private RecyclerView recycler;
    private DBHelper mydb;
    private RecyclerView.Adapter adapter;

    public FragmentRecibos() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recibos, container, false);

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

        cargarClientes();

    }

    private void cargarClientes(){
        new AsyncTask<String[], Long, Long>(){
            @Override
            protected Long doInBackground(String[]... params) {
                List<ClienteSync> clienteSyncs = mydb.selectClientesSyncs();
                adapter = new AdapterRecyclerClientes(getActivity(), clienteSyncs, mydb);
                return null;
            }

            protected void onPreExecute() { }

            @Override
            public void onProgressUpdate(Long... value) { }

            @Override
            protected void onPostExecute(Long result){
                recycler.setAdapter(adapter);
            }

        }.execute();
    }
}
