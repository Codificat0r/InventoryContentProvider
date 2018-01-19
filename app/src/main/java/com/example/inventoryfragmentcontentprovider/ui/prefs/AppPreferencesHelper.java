package com.example.inventoryfragmentcontentprovider.ui.prefs;

/**
 * FALTA POR HACER LO DEL InventoryApplication.getContext()
 */

public class AppPreferencesHelper {

    /*private final SharedPreferences preferences;
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
    }*/
}
