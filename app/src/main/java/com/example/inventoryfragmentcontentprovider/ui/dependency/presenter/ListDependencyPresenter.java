package com.example.inventoryfragmentcontentprovider.ui.dependency.presenter;

import android.view.ActionMode;

import com.example.inventoryfragmentcontentprovider.adapter.DependencyAdapter;
import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;
import com.example.inventoryfragmentcontentprovider.ui.dependency.Interactor.ListDependencyInteractorImpl;
import com.example.inventoryfragmentcontentprovider.ui.dependency.contract.ListDependencyContract;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by usuario on 23/11/17.
 */

//Como no tiene muchos tipos, sino solo 2, pues simplemente lo ponemos serializable.

public class ListDependencyPresenter implements ListDependencyContract.Presenter, ListDependencyInteractorImpl.OnLoadFinishedListener, Serializable{
    private ListDependencyContract.View view;
    private ListDependencyInteractorImpl listDependencyInteractorImpl = new ListDependencyInteractorImpl(this);

    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.view = view;
    }

    @Override
    public void loadDependency() {
        view.showProgressDialog("Cargando dependencias . . .");
        listDependencyInteractorImpl.getAllDependencies();
    }

    @Override
    public void deleteDependency(Dependency dependency) {
        listDependencyInteractorImpl.deleteDependency(dependency);
    }

    @Override
    public void orderByName() {
        listDependencyInteractorImpl.orderByName();
    }

    @Override
    public void orderById() {
        listDependencyInteractorImpl.orderById();
    }

    //Este metodo lo llama el interactor cuando el listado de dependencias esté listo. Despues se avisa a la lista para
    //que lo cargue
    @Override
    public void onSuccess(List<Dependency> list) {
        view.dismissProgressDialog();
        view.showDependency(list);
    }

    @Override
    public void onSuccessDelete(List<Dependency> list) {
        view.showDependency(list);
    }

    @Override
    public void onSuccessOrder(List<Dependency> list) {
        view.showDependency(list);
    }

    @Override
    public void onDatabaseError(Error error) {
        view.onDatabaseError(error);
    }

    @Override
    public void onDatabaseError(Exception exception) {
        view.onDatabaseError(exception);
    }

    @Override
    public void onDestroy() {
        listDependencyInteractorImpl = null;
        view = null;
    }

    /**
     * Metodos que gestionan la multiple seleccion.
     */

    //Es como un diccionario de C#, clave-valor.
    HashMap<Integer, Boolean> selection = new HashMap<>();

    /**
     * PARA BORRAR CONSULTAMOS AL ADAPTER CUALES SON LOS ELEMENTOS DE UNA POSICION Y CUANDO TENGAMOS
     * LOS ELEMENTOS LOS BORRAMOS EN EL INTERACTOR QUE LLAMARÁ AL REPOSITORY Y LE DIRÁ QUE LOS BORRE.
     */


    @Override
    public void setNewSelection(int position) {
        selection.put(position, true);
    }

    @Override
    public void removeSelection(int position) {
        selection.remove(position);
    }

    /**
     * Método que elimina los elementos selccionados.
     */
    @Override
    public void deleteSelection(DependencyAdapter adapter) {
        Set<Integer> positions;
        positions = selection.keySet();
        ArrayList<Dependency> dependencias = new ArrayList<>();
        //Recorremos el set de integers que son las posiciones porque la clave del diccionario era la posicion del elemento.
        //Si borramos aqui como se van reduciendo las posiciones se sale de indice. Primero hay que almacenar
        //las dependencias a borrar y luego borrarlas una a una.
        for (Iterator<Integer> it = positions.iterator(); it.hasNext(); ) {
            //Integer f = it.next();
            dependencias.add(adapter.getItem(it.next()));
        }

        //Borramos todas las que haya en la lista de dependencias a borrar.
        for (int i = 0; i < dependencias.size(); i++) {
            listDependencyInteractorImpl.deleteDependency(dependencias.get(i));
        }
    }

    @Override
    public void clearSelection() {
        selection.clear();
    }

    //Devuelve si un elemento del mapa está seleccionado.
    @Override
    public boolean isPositionChecked(int position) {
        return selection.containsKey(position);
        //return selection,get(position) == null ? false : true
    }

    @Override
    public void giveViewActionMode(ActionMode mode) {
        view.putActionMode(mode);
    }

    @Override
    public void checkActionMode() {
        if (!selection.isEmpty())
            view.closeActionMode();
    }
}
