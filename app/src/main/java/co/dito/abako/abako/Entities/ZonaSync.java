package co.dito.abako.abako.Entities;

import com.google.gson.annotations.SerializedName;

public class ZonaSync {

    @SerializedName("IdZona")
    private int id_zona;

    @SerializedName("Descripcion")
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
