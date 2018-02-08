package com.example.inventoryfragmentcontentprovider.data.provider.dao;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.inventoryfragmentcontentprovider.data.base.DependencyDao;
import com.example.inventoryfragmentcontentprovider.data.db.InventoryContract;
import com.example.inventoryfragmentcontentprovider.data.db.InventoryOpenHelper;
import com.example.inventoryfragmentcontentprovider.data.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.provider.InventoryProviderContract;
import com.example.inventoryfragmentcontentprovider.ui.inventory.InventoryApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Dao PARA EL CONTENT PROVIDER
 */

public class DependencyDaoImpl implements DependencyDao {
    @Override
    public ArrayList<Dependency> loadAll() {
        ArrayList<Dependency> dependencies = new ArrayList<>();

        //1. Array projection, que datos queremos.
        String[] projection = {
                InventoryProviderContract.Dependency._ID,
                InventoryProviderContract.Dependency.NAME,
                InventoryProviderContract.Dependency.SHORTNAME,
                InventoryProviderContract.Dependency.DESCRIPTION,
                InventoryProviderContract.Dependency.IMAGENAME
        };

        //2. Hago la consulta al provider con la Uri de Dependency.
        //El Content Provider está registrado en el sistema porque en el manifest
        //le hemos dicho que lo registre.

        //Todos los ContentProvider están manejados por el ContentResolver
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();
        Cursor c = cr.query(InventoryProviderContract.Dependency.CONTENT_URI, projection, null,null,null,null);

        if (c.moveToFirst()) {
            do {
                Dependency tmp = new Dependency(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
                dependencies.add(tmp);
            } while (c.moveToNext());
        }

        return dependencies;
    }

    @Override
    public long add(Dependency dependency) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();
        Uri uri = cr.insert(InventoryProviderContract.Dependency.CONTENT_URI, createContentValue(dependency));

        if (uri == null)
            return -1;
        //Si ha añadido correctamente devuelve el ID de la nueva dependencia añadida en la ultima parte
        //de la uri devuelta. Automaticamente al crearnos la base de datos nos crea un ID, aunque no lo tenga
        //nuestra tabla y aunque no sea clave primaria, para que el lleve una cuenta de todos los registros.
        return Long.parseLong(uri.getLastPathSegment());
    }

    @Override
    public boolean exists(Dependency dependency) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();

        String[] projection = {
                InventoryProviderContract.Dependency._ID,
                InventoryProviderContract.Dependency.NAME,
                InventoryProviderContract.Dependency.SHORTNAME,
                InventoryProviderContract.Dependency.DESCRIPTION,
                InventoryProviderContract.Dependency.IMAGENAME
        };

        Cursor c = cr.query(InventoryProviderContract.Dependency.CONTENT_URI, projection, BaseColumns._ID + "=" + dependency.get_ID(),null,null,null);

        if (c.moveToFirst())
            return true;
        return false;

    }

    @Override
    public long delete(Dependency dependency) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();
        return cr.delete(InventoryProviderContract.Dependency.CONTENT_URI, BaseColumns._ID + "=" + dependency.get_ID(), null);
    }

    @Override
    public long update(Dependency dependency) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();
        String where = InventoryContract.DependencyEntry._ID + "=" + dependency.get_ID();
        return cr.update(InventoryProviderContract.Dependency.CONTENT_URI, createContentValue(dependency), where, null);
    }

    private ContentValues createContentValue(Dependency dependency) {

        ContentValues datosColumnas = new ContentValues();
        datosColumnas.put(InventoryContract.DependencyEntry.COLUMN_NAME, dependency.getName());
        datosColumnas.put(InventoryContract.DependencyEntry.COLUMN_SHORTNAME, dependency.getShortname());
        datosColumnas.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION, dependency.getDescription());
        datosColumnas.put(InventoryContract.DependencyEntry.COLUMN_IMAGENAME, dependency.getImageName());

        return datosColumnas;
    }
}
