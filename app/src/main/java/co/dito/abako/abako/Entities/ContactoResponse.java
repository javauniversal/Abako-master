package co.dito.abako.abako.Entities;

import java.util.List;

import io.realm.RealmObject;

public class ContactoResponse extends RealmObject {

    private List<ContactoSync> contacto;

    private int msg_id;

    private String msg_str;

}
