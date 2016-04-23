package co.dito.abako.abako.Entities;


import com.google.gson.annotations.SerializedName;

public class Inicia {

    @SerializedName("Code")
    public int code;

    @SerializedName("Description")
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
