package com.example.inventoryfragmentcontentprovider.ui.prefs;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;

import com.example.inventoryfragmentcontentprovider.R;

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
