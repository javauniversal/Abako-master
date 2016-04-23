package co.dito.abako.abako.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClientResponse {

    @SerializedName("Clientes")
    private List<ClienteSync> clientes;

    @SerializedName("Canales")
    private List<CanalSync> canales;

    @SerializedName("Zonas")
    private List<ZonaSync> zonas;

    @SerializedName("AtributosEspeciales")
    private List<AtributosEspecialesSync> atributos_especiales;

    @SerializedName("DefaultMasters")
    private ClientResponseMasters defaultMasters;

    @SerializedName("MsgId")
    private int msgiId;

    @SerializedName("MsgStr")
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
