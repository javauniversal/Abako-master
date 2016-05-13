package co.dito.abako.abako.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ClienteSync {

    @SerializedName("IdEmpresa")
    private int id_empresa;

    @SerializedName("Razon_Social")
    private String razon_social;

    @SerializedName("Nombre_Comun")
    private String nombre_comun;

    @SerializedName("Identificacion")
    private String identificacion;

    @SerializedName("Codigo")
    private String codigo;

    @SerializedName("IdCanal")
    private int id_canal;

    @SerializedName("IdZona")
    private int id_zona;

    @SerializedName("IdLista_Precio")
    private int id_lista_precio;

    @SerializedName("Longitud")
    private double longitud;

    @SerializedName("Latitud")
    private double latitud;

    @SerializedName("IdFormaPago")
    private int id_forma_pago;

    @SerializedName("Cupo")
    private int cupo;

    @SerializedName("Cantidad_Dias")
    private double cantidad_dias;

    @SerializedName("Frecuencia")
    private int frecuencia;

    @SerializedName("Inicia")
    private int inicia;

    @SerializedName("UltVt")
    private String ult_vt;

    @SerializedName("ultmpg")
    private double ultmpg;

    @SerializedName("Fchltmpg")
    private String Fchltmpg;

    @SerializedName("Prcs")
    private String prcs;

    private double suma_factura;

    private String direccion;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSuma_factura() {
        return suma_factura;
    }

    public void setSuma_factura(double suma_factura) {
        this.suma_factura = suma_factura;
    }

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

    public double getUltmpg() {
        return ultmpg;
    }

    public void setUltmpg(double ultmpg) {
        this.ultmpg = ultmpg;
    }

    public String getFchltmpg() {
        return Fchltmpg;
    }

    public void setFchltmpg(String fchltmpg) {
        Fchltmpg = fchltmpg;
    }
}
