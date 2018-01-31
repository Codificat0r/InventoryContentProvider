package com.example.inventoryfragmentcontentprovider.data.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.inventoryfragmentcontentprovider.ui.inventory.InventoryApplication;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by usuario on 19/01/18.
 */

public class InventoryOpenHelper extends SQLiteOpenHelper {

    //Volatile le dice a los hilos que no copie el
    //valor ya que debe ser el mismo para cada hilo. No
    //realices una copia, usa siempre el mismo.
    private volatile static InventoryOpenHelper singleton;
    private SQLiteDatabase sqLiteDatabase;
    private AtomicInteger openCounter = new AtomicInteger();

    static {
        singleton = new InventoryOpenHelper();
    }

    //Necesita el contexto de LA APLICACION.
    private InventoryOpenHelper() {
        super(InventoryApplication.getContext(), InventoryContract.DATABASE_NAME, null, InventoryContract.DATABASE_VERSION);
    }

    public synchronized static InventoryOpenHelper getInstance() {
        return singleton;
    }

    //Cuando se crea la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Debe ser una transaccion, o se hace todo o no se hace. EN EL EXAMEN LO QUIERE ASI, EL ONCREATE CON TRANSACCIONES
        //Y EL UPGRADE CON EL BORRADO DE TABLAS CON TRANSACCIONES.
        try {
            db.beginTransaction();
            //Creamos e insertamos los datos en las tablas.
            db.execSQL(InventoryContract.CategoriaEntry.SQL_CREATE_ENTRIES);
            db.execSQL(InventoryContract.CategoriaEntry.SQL_INSERT_ENTRIES);
            db.execSQL(InventoryContract.TipoEntry.SQL_CREATE_ENTRIES);
            db.execSQL(InventoryContract.TipoEntry.SQL_INSERT_ENTRIES);
            db.execSQL(InventoryContract.ProductEntry.SQL_CREATE_ENTRIES);
            db.execSQL(InventoryContract.ProductEntry.SQL_INSERT_ENTRIES);
            db.execSQL(InventoryContract.DependencyEntry.SQL_CREATE_ENTRIES);
            db.execSQL(InventoryContract.DependencyEntry.SQL_INSERT_ENTRIES);
            db.execSQL(InventoryContract.SectorEntry.SQL_CREATE_ENTRIES);
            db.execSQL(InventoryContract.SectorEntry.SQL_INSERT_ENTRIES);
            db.setTransactionSuccessful();
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public synchronized SQLiteDatabase openDatabase() {
        if (openCounter.incrementAndGet() == 1) {
            //Debiado a que pedir que se abra la cierra y abre puede que haya otros hilos que
            //esten trabajando ya con una y no es correcto que se cierre, debemos tener un control
            sqLiteDatabase = singleton.getWritableDatabase();
        }
        return sqLiteDatabase;
    }

    public synchronized void closeDatabase() {
        //Quiere decir que eres el ultimo hilo que llamó a openDatabase, pues ya no hay mas que quieran usarla, cierralo.
        if (openCounter.decrementAndGet() == 0) {
            sqLiteDatabase.close();
        }
    }

    //Cuando incrementamos la version respecto a la anterior
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try {
            db.beginTransaction();
            //Borramos las tablas en el orden correcto para despues poder volver a crearlas.
            db.execSQL(InventoryContract.CategoriaEntry.SQL_DELETE_ENTRIES);
            db.execSQL(InventoryContract.TipoEntry.SQL_DELETE_ENTRIES);
            db.execSQL(InventoryContract.ProductEntry.SQL_DELETE_ENTRIES);
            db.execSQL(InventoryContract.DependencyEntry.SQL_DELETE_ENTRIES);
            db.execSQL(InventoryContract.SectorEntry.SQL_DELETE_ENTRIES);
            onCreate(db);
            db.setTransactionSuccessful();
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
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
