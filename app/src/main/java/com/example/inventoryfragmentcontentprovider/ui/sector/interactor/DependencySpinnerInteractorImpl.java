package com.example.inventoryfragmentcontentprovider.ui.sector.interactor;

import com.example.inventoryfragmentcontentprovider.data.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.repository.DependencyRepository;

import java.util.ArrayList;

/**
 * Created by usuario on 5/02/18.
 */

public class DependencySpinnerInteractorImpl implements DependencySpinnerInteractor {

    /**
     * EN LUGAR DE CREAR UN NUEVO INTERACTOR YA TENDRIAMOS DOS INTERACTOR Y NOS CARGARIAMOS
     * EL MODELO CLEAN, USARIAMOS EL INTERACTOR DE DEPENDENCIAS YA CREADA Y DENTRO DE ELLA
     * CREARIAMOS LAS INTERFACES CONCRETAS QUE NECESITE CADA PRESENTER QUE VA A USAR EL INTERACTOR
     * SEPARANDO POR INTERFACES LOS METODOS DE LA INTERFAZ QUE YA HABIA CREADA EN DICHO INTERACTOR.
     *
     *
     *
     *
     *
     */


    OnActionFinishedListener listener;

    public interface OnActionFinishedListener {
        void onDependenciesObtained(ArrayList<Dependency> dependencies);
    }

    public DependencySpinnerInteractorImpl(OnActionFinishedListener listener) {
        this.listener = listener;
    }

    @Override
    public void getDependencies() {
        listener.onDependenciesObtained(DependencyRepository.getInstance().getDependencies());
    }
}
