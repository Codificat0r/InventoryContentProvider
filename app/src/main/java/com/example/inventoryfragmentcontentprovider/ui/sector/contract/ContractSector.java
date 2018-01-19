package com.example.inventoryfragmentcontentprovider.ui.sector.contract;

import com.example.inventoryfragmentcontentprovider.adapter.SectorAdapter;

/**
 * Created by carlos on 10/12/2017.
 */

public interface ContractSector {
    interface View {
        void setAdapter(SectorAdapter adapter);
    }

    interface Presenter {
        void RequestAdapter(SectorAdapter.OnItemClickListener listener);
    }
}
