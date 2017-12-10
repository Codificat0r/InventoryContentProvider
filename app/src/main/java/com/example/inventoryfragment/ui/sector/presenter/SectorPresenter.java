package com.example.inventoryfragment.ui.sector.presenter;

import com.example.inventoryfragment.adapter.SectorAdapter;
import com.example.inventoryfragment.ui.sector.contract.ContractSector;
import com.example.inventoryfragment.ui.sector.interactor.SectorInteractor;
import com.example.inventoryfragment.ui.sector.interactor.SectorInteractorImpl;

/**
 * Created by carlos on 10/12/2017.
 */

public class SectorPresenter implements ContractSector.Presenter, SectorInteractorImpl.OnLoadAdapterListener {
    ContractSector.View view;
    SectorInteractor interactor;

    public SectorPresenter(ContractSector.View view) {
        this.view = view;
        interactor = new SectorInteractorImpl(this);
    }

    //El presenter se encarga de pedirle que cargue el adapter con los datos
    //y lo devuelva.
    @Override
    public void RequestAdapter() {
        interactor.loadAdapter();
    }

    @Override
    public void onSuccessLoadAdapter(SectorAdapter adapter) {
        view.setAdapter(adapter);
    }
}
