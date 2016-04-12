package co.dito.abako.abako.Entities;


import io.realm.RealmObject;

public class AtributosEspeciales extends RealmObject {

    public int code;

    public String description;

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
