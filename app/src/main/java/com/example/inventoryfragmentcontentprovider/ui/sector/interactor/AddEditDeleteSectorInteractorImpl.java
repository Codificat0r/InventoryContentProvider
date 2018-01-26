package com.example.inventoryfragmentcontentprovider.ui.sector.interactor;

import com.example.inventoryfragmentcontentprovider.data.db.model.Sector;
import com.example.inventoryfragmentcontentprovider.data.db.repository.SectorRepository;

import java.util.ArrayList;

/**
 * Created by usuario on 26/01/18.
 */

public class AddEditDeleteSectorInteractorImpl implements AddEditDeleteSectorInteractor {
    private OnThingFinishedListener listener;

    @Override
    public void delete(Sector sector) {
        SectorRepository.getInstance().deleteSector(sector);
        listener.onSuccess();
    }

    @Override
    public void addSector(Sector sector) {
        SectorRepository.getInstance().addSector(sector);
        listener.onSuccess();
    }

    @Override
    public void updateSector(Sector sector) {
        SectorRepository.getInstance().updateSector(sector);
        listener.onSuccess();
    }

    public interface OnThingFinishedListener {
        void onSuccess();
    }

    public AddEditDeleteSectorInteractorImpl(OnThingFinishedListener listener) {
        this.listener = listener;
    }
}
