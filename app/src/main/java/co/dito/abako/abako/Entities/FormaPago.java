package co.dito.abako.abako.Entities;


import io.realm.RealmObject;

public class FormaPago extends RealmObject {

    private String code;

    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
