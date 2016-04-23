package co.dito.abako.abako.Entities;

import com.google.gson.annotations.SerializedName;

public class JsonCompress {

    @SerializedName("Content")
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}
