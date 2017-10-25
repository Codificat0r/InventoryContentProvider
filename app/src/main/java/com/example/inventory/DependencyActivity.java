package com.example.inventory;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import com.example.inventory.pojo.Dependency;

/**
 * Esta clase se encarga de proporcionar una lista de las dependencias.
 * @author Carlos Cruz Domínguez
 */

//Cuando decimos que es un listactivity tiene un objeto listview interno.
public class DependencyActivity extends ListActivity{

    private ArrayAdapter<Dependency> dependencies;

    @Override
    protected void onCreate (@Nullable Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_dependency);


        //Este ArrayAdapter es el que va a contener los datos que va a acargar el ListView.
        dependencies = new ArrayAdapter<Dependency>(this, android.R.layout.simple_list_item_1, ((InventoryApplication)getApplicationContext()).getDependencies());
        //Encuentra el ListView del layout debido a que le hemos puesto el ID obligatorio. Le añadimos el ADAPTER
        //al que irá a buscar los datos.
        getListView().setAdapter(dependencies);
    }
}
