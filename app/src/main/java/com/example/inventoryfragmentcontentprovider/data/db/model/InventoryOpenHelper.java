package com.example.inventoryfragmentcontentprovider.data.db.model;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.inventoryfragmentcontentprovider.data.db.InventoryContract;
import com.example.inventoryfragmentcontentprovider.ui.inventory.InventoryApplication;

/**
 * Created by usuario on 19/01/18.
 */

public class InventoryOpenHelper extends SQLiteOpenHelper {

    private static InventoryOpenHelper singleton;
    private SQLiteDatabase sqLiteDatabase;

    static {
        singleton = new InventoryOpenHelper();
    }

    //Necesita el contexto de LA APLICACION.
    private InventoryOpenHelper() {
        super(InventoryApplication.getContext(), InventoryContract.DATABASE_NAME, null, InventoryContract.DATABASE_VERSION);
    }

    public static InventoryOpenHelper getInstance() {
        return singleton;
    }

    //Cuando se crea la base de datos
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*sqLiteDatabase.execSQL(InventoryContract.DependencyEntry.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(InventoryContract.DependencyEntry.SQL_INSERT_ENTRIES);
        sqLiteDatabase.execSQL(InventoryContract.SectorEntry.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(InventoryContract.SectorEntry.SQL_INSERT_ENTRIES);*/
    }

    public void openDatabase() {
        sqLiteDatabase = singleton.getWritableDatabase();
        try {
            //Borramos las tablas en el orden correcto para despues poder volver a crearlas.
            sqLiteDatabase.execSQL(InventoryContract.SectorEntry.SQL_DELETE_ENTRIES);
            sqLiteDatabase.execSQL(InventoryContract.DependencyEntry.SQL_DELETE_ENTRIES);
            //Creamos e insertamos los datos en las tablas.
            sqLiteDatabase.execSQL(InventoryContract.DependencyEntry.SQL_CREATE_ENTRIES);
            sqLiteDatabase.execSQL(InventoryContract.DependencyEntry.SQL_INSERT_ENTRIES);
            sqLiteDatabase.execSQL(InventoryContract.SectorEntry.SQL_CREATE_ENTRIES);
            sqLiteDatabase.execSQL(InventoryContract.SectorEntry.SQL_INSERT_ENTRIES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Cuando incrementamos la version respecto a la anterior
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=1");
            }
        }
    }
}
