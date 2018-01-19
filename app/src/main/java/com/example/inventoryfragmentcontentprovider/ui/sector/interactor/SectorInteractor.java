package com.example.inventoryfragmentcontentprovider.ui.sector.interactor;

import com.example.inventoryfragmentcontentprovider.adapter.SectorAdapter;

/**
 * Created by carlos on 10/12/2017.
 */

public interface SectorInteractor {
    void loadAdapter(SectorAdapter.OnItemClickListener listener);
}
