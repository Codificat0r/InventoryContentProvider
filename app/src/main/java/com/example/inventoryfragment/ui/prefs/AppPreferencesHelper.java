package com.example.inventoryfragment.ui.prefs;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.inventoryfragment.ui.inventory.InventoryApplication;
import com.example.inventoryfragment.ui.utils.AppConstants;

/**
 * Created by usuario on 21/12/17.
 */

public class AppPreferencesHelper {

    private final SharedPreferences preferences;
    private static AppPreferencesHelper instance;
    private SharedPreferences.OnSharedPreferenceChangeListener listener;
    private String TAG="AppPreferencesHelper";

    public interface AppPreferencesListener {
        void onSharedPreferenceChanged();
    }

    private AppPreferencesHelper(final Context context) {
        preferences = ((Application) context.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE));
        listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

                Log.i(TAG, "onSharedPreferenceChanged: se ha cambiado la key: " + key);
            }
        };
    }

    public static AppPreferencesHelper getInstance() {
        if (instance == null)
            instance = new AppPreferencesHelper(InventoryApplication.getContext());
        return instance;
    }
}
