package co.dito.abako.abako.Entities;


import io.realm.RealmObject;

public class EstadoCartera extends RealmObject {

    private int code;

    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
