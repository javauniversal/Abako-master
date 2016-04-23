package co.dito.abako.abako.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClientResponseMasters {

    @SerializedName("FormasPago")
    private List<FormaPago> FormasPago;

    @SerializedName("Frecuencia")
    private List<Frecuencia> frecuencia;

    @SerializedName("Inicia")
    private List<Inicia> inicia;

    @SerializedName("AtributosEspeciales")
    private List<AtributosEspeciales> atributosEspeciales;

    public List<FormaPago> getFormasPago() {
        return FormasPago;
    }

    public void setFormasPago(List<FormaPago> formasPago) {
        FormasPago = formasPago;
    }

    public List<Frecuencia> getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(List<Frecuencia> frecuencia) {
        this.frecuencia = frecuencia;
    }

    public List<Inicia> getInicia() {
        return inicia;
    }

    public void setInicia(List<Inicia> inicia) {
        this.inicia = inicia;
    }

    public List<AtributosEspeciales> getAtributosEspeciales() {
        return atributosEspeciales;
    }

    public void setAtributosEspeciales(List<AtributosEspeciales> atributosEspeciales) {
        this.atributosEspeciales = atributosEspeciales;
    }

}
