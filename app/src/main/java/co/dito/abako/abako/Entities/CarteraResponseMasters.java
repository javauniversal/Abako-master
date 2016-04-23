package co.dito.abako.abako.Entities;


import com.google.gson.annotations.SerializedName;

import java.util.List;
public class CarteraResponseMasters {

    @SerializedName("EstadoCartera")
    private List<EstadoCartera> estadoCarteras;

    public List<EstadoCartera> getEstadoCarteras() {
        return estadoCarteras;
    }

    public void setEstadoCarteras(List<EstadoCartera> estadoCarteras) {
        this.estadoCarteras = estadoCarteras;
    }
}
