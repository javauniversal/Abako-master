package co.dito.abako.abako.Entities;


import com.google.gson.annotations.SerializedName;

public class RuteroSync {

    @SerializedName("Id")
    private int Id;

    @SerializedName("Proceso")
    private String Proceso;

    @SerializedName("IdEmpresa")
    private int IdEmpresa;

    @SerializedName("Dia")
    private int Dia;

    @SerializedName("Orden")
    private double Orden;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getProceso() {
        return Proceso;
    }

    public void setProceso(String proceso) {
        Proceso = proceso;
    }

    public int getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        IdEmpresa = idEmpresa;
    }

    public int getDia() {
        return Dia;
    }

    public void setDia(int dia) {
        Dia = dia;
    }

    public double getOrden() {
        return Orden;
    }

    public void setOrden(double orden) {
        Orden = orden;
    }

}
