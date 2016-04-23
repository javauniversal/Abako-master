package co.dito.abako.abako.Entities;


import com.google.gson.annotations.SerializedName;

public class Frecuencia {

    @SerializedName("Code")
    private int code;

    @SerializedName("Description")
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
