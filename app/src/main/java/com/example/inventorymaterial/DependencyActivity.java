package com.example.inventorymaterial;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.inventorymaterial.adapter.DependencyAdapter;

/**
 * Esta clase se encarga de proporcionar una lista de las dependencias.
 * @author Carlos Cruz Domínguez
 */

//Cuando decimos que es un listactivity tiene un objeto listview interno.
public class DependencyActivity extends ListActivity{

    //El CASO 1 usa un Adapter no personalizado.
    //private ArrayAdapter<Dependency> dependencies;
    //El CASO 2 usa un Adapter personalizado.
    private DependencyAdapter dependencies;


    @Override
    protected void onCreate (@Nullable Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_dependency);

        //CASO 1
        //Este ArrayAdapter es el que va a contener los datos que va a acargar el ListView.
        //dependencies = new ArrayAdapter<Dependency>(this, android.R.layout.simple_list_item_1, DependencyRepository.getInstance().getDependencies());
        //CASO 2
        dependencies = new DependencyAdapter(this);
        //Encuentra el ListView del layout debido a que le hemos puesto el ID obligatorio. Le añadimos el ADAPTER
        //al que irá a buscar los datos.
        getListView().setAdapter(dependencies);
    }
}
