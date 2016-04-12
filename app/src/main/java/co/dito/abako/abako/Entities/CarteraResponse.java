package co.dito.abako.abako.Entities;

import java.util.List;
import io.realm.RealmObject;

public class CarteraResponse extends RealmObject {

    private List<CarteraSync> cartera;

    private CarteraResponseMasters default_masters;

    private int msg_id;

    private String msg_str;

    public List<CarteraSync> getCartera() {
        return cartera;
    }

    public void setCartera(List<CarteraSync> cartera) {
        this.cartera = cartera;
    }

    public CarteraResponseMasters getDefault_masters() {
        return default_masters;
    }

    public void setDefault_masters(CarteraResponseMasters default_masters) {
        this.default_masters = default_masters;
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
