package com.example.inventoryfragmentcontentprovider.ui.sector.presenter;

import com.example.inventoryfragmentcontentprovider.data.db.model.Sector;
import com.example.inventoryfragmentcontentprovider.ui.sector.contract.ContractAddEditDeleteSector;
import com.example.inventoryfragmentcontentprovider.ui.sector.interactor.AddEditDeleteSectorInteractor;
import com.example.inventoryfragmentcontentprovider.ui.sector.interactor.AddEditDeleteSectorInteractorImpl;
import com.example.inventoryfragmentcontentprovider.ui.sector.view.AddEditDeleteSectorActivity;

import java.util.ArrayList;

/**
 * Created by usuario on 26/01/18.
 */

public class AddEditDeleteSectorPresenter implements ContractAddEditDeleteSector.Presenter, AddEditDeleteSectorInteractorImpl.OnThingFinishedListener {
    private ContractAddEditDeleteSector.View view;
    private AddEditDeleteSectorInteractor interactor;

    public AddEditDeleteSectorPresenter(ContractAddEditDeleteSector.View view) {
        this.view = view;
        this.interactor = new AddEditDeleteSectorInteractorImpl(this);
    }

    @Override
    public void delete(Sector sector) {
        interactor.delete(sector);
    }

    @Override
    public void addSector(Sector sector) {
        interactor.addSector(sector);
    }

    @Override
    public void updateSector(Sector sector) {
        interactor.updateSector(sector);
    }

    @Override
    public void onSuccess() {
        view.onSuccess();
    }
}
