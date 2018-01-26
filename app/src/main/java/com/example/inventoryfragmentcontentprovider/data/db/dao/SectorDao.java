package com.example.inventoryfragmentcontentprovider.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.inventoryfragmentcontentprovider.data.db.InventoryContract;
import com.example.inventoryfragmentcontentprovider.data.db.InventoryOpenHelper;
import com.example.inventoryfragmentcontentprovider.data.db.model.Sector;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by usuario on 25/01/18.
 */

public class SectorDao {
    public ArrayList<Sector> loadAll() {
        ArrayList<Sector> sectors = new ArrayList<>();
        boolean enabled = true;

        SQLiteDatabase db = InventoryOpenHelper.getInstance().openDatabase();
        Cursor c = db.query(InventoryContract.SectorEntry.TABLE_NAME, InventoryContract.SectorEntry.ALL_COLUMNS, null, null, null, null, null);

        if (c.moveToFirst()) {
            do {
                Sector tmp = new Sector(c.getInt(0), c.getString(2), c.getString(3), c.getString(4), c.getInt(1), enabled = !enabled, false, c.getString(5));
                sectors.add(tmp);
            } while (c.moveToNext());
        }

        InventoryOpenHelper.getInstance().closeDatabase();

        return sectors;
    }

    public long add(Sector sector) {
        SQLiteDatabase db = InventoryOpenHelper.getInstance().openDatabase();

        ContentValues contenido = new ContentValues();
        contenido.put(InventoryContract.SectorEntry.COLUMN_NAME, sector.get_name());
        contenido.put(InventoryContract.SectorEntry.COLUMN_SHORTNAME, sector.get_shortname());
        contenido.put(InventoryContract.SectorEntry.COLUMN_DESCRIPTION, sector.get_description());
        contenido.put(InventoryContract.SectorEntry.COLUMN_DEPENDENCYID, sector.get_dependencyId());
        contenido.put(InventoryContract.SectorEntry.COLUMN_IMAGENAME, sector.get_imageName());

        long value = db.insert(InventoryContract.SectorEntry.TABLE_NAME, null, contenido);

        InventoryOpenHelper.getInstance().closeDatabase();

        return value;
    }

    public long delete(Sector sector) {
        SQLiteDatabase db = InventoryOpenHelper.getInstance().openDatabase();

        long afectadas = db.delete(InventoryContract.SectorEntry.TABLE_NAME, BaseColumns._ID + "=" + sector.getId(), null);

        InventoryOpenHelper.getInstance().closeDatabase();

        return afectadas;
    }

    public long update(Sector sector) {
        SQLiteDatabase db = InventoryOpenHelper.getInstance().openDatabase();

        ContentValues contenido = new ContentValues();
        contenido.put(InventoryContract.SectorEntry.COLUMN_NAME, sector.get_name());
        contenido.put(InventoryContract.SectorEntry.COLUMN_SHORTNAME, sector.get_shortname());
        contenido.put(InventoryContract.SectorEntry.COLUMN_DESCRIPTION, sector.get_description());
        contenido.put(InventoryContract.SectorEntry.COLUMN_DEPENDENCYID, sector.get_dependencyId());
        contenido.put(InventoryContract.SectorEntry.COLUMN_IMAGENAME, sector.get_imageName());

        long afectadas = db.update(InventoryContract.SectorEntry.TABLE_NAME, contenido, BaseColumns._ID + "=" + sector.getId(),null);

        InventoryOpenHelper.getInstance().closeDatabase();

        return afectadas;
    }
}
