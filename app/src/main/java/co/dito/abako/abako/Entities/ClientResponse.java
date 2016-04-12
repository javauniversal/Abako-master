package co.dito.abako.abako.Entities;

import java.util.List;

import io.realm.RealmObject;

public class ClientResponse extends RealmObject {

    private List<ClienteSync> clientes;

    private List<CanalSync> canales;

    private List<ZonaSync> zonas;

    private List<AtributosEspecialesSync> atributos_especiales;

    private ClientResponseMasters defaultMasters;

    private int msgiId;

    private String msg_str;

    public List<ClienteSync> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteSync> clientes) {
        this.clientes = clientes;
    }

    public List<CanalSync> getCanales() {
        return canales;
    }

    public void setCanales(List<CanalSync> canales) {
        this.canales = canales;
    }

    public List<ZonaSync> getZonas() {
        return zonas;
    }

    public void setZonas(List<ZonaSync> zonas) {
        this.zonas = zonas;
    }

    public List<AtributosEspecialesSync> getAtributos_especiales() {
        return atributos_especiales;
    }

    public void setAtributos_especiales(List<AtributosEspecialesSync> atributos_especiales) {
        this.atributos_especiales = atributos_especiales;
    }

    public ClientResponseMasters getDefaultMasters() {
        return defaultMasters;
    }

    public void setDefaultMasters(ClientResponseMasters defaultMasters) {
        this.defaultMasters = defaultMasters;
    }

    public int getMsgiId() {
        return msgiId;
    }

    public void setMsgiId(int msgiId) {
        this.msgiId = msgiId;
    }

    public String getMsg_str() {
        return msg_str;
    }

    public void setMsg_str(String msg_str) {
        this.msg_str = msg_str;
    }

}
