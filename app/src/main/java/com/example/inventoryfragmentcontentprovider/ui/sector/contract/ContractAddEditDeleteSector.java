package com.example.inventoryfragmentcontentprovider.ui.sector.contract;

import com.example.inventoryfragmentcontentprovider.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 26/01/18.
 */

public interface ContractAddEditDeleteSector {
    interface View {
        void onSuccess();
    }

    interface Presenter {
        void delete(Sector sector);
        void addSector(Sector sector);
        void updateSector(Sector sector);
    }
}