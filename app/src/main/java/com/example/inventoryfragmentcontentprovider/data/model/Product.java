package com.example.inventoryfragmentcontentprovider.data.model;

/**
 * Created by usuario on 30/01/18.
 */

public class Product {

    private int _id;
    private String name;
    private String serial;
    private String vendor;
    private String model;
    private String description;
    private String price;
    private String buydate;
    private String url;
    private String notes;
    private int categoriaID;
    //Subcategoria es un INTEGER cualquiera, no figura en la BD como una tabla por lo que no
    //importa su valor
    private int subcategoriaID;
    private int tipoID;
    private int sectorID;
    private int dependencyID;

    public Product(int _id, String name, String serial, String vendor, String model, String description, String price, String buydate, String url, String notes, int categoriaID, int subcategoriaID, int tipoID, int dependencyID, int sectorID) {
        this._id = _id;
        this.name = name;
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.description = description;
        this.price = price;
        this.buydate = buydate;
        this.url = url;
        this.notes = notes;
        this.categoriaID = categoriaID;
        this.subcategoriaID = subcategoriaID;
        this.tipoID = tipoID;
        this.sectorID = sectorID;
        this.dependencyID = dependencyID;
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

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) {
        this.buydate = buydate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public int getSubcategoriaID() {
        return subcategoriaID;
    }

    public void setSubcategoriaID(int subcategoriaID) {
        this.subcategoriaID = subcategoriaID;
    }

    public int getTipoID() {
        return tipoID;
    }

    public void setTipoID(int tipoID) {
        this.tipoID = tipoID;
    }

    public int getSectorID() {
        return sectorID;
    }

    public void setSectorID(int sectorID) {
        this.sectorID = sectorID;
    }

    public int getDependencyID() {
        return dependencyID;
    }

    public void setDependencyID(int dependencyID) {
        this.dependencyID = dependencyID;
    }

    @Override
    public String toString() {
        return this.name + " | D -> " + this.dependencyID + " | S -> " + this.sectorID + " | Cat. -> " + this.categoriaID + " | Tipo -> " + this.tipoID;
    }
}
