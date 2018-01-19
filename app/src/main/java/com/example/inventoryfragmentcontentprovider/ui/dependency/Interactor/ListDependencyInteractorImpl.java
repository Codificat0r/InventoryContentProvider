package com.example.inventoryfragmentcontentprovider.ui.dependency.Interactor;

import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.db.repository.DependencyRepository;
import com.example.inventoryfragmentcontentprovider.ui.dependency.ListDependencyInteractor;

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
        void onSuccessDelete(List<Dependency> list);
        void onSuccessOrder(List<Dependency> list);
    }

    @Override
    public void getAllDependencies() {
        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }

    @Override
    public void deleteDependency(Dependency dependency) {
        DependencyRepository.getInstance().deleteDependency(dependency);
        listener.onSuccessDelete(DependencyRepository.getInstance().getDependencies());
    }

    @Override
    public void orderByName() {
        DependencyRepository.getInstance().orderByName();
        listener.onSuccessOrder(DependencyRepository.getInstance().getDependencies());
    }

    @Override
    public void orderById() {
        DependencyRepository.getInstance().orderById();
        listener.onSuccessOrder(DependencyRepository.getInstance().getDependencies());
    }


}
