package com.example.inventoryfragment.ui.dependency.presenter;

import com.example.inventoryfragment.data.db.model.Dependency;
import com.example.inventoryfragment.ui.dependency.Interactor.ListDependencyInteractorImpl;
import com.example.inventoryfragment.ui.dependency.contract.ListDependencyContract;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

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
    public void onDestroy() {
        listDependencyInteractorImpl = null;
        view = null;
    }

    /**
     * Metodos que gestionan la multiple seleccion.
     */

    //Es como un diccionario de C#, clave-valor.
    HashMap<Integer, Boolean> selection = new HashMap<>();

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
    public void deleteSelection() {

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
}
