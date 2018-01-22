package com.example.inventoryfragmentcontentprovider.data.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.inventoryfragmentcontentprovider.data.db.InventoryContract;
import com.example.inventoryfragmentcontentprovider.data.db.model.InventoryOpenHelper;

/**
 * Created by usuario on 22/01/18.
 */

public class DependencyDao {

    /**
     * Método que devuelve un cursor con todas las dependencias de la base de datos.
     * @return
     */
    public Cursor loadAll() {
        //EL selecetion y selectionArgs es el WHERE
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        Cursor cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME,
                             InventoryContract.DependencyEntry.ALL_COLUMNS,
                             null, null, null,null,
                             InventoryContract.DependencyEntry.DEFAULT_SORT, null);
        InventoryOpenHelper.getInstance().closeDatabase();
        return cursor;
    }
}
