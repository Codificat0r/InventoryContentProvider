package com.example.inventoryfragmentcontentprovider.data.model;

/**
 * Contendrá la información del inner join de product con categoria y tipo ya que necesitamos obtener
 * el nombre de la categoria y el tipo no solo su ID para poder mostrarlo en la vista de detalles
 * de un producto por eso todo lo del SQLiteQueryBuilder, el ProjectionMap la asignacion de motes y el
 * inner join.
 */

public class ProductView {

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
    private String categoriaNombre;
    private int tipoID;
    private String tipoDescription;

    public ProductView(int _id, String name, String serial, String vendor, String model, String description, String price, String buydate, String url, String notes, int categoriaID, String categoriaNombre, int tipoID, String tipoDescription) {
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
        this.categoriaNombre = categoriaNombre;
        this.tipoID = tipoID;
        this.tipoDescription = tipoDescription;
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

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public int getTipoID() {
        return tipoID;
    }

    public void setTipoID(int tipoID) {
        this.tipoID = tipoID;
    }

    public String getTipoDescription() {
        return tipoDescription;
    }

    public void setTipoDescription(String tipoDescription) {
        this.tipoDescription = tipoDescription;
    }
}
