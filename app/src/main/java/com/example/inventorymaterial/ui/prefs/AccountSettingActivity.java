package com.example.inventorymaterial.ui.prefs;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;

import com.example.inventorymaterial.R;

/**
 * Created by usuario on 2/11/17.
 */

public class AccountSettingActivity extends PreferenceActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.account_setting);
    }
}
