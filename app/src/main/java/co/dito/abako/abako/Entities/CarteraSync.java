package co.dito.abako.abako.Entities;

import com.google.gson.annotations.SerializedName;

public class CarteraSync  {

    @SerializedName("Fac")
    private int fac;

    @SerializedName("Venc")
    private String venc;

    @SerializedName("FechaFac")
    private String fecha_fac;

    @SerializedName("DiasVen")
    private int dias_ven;

    @SerializedName("Sld")
    private double sld;

    @SerializedName("Cuota")
    private int cuota;

    @SerializedName("PgsAbns ")
    private double pgs_abns;

    @SerializedName("Notas")
    private double notas;

    @SerializedName("Deducc")
    private double deducc;

    @SerializedName("Concep")
    private double concep;

    @SerializedName("Mora")
    private double mora;

    @SerializedName("Periodo")
    private String periodo;

    @SerializedName("Std")
    private String std;

    @SerializedName("IdEmp")
    private int id_emp;

    @SerializedName("NotaNoApli")
    private double nota_noApli;

    @SerializedName("SaldFv")
    private double sald_fv;

    @SerializedName("Prcs")
    private String prcs;


    public int getFac() {
        return fac;
    }

    public void setFac(int fac) {
        this.fac = fac;
    }

    public String getVenc() {
        return venc;
    }

    public void setVenc(String venc) {
        this.venc = venc;
    }

    public String getFecha_fac() {
        return fecha_fac;
    }

    public void setFecha_fac(String fecha_fac) {
        this.fecha_fac = fecha_fac;
    }

    public int getDias_ven() {
        return dias_ven;
    }

    public void setDias_ven(int dias_ven) {
        this.dias_ven = dias_ven;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public double getPgs_abns() {
        return pgs_abns;
    }

    public void setPgs_abns(double pgs_abns) {
        this.pgs_abns = pgs_abns;
    }

    public double getNotas() {
        return notas;
    }

    public void setNotas(double notas) {
        this.notas = notas;
    }

    public double getDeducc() {
        return deducc;
    }

    public void setDeducc(double deducc) {
        this.deducc = deducc;
    }

    public double getConcep() {
        return concep;
    }

    public void setConcep(double concep) {
        this.concep = concep;
    }

    public double getMora() {
        return mora;
    }

    public void setMora(double mora) {
        this.mora = mora;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public double getNota_noApli() {
        return nota_noApli;
    }

    public void setNota_noApli(double nota_noApli) {
        this.nota_noApli = nota_noApli;
    }

    public double getSald_fv() {
        return sald_fv;
    }

    public void setSald_fv(double sald_fv) {
        this.sald_fv = sald_fv;
    }

    public String getPrcs() {
        return prcs;
    }

    public void setPrcs(String prcs) {
        this.prcs = prcs;
    }

    public double getSld() {
        return sld;
    }

    public void setSld(double sld) {
        this.sld = sld;
    }

}
