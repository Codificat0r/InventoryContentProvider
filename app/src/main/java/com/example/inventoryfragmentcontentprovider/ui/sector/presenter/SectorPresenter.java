package com.example.inventoryfragmentcontentprovider.ui.sector.presenter;

import com.example.inventoryfragmentcontentprovider.adapter.SectorAdapter;
import com.example.inventoryfragmentcontentprovider.ui.sector.contract.ContractSector;
import com.example.inventoryfragmentcontentprovider.ui.sector.interactor.SectorInteractor;
import com.example.inventoryfragmentcontentprovider.ui.sector.interactor.SectorInteractorImpl;

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
    public void RequestAdapter(SectorAdapter.OnItemClickListener listener) {
        interactor.loadAdapter(listener);
    }

    @Override
    public void onSuccessLoadAdapter(SectorAdapter adapter) {
        view.setAdapter(adapter);
    }
}