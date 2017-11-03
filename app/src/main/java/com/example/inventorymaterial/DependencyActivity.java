package com.example.inventorymaterial;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.inventorymaterial.adapter.DependencyAdapter;

/**
 * Esta clase se encarga de proporcionar una lista de las dependencias.
 * @author Carlos Cruz Domínguez
 */

//Cuando decimos que es un listactivity tiene un objeto listview interno.
public class DependencyActivity extends AppCompatActivity{

    //El CASO 1 usa un Adapter no personalizado.
    //private ArrayAdapter<Dependency> dependencies;
    //El CASO 2 usa un Adapter personalizado.
    private DependencyAdapter dependencies;
    private ListView listView;
    private FloatingActionButton fab;
    private CoordinatorLayout coordinatorLayout;


    @Override
    protected void onCreate (@Nullable Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_dependency);

        //CASO 1
        //Este ArrayAdapter es el que va a contener los datos que va a acargar el ListView.
        //dependencies = new ArrayAdapter<Dependency>(this, android.R.layout.simple_list_item_1, DependencyRepository.getInstance().getDependencies());
        //CASO 2
        //Tiene el ID del android obligatorio la lista por lo que lo encontramos en android.R.id....
        listView = (ListView)findViewById(android.R.id.list);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator);
        setSupportActionBar(toolbar);
        dependencies = new DependencyAdapter(this);
        //Encuentra el ListView del layout debido a que le hemos puesto el ID obligatorio. Le añadimos el ADAPTER
        //al que irá a buscar los datos.
        listView.setAdapter(dependencies);
        //Al pulsar sobre el boton se visualizara el SnackBar y FAB se desplazara hacia arriba
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(coordinatorLayout, "Ejemplo Snackbar", Snackbar.LENGTH_SHORT).show();
                startActivity(new Intent(DependencyActivity.this, AddDependencyActivity.class));
            }
        });
    }
}
