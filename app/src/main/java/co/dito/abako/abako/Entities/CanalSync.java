package co.dito.abako.abako.Entities;

import io.realm.RealmObject;

public class CanalSync extends RealmObject {

    private int id_empresa;

    private String razon_social;

    private String nombre_comun;

    private String identificacion;

    private String codigo;

    private int id_canal;

    private int id_zona;

    private int id_lista_precio;

    private double longitud;

    private double latitud;

    private int id_forma_pago;

    private int cupo;

    private double cantidad_dias;

    private int frecuencia;

    private int inicia;

    private String ult_vt;

    private String prcs;

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNombre_comun() {
        return nombre_comun;
    }

    public void setNombre_comun(String nombre_comun) {
        this.nombre_comun = nombre_comun;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId_canal() {
        return id_canal;
    }

    public void setId_canal(int id_canal) {
        this.id_canal = id_canal;
    }

    public int getId_zona() {
        return id_zona;
    }

    public void setId_zona(int id_zona) {
        this.id_zona = id_zona;
    }

    public int getId_lista_precio() {
        return id_lista_precio;
    }

    public void setId_lista_precio(int id_lista_precio) {
        this.id_lista_precio = id_lista_precio;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public int getId_forma_pago() {
        return id_forma_pago;
    }

    public void setId_forma_pago(int id_forma_pago) {
        this.id_forma_pago = id_forma_pago;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public double getCantidad_dias() {
        return cantidad_dias;
    }

    public void setCantidad_dias(double cantidad_dias) {
        this.cantidad_dias = cantidad_dias;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getInicia() {
        return inicia;
    }

    public void setInicia(int inicia) {
        this.inicia = inicia;
    }

    public String getUlt_vt() {
        return ult_vt;
    }

    public void setUlt_vt(String ult_vt) {
        this.ult_vt = ult_vt;
    }

    public String getPrcs() {
        return prcs;
    }

    public void setPrcs(String prcs) {
        this.prcs = prcs;
    }
}
