package com.example.inventoryfragmentcontentprovider.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Clase para almacenar los datos de un sector.
 * @author Carlos Cruz Domínguez
 */

public class Sector implements Parcelable{
    private int id;
    private String _name;
    private String _shortname;
    private String _description;
    private int _dependencyId;
    private String _imageName;
    private boolean _enabled;
    private boolean _default;

    public Sector(int id, String _name, String _shortname, String _description, int _dependencyId, boolean _enabled, boolean _default, String _imageName) {
        this.id = id;
        this._name = _name;
        this._shortname = _shortname;
        this._description = _description;
        this._dependencyId = _dependencyId;
        this._enabled = _enabled;
        this._default = _default;
        this._imageName = _imageName;

    }

    protected Sector(Parcel in) {
        id = in.readInt();
        _name = in.readString();
        _shortname = in.readString();
        _description = in.readString();
        _dependencyId = in.readInt();
        _enabled = in.readByte() != 0;
        _default = in.readByte() != 0;
    }

    public static final Creator<Sector> CREATOR = new Creator<Sector>() {
        @Override
        public Sector createFromParcel(Parcel in) {
            return new Sector(in);
        }

        @Override
        public Sector[] newArray(int size) {
            return new Sector[size];
        }
    };

    @Override
    public String toString() {
        return "Sector{" +
                "id=" + id +
                ", _name='" + _name + '\'' +
                ", _shortname='" + _shortname + '\'' +
                ", _description='" + _description + '\'' +
                ", _dependencyId=" + _dependencyId +
                ", _enabled=" + _enabled +
                ", _default=" + _default +
                '}';
    }

    public String get_imageName() {
        return _imageName;
    }

    public void set_imageName(String _imageName) {
        this._imageName = _imageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_shortname() {
        return _shortname;
    }

    public void set_shortname(String _shortname) {
        this._shortname = _shortname;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public int get_dependencyId() {
        return _dependencyId;
    }

    public void set_dependencyId(int _dependencyId) {
        this._dependencyId = _dependencyId;
    }

    public boolean is_enabled() {
        return _enabled;
    }

    public void set_enabled(boolean _enabled) {
        this._enabled = _enabled;
    }

    public boolean is_default() {
        return _default;
    }

    public void set_default(boolean _default) {
        this._default = _default;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeString(_name);
        dest.writeString(_shortname);
        dest.writeString(_description);
        dest.writeInt(_dependencyId);
        dest.writeByte((byte) (_enabled ? 1 : 0));
        dest.writeByte((byte) (_default ? 1 : 0));
    }
}
