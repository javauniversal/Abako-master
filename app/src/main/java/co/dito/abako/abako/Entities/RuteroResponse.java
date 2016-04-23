package co.dito.abako.abako.Entities;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RuteroResponse {

    @SerializedName("Rutero")
    private List<RuteroSync> Rutero;

    @SerializedName("MsgId")
    private int MsgId;

    @SerializedName("MsgStr")
    private String MsgStr;

    public List<RuteroSync> getRutero() {
        return Rutero;
    }

    public void setRutero(List<RuteroSync> rutero) {
        Rutero = rutero;
    }

    public int getMsgId() {
        return MsgId;
    }

    public void setMsgId(int msgId) {
        MsgId = msgId;
    }

    public String getMsgStr() {
        return MsgStr;
    }

    public void setMsgStr(String msgStr) {
        MsgStr = msgStr;
    }
}
