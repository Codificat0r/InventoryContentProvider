package com.example.inventoryfragmentcontentprovider.ui.base;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by usuario on 13/11/17.
 */

public class BaseActivity extends AppCompatActivity{
    public void onError(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }

    public void onError(int resId) {
        //Obtenemos el recurso string mediante su ID.
        Snackbar.make(findViewById(android.R.id.content), getResources().getString(resId), Snackbar.LENGTH_SHORT).show();
    }

}
