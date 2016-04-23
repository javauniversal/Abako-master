package co.dito.abako.abako.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContactoResponse {

    @SerializedName("Contacto")
    private List<ContactoSync> contacto;

    @SerializedName("MsgId")
    private int msg_id;

    @SerializedName("MsgStr")
    private String msg_str;

    public List<ContactoSync> getContacto() {
        return contacto;
    }

    public void setContacto(List<ContactoSync> contacto) {
        this.contacto = contacto;
    }

    public int getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(int msg_id) {
        this.msg_id = msg_id;
    }

    public String getMsg_str() {
        return msg_str;
    }

    public void setMsg_str(String msg_str) {
        this.msg_str = msg_str;
    }

}
