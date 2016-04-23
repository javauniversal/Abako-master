package co.dito.abako.abako.Entities;

import com.google.gson.annotations.SerializedName;

public class ContactoSync {

    @SerializedName("IdCnto")
    private int id_cnto;

    @SerializedName("IdEmp")
    private int id_emp;

    @SerializedName("Nmbr")
    private String nmbr;

    @SerializedName("Dir")
    private String dir;

    @SerializedName("IdCdd")
    private int id_cdd;

    @SerializedName("Tel")
    private String tel;

    @SerializedName("mail")
    private String mail;

    @SerializedName("Pdt")
    private int pdt;

    @SerializedName("Tipo")
    private String tipo;

    @SerializedName("Prcs")
    private String prcs;


    public int getId_cnto() {
        return id_cnto;
    }

    public void setId_cnto(int id_cnto) {
        this.id_cnto = id_cnto;
    }

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public String getNmbr() {
        return nmbr;
    }

    public void setNmbr(String nmbr) {
        this.nmbr = nmbr;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getId_cdd() {
        return id_cdd;
    }

    public void setId_cdd(int id_cdd) {
        this.id_cdd = id_cdd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPdt() {
        return pdt;
    }

    public void setPdt(int pdt) {
        this.pdt = pdt;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrcs() {
        return prcs;
    }

    public void setPrcs(String prcs) {
        this.prcs = prcs;
    }
}
