package com.example.inventoryfragmentcontentprovider.data.db.model;

/**
 * Created by usuario on 30/01/18.
 */

public class Tipo {
    private int _id;
    private String name;

    public Tipo(int _id, String name) {
        this._id = _id;
        this.name = name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
