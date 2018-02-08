package com.example.inventoryfragmentcontentprovider.ui.sector.presenter;

import com.example.inventoryfragmentcontentprovider.data.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.model.Sector;
import com.example.inventoryfragmentcontentprovider.ui.sector.contract.ContractAddEditDeleteSector;
import com.example.inventoryfragmentcontentprovider.ui.sector.interactor.AddEditDeleteSectorInteractor;
import com.example.inventoryfragmentcontentprovider.ui.sector.interactor.AddEditDeleteSectorInteractorImpl;
import com.example.inventoryfragmentcontentprovider.ui.sector.interactor.DependencySpinnerInteractor;
import com.example.inventoryfragmentcontentprovider.ui.sector.interactor.DependencySpinnerInteractorImpl;

import java.util.ArrayList;

/**
 * Created by usuario on 26/01/18.
 */

public class AddEditDeleteSectorPresenter implements ContractAddEditDeleteSector.Presenter, AddEditDeleteSectorInteractorImpl.OnThingFinishedListener, DependencySpinnerInteractorImpl.OnActionFinishedListener{
    private ContractAddEditDeleteSector.View view;
    private AddEditDeleteSectorInteractor interactorSector;
    private DependencySpinnerInteractor interactorDependency;

    public AddEditDeleteSectorPresenter(ContractAddEditDeleteSector.View view) {
        this.view = view;
        this.interactorSector = new AddEditDeleteSectorInteractorImpl(this);
        this.interactorDependency = new DependencySpinnerInteractorImpl(this);
    }

    @Override
    public void delete(Sector sector) {
        interactorSector.delete(sector);
    }

    @Override
    public void addSector(Sector sector) {
        interactorSector.addSector(sector);
    }

    @Override
    public void updateSector(Sector sector) {
        interactorSector.updateSector(sector);
    }

    @Override
    public void cargarSpinnerDependencies() {
        interactorDependency.getDependencies();
    }

    @Override
    public void onSuccess() {
        view.onSuccess();
    }

    @Override
    public void onDependenciesObtained(ArrayList<Dependency> dependencies) {
        view.onDependenciesLoaded(dependencies);
    }
}
