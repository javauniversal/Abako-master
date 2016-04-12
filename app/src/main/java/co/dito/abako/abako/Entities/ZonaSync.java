package co.dito.abako.abako.Entities;


import io.realm.RealmObject;

public class ZonaSync extends RealmObject {

    private int id_zona;

    private String descripcion;

    public int getId_zona() {
        return id_zona;
    }

    public void setId_zona(int id_zona) {
        this.id_zona = id_zona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
