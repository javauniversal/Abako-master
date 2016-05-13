package co.dito.abako.abako.Entities;

import java.util.List;

public class FiltroCartera {

    private List<Frecuencia> frecuenciaList;

    private List<ZonaSync> zonaSyncList;

    private List<CanalSync> canalSyncList;

    public List<Frecuencia> getFrecuenciaList() {
        return frecuenciaList;
    }

    public void setFrecuenciaList(List<Frecuencia> frecuenciaList) {
        this.frecuenciaList = frecuenciaList;
    }

    public List<ZonaSync> getZonaSyncList() {
        return zonaSyncList;
    }

    public void setZonaSyncList(List<ZonaSync> zonaSyncList) {
        this.zonaSyncList = zonaSyncList;
    }

    public List<CanalSync> getCanalSyncList() {
        return canalSyncList;
    }

    public void setCanalSyncList(List<CanalSync> canalSyncList) {
        this.canalSyncList = canalSyncList;
    }
}
