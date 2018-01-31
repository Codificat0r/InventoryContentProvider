package com.example.inventoryfragmentcontentprovider.data.db.dao;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.inventoryfragmentcontentprovider.data.db.InventoryContract;
import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.db.InventoryOpenHelper;
import com.example.inventoryfragmentcontentprovider.data.db.repository.DependencyRepository;
import com.example.inventoryfragmentcontentprovider.ui.dependency.ListDependency;
import com.example.inventoryfragmentcontentprovider.ui.inventory.InventoryApplication;
import com.example.inventoryfragmentcontentprovider.ui.utils.CommonUtils;

import java.util.ArrayList;

/**
 * Created by usuario on 22/01/18.
 */

public class DependencyDao {

    /**
     * Método que devuelve un cursor con todas las dependencias de la base de datos.
     * @return
     */
    public ArrayList<Dependency> loadAll() {
        ArrayList<Dependency> arrayList = new ArrayList<>();

        //EL selection y selectionArgs es el WHERE
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        Cursor cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME,
                InventoryContract.DependencyEntry.ALL_COLUMNS,
                null, null, null,null,
                InventoryContract.DependencyEntry.DEFAULT_SORT, null);

        if (cursor.moveToFirst()) {

            do {
                Dependency tmp = new Dependency(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                arrayList.add(tmp);
                try {
                    //EN EL INTERACTOR CUANDO SE PIDAN LOS DATOS SE PIDEN CON UN ASYNCTASK. SE DUERME
                    //AQUI EL HILO DEL ASYNC TASK. SE MUESTRA EL PROGRESS DIALOG DICIENDOLE DESDE EL PRESENTER
                    //A LA VISTA QUE LO HAGA
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }

        //La base de datos se cierra al final.
        InventoryOpenHelper.getInstance().closeDatabase();

        return arrayList;
    }

    public long add(Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();

        ContentValues datosColumnas = new ContentValues();
        datosColumnas.put(InventoryContract.DependencyEntry.COLUMN_NAME, dependency.getName());
        datosColumnas.put(InventoryContract.DependencyEntry.COLUMN_SHORTNAME, dependency.getShortname());
        datosColumnas.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION, dependency.getDescription());
        datosColumnas.put(InventoryContract.DependencyEntry.COLUMN_IMAGENAME, dependency.getImageName());

        //Devuelve el ID de la fila insertada
        long id = sqLiteDatabase.insert(InventoryContract.DependencyEntry.TABLE_NAME, null, datosColumnas);

        InventoryOpenHelper.getInstance().closeDatabase();

        return id;
    }

    public boolean exists(Dependency dependency) {
        ArrayList<Dependency> arrayList = new ArrayList<>();

        //EL selecetion y selectionArgs es el WHERE
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        Cursor cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME,
                InventoryContract.DependencyEntry.ALL_COLUMNS,
                BaseColumns._ID + "=" + dependency.get_ID(), null, null,null,
                InventoryContract.DependencyEntry.DEFAULT_SORT, null);

        if (cursor.moveToFirst()) {
            do {
                Dependency tmp = new Dependency(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                arrayList.add(tmp);
            } while (cursor.moveToNext());
        }

        //La base de datos se cierra al final.
        InventoryOpenHelper.getInstance().closeDatabase();

        if (arrayList.size() > 0)
            return true;
        return false;
    }

    public long delete (Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();

        long id = sqLiteDatabase.delete(InventoryContract.DependencyEntry.TABLE_NAME, BaseColumns._ID + "=" + dependency.get_ID(), null);
        return id;
    }

    public long update(Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();

        ContentValues datosColumnas = new ContentValues();

        datosColumnas.put(InventoryContract.DependencyEntry.COLUMN_NAME, dependency.getName());
        datosColumnas.put(InventoryContract.DependencyEntry.COLUMN_SHORTNAME, dependency.getShortname());
        datosColumnas.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION, dependency.getDescription());
        datosColumnas.put(InventoryContract.DependencyEntry.COLUMN_IMAGENAME, dependency.getImageName());


        //Devuelve el ID de la fila insertada
        long id = sqLiteDatabase.update(InventoryContract.DependencyEntry.TABLE_NAME, datosColumnas, BaseColumns._ID + "=" + dependency.get_ID(), null);

        InventoryOpenHelper.getInstance().closeDatabase();

        return id;
    }
}
