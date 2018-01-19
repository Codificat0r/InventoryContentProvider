package com.example.inventoryfragmentcontentprovider.ui.sector.interactor;

import com.example.inventoryfragmentcontentprovider.adapter.SectorAdapter;
import com.example.inventoryfragmentcontentprovider.data.db.repository.SectorRepository;

/**
 * Created by carlos on 10/12/2017.
 */

public class SectorInteractorImpl implements SectorInteractor{

    OnLoadAdapterListener listener;

    public SectorInteractorImpl(OnLoadAdapterListener listener) {
        this.listener = listener;
    }

    public interface OnLoadAdapterListener {
        void onSuccessLoadAdapter(SectorAdapter adapter);
    }

    @Override
    public void loadAdapter(SectorAdapter.OnItemClickListener listener) {
        SectorAdapter adapter = new SectorAdapter(SectorRepository.getInstance().getSectors(), listener);
        this.listener.onSuccessLoadAdapter(adapter);
    }
}
