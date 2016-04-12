package co.dito.abako.abako.Entities;


import io.realm.RealmObject;

public class AtributosEspecialesSync extends RealmObject {

    private int id_emp;

    private int id_tipo;

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
