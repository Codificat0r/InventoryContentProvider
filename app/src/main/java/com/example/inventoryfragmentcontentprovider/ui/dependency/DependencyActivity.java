package com.example.inventoryfragmentcontentprovider.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.inventoryfragmentcontentprovider.R;
import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.db.model.InventoryOpenHelper;
import com.example.inventoryfragmentcontentprovider.data.db.repository.DependencyRepository;
import com.example.inventoryfragmentcontentprovider.ui.inventory.InventoryApplication;
import com.example.inventoryfragmentcontentprovider.ui.utils.AddEdit;

/**
 * Esta clase se encarga de proporcionar una lista de las dependencias.
 * @author Carlos Cruz Domínguez
 */

//Cuando decimos que es un listactivity tiene un objeto listview interno.
public class DependencyActivity extends AppCompatActivity implements ListDependency.ListDependencyListener, AddEditDependency.AddEditDependencyListener {
    private ListDependency listDependency;
    //Debido a que se inicializa aqui, cuando hay un cambio de configuracion que hace que se elimine y se vuelva
    //a crear la lista, la ListDependency pierde su presenter. Para ello o inicializamos el presenter en el mismo
    //fragment, es decir, en el ListActivity, o simplemente guardamos el estado con onSaveInstanceState. Vamos a
    //hacerlo de la primera manera manera.
    //private ListDependencyPresenter listDependencyPresenter;
    private Fragment detailDependency;
    private AddEditDependency addEditDependency;
    //Lo mismo para este presenter. Cada fragment se encargará de su presenter
    //private AddEditDependencyPresenter addEditDependencyPresenter;

    @Override
    protected void onCreate (@Nullable Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_dependency);
        chargeList();
        InventoryOpenHelper.getInstance().openDatabase();
    }

    private void chargeList() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        //1. Se crea la vista
        listDependency = (ListDependency) fragmentManager.findFragmentByTag(ListDependency.TAG);
        if (listDependency == null) {
            listDependency = ListDependency.newInstance(null);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(android.R.id.content, listDependency, ListDependency.TAG);
            fragmentTransaction.commit();
        }

        //Ver nota arriba
        //2. Se crea el presentador, y se le pasa en el constructor la vista correspondiente
        //listDependencyPresenter = new ListDependencyPresenter(listDependency);

        //3. Si necesitamos, se asigna el presentador a su fragment. A veces es necesario y a veces no.
        //listDependency.setPresenter(listDependencyPresenter);
    }

    @Override
    public void addNewDependency(Bundle bundle) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        //1. Se crea la vista
        addEditDependency = (AddEditDependency) fragmentManager.findFragmentByTag(AddEditDependency.TAG);
        if (addEditDependency == null) {
            addEditDependency = AddEditDependency.newInstance(bundle);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(android.R.id.content, addEditDependency, AddEditDependency.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else {
            if (bundle != null) {
                addEditDependency.setArguments(bundle);
                AddEditDependency.mode.setMode(AddEdit.EDIT_MODE);
            } else {
                AddEditDependency.mode.setMode(AddEdit.ADD_MODE);
            }
        }

        //Ver nota arriba
        //2. Se crea el presentador, y se le pasa en el constructor la vista correspondiente
        //addEditDependencyPresenter = new AddEditDependencyPresenter(addEditDependency);

        //3. Si necesitamos, se asigna el presentador a su fragment.
        //addEditDependency.setPresenter(addEditDependencyPresenter);
    }

    @Override
    public void editDependency(Dependency dependency) {
        DependencyRepository.getInstance().getDependencies().add(dependency);
    }

    @Override
    public void returnToList() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        //Sacamos el fragment de AddEditDependency que estará en primer lugar para que se muestre el que esta despues,
        //es decir, el de la lista. Así no podremos volver atrás y que se muestre el fragment addeditdependency otra
        //vez con los datos antiguos
        fragmentManager.popBackStack();
    }
}
