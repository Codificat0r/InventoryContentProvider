package com.example.inventoryfragment.ui.inventory;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.inventoryfragment.data.prefs.AppPreferencesHelper;

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
    private static Context context;

    public InventoryApplication() {
        //InventoryApplication.context = getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appPreferencesHelper = AppPreferencesHelper.getInstance();
    }

    //public static SharedPreferences getSharedPreferences() {
        //return InventoryApplication.context.getSharedPreferences("Inventory_pref", MODE_PRIVATE);
    //}

    public AppPreferencesHelper getAppPreferencesHelper() {
        return appPreferencesHelper;
    }

}

