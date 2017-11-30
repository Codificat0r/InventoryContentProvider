package com.example.inventoryfragment.ui.dependency.Interactor;

import com.example.inventoryfragment.data.db.model.Dependency;
import com.example.inventoryfragment.data.db.repository.DependencyRepository;
import com.example.inventoryfragment.ui.dependency.ListDependencyInteractor;
import com.example.inventoryfragment.ui.dependency.contract.ListDependencyContract;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependencyInteractorImpl implements ListDependencyInteractor{

    private OnLoadFinishedListener listener;

    public ListDependencyInteractorImpl(OnLoadFinishedListener listener) {
        this.listener = listener;
    }

    public interface OnLoadFinishedListener {
        void onSuccess(List<Dependency> list);
    }

    @Override
    public void getAllDependencies() {
        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }

    @Override
    public void deleteDependency(int position) {
        DependencyRepository.getInstance().getDependencies().remove(position);
        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }

}
