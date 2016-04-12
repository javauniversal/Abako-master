package co.dito.abako.abako.Entities;


import java.util.List;

import io.realm.RealmObject;

public class CarteraResponseMasters extends RealmObject {

    private List<EstadoCartera> estadoCarteras;

    public List<EstadoCartera> getEstadoCarteras() {
        return estadoCarteras;
    }

    public void setEstadoCarteras(List<EstadoCartera> estadoCarteras) {
        this.estadoCarteras = estadoCarteras;
    }
}
