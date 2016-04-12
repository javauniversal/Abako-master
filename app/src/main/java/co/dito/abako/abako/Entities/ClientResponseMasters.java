package co.dito.abako.abako.Entities;

import java.util.List;

import io.realm.RealmObject;

public class ClientResponseMasters extends RealmObject {

    private List<FormaPago> FormasPago;

    private List<Frecuencia> frecuencia;

    private List<Inicia> inicia;

    private List<AtributosEspeciales> atributosEspeciales;
}
