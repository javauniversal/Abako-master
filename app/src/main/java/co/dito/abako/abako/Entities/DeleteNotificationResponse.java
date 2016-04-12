package co.dito.abako.abako.Entities;


import io.realm.RealmObject;

public class DeleteNotificationResponse extends RealmObject {

    private int msg_id;

    private String msg_str;

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
