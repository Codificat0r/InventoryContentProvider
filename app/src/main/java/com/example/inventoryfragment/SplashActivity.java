package com.example.inventoryfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Esta clase da soporte de código a la activity del spalsh, la pantalla de espera a que carguen los datos.
 * @author Carlos Cruz Domínguez
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
