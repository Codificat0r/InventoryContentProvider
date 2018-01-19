package com.example.inventoryfragmentcontentprovider.ui.inventory;

import android.app.Application;
import android.content.Context;

import com.example.inventoryfragmentcontentprovider.data.db.model.InventoryOpenHelper;
import com.example.inventoryfragmentcontentprovider.data.prefs.AppPreferencesHelper;

/**
 * Esta clase sirve como contenedor de datos para cargar en un ListView.
 * @author Carlos Cruz Domínguez
 */

//Hay que añadirla en el manifest a <application> en su atrib. android:name=".InventoryApplication". ESta es la forma mala.
//Usamos esta clase para cargar datos en el ListView sin acceder a la base de datos. Lo añadimos al manifest para
//que como se crea una Application por defecto y es lo primero que se crea decimos que cree este Application
//para que esta clase sea el contexto de la aplicacion y poder acceder a esta.

public class InventoryApplication extends Application {
    private AppPreferencesHelper appPreferencesHelper;
    private InventoryOpenHelper inventoryOpenHelper;
    private static Context context;

    public InventoryApplication() {
        this.context = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appPreferencesHelper = AppPreferencesHelper.getInstance();
        InventoryOpenHelper.getInstance().openDatabase();
    }

    //public static SharedPreferences getSharedPreferences() {
        //return InventoryApplication.context.getSharedPreferences("Inventory_pref", MODE_PRIVATE);
    //}

    public static Context getContext() {
        return context;
    }

    public AppPreferencesHelper getAppPreferencesHelper() {
        return appPreferencesHelper;
    }

}

