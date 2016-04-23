package co.dito.abako.abako.Entities;

import com.google.gson.annotations.SerializedName;

public class AtributosEspecialesSync {

    @SerializedName("IdEmp")
    private int id_emp;

    @SerializedName("IdTipo")
    private int id_tipo;

    @SerializedName("Valor")
    private String valor;

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
