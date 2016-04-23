package co.dito.abako.abako.Entities;

import com.google.gson.annotations.SerializedName;

public class FormaPago {

    @SerializedName("Code")
    private String code;

    @SerializedName("Description")
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
