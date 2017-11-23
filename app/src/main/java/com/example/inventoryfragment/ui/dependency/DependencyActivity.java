package com.example.inventoryfragment.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryfragment.ui.dependency.presenter.AddEditDependencyPresenter;
import com.example.inventoryfragment.ui.dependency.presenter.ListDependencyPresenter;

/**
 * Esta clase se encarga de proporcionar una lista de las dependencias.
 * @author Carlos Cruz Domínguez
 */

//Cuando decimos que es un listactivity tiene un objeto listview interno.
public class DependencyActivity extends AppCompatActivity implements ListDependency.ListDependencyListener{
    private ListDependency listDependency;
    private ListDependencyPresenter listDependencyPresenter;
    private Fragment detailDependency;
    private AddEditDependency addEditDependency;
    private AddEditDependencyPresenter addEditDependencyPresenter;

    @Override
    protected void onCreate (@Nullable Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_dependency);
        FragmentManager fragmentManager = getSupportFragmentManager();
        //1. Se crea la vista
        listDependency = (ListDependency) fragmentManager.findFragmentByTag(ListDependency.TAG);
        if (listDependency == null) {
            listDependency = ListDependency.newInstance(null);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(android.R.id.content, listDependency, ListDependency.TAG);
            fragmentTransaction.commit();
        }
        //2. Se crea el presentador, y se le pasa en el constructor la vista correspondiente
        listDependencyPresenter = new ListDependencyPresenter(listDependency);

        //3. Si necesitamos, se asigna el presentador a su fragment. A veces es necesario y a veces no.
        listDependency.setPresenter(listDependencyPresenter);
    }

    @Override
    public void addNewDependency() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        //1. Se crea la vista
        addEditDependency = (AddEditDependency) fragmentManager.findFragmentByTag(AddEditDependency.TAG);
        if (addEditDependency == null) {
            addEditDependency = AddEditDependency.newInstance(null);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(android.R.id.content, addEditDependency, AddEditDependency.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        //2. Se crea el presentador, y se le pasa en el constructor la vista correspondiente
        addEditDependencyPresenter = new AddEditDependencyPresenter(addEditDependency);

        //3. Si necesitamos, se asigna el presentador a su fragment.
        addEditDependency.setPresenter(addEditDependencyPresenter);
    }
}
