package co.dito.abako.abako.Entities;

import io.realm.RealmObject;

public class ClienteSync extends RealmObject {

    private int id_canal;

    private String descripcion;

    public int getId_canal() {
        return id_canal;
    }

    public void setId_canal(int id_canal) {
        this.id_canal = id_canal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
