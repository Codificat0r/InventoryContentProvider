package com.example.inventorymaterial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Esta clase carga el interfaz de la activity de Inventory
 * @author Carlos Cruz Domínguez
 */

public class InventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
    }
}
