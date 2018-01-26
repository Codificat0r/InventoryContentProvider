package com.example.inventoryfragmentcontentprovider.ui.sector.interactor;

import com.example.inventoryfragmentcontentprovider.data.db.model.Sector;

/**
 * Created by usuario on 26/01/18.
 */

public interface AddEditDeleteSectorInteractor {
    void delete(Sector sector);

    void addSector(Sector sector);

    void updateSector(Sector sector);
}
