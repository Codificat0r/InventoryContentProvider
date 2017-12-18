package com.example.inventoryfragment.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.example.inventoryfragment.ui.inventory.InventoryApplication;
import com.example.inventoryfragment.ui.utils.AppConstants;

import java.util.Map;
import java.util.Set;

/**
 * Created by usuario on 4/12/17.
 */

public class AppPreferencesHelper implements AccountPreferencesHelper, GeneralPreferencesHelper {
    //1. Las constantes estan en las respectivas interfaces

    //2. Objeto para editar las dependencias
    private final SharedPreferences preferences = new SharedPreferences() {
        @Override
        public Map<String, ?> getAll() {
            return null;
        }

        @Nullable
        @Override
        public String getString(String key, @Nullable String defValue) {
            return null;
        }

        @Nullable
        @Override
        public Set<String> getStringSet(String key, @Nullable Set<String> defValues) {
            return null;
        }

        @Override
        public int getInt(String key, int defValue) {
            return 0;
        }

        @Override
        public long getLong(String key, long defValue) {
            return 0;
        }

        @Override
        public float getFloat(String key, float defValue) {
            return 0;
        }

        @Override
        public boolean getBoolean(String key, boolean defValue) {
            return false;
        }

        @Override
        public boolean contains(String key) {
            return false;
        }

        @Override
        public Editor edit() {
            return null;
        }

        @Override
        public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {

        }

        @Override
        public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {

        }
    };
    private static AppPreferencesHelper instance;

    private AppPreferencesHelper () {
        //Si es el fichero por defecto de las preferencias
        //this.preferences = InventoryApplication.getSharedPreferences();
    }

    public static AppPreferencesHelper getInstance() {
        if (instance == null)
            instance = new AppPreferencesHelper();
        return instance;
    }

    //ID SQLite
    public long getCurrentUserId() {
        long id = preferences.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return id;
    }

    public String getCurrentUserName() {
        String name = preferences.getString(PREF_KEY_CURRENT_USER_NAME, null);
        return name;
    }

    public String getCurrentUserPassword() {
        String password = preferences.getString(PREF_KEY_CURRENT_USER_PASSWORD, null);
        return password;
    }

    public boolean getCurrentUserRemember() {
        boolean remember = preferences.getBoolean(PREF_KEY_CURRENT_USER_REMEMBER, false);
        return remember;
    }

    //Modificamos por valores el fichero XML de preferencias de forma independiente. Solo usamos un apply.
    //Si modificaramos varios podriamos usar commit. Podriamos usar commit tambien pero es para
    public void setCurrentUserId(long id) {
        preferences.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply();
    }

    public void setCurrentUserName(String userName) {
        preferences.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply();
    }

    public void getCurrentUserPassword(String password) {
        preferences.edit().putString(PREF_KEY_CURRENT_USER_PASSWORD, password).apply();
    }

    public void getCurrentUserRemember(boolean remember) {
        preferences.edit().putBoolean(PREF_KEY_CURRENT_USER_REMEMBER, remember).apply();
    }
}
