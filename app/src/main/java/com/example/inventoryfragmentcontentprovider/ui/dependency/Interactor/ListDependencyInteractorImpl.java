package com.example.inventoryfragmentcontentprovider.ui.dependency.Interactor;

import android.os.AsyncTask;

import com.example.inventoryfragmentcontentprovider.data.db.InteractorCallback;
import com.example.inventoryfragmentcontentprovider.data.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.repository.DependencyRepository;
import com.example.inventoryfragmentcontentprovider.ui.dependency.ListDependencyInteractor;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependencyInteractorImpl implements ListDependencyInteractor, InteractorCallback {

    private OnLoadFinishedListener listener;

    public ListDependencyInteractorImpl(OnLoadFinishedListener listener) {
        this.listener = listener;
    }

    @Override
    public void onError(Error error) {
        listener.onDatabaseError(error);
    }

    @Override
    public void onError(Exception exception) {
        listener.onDatabaseError(exception);
    }

    @Override
    public void onSuccess() {
        getAllDependencies();
    }

    public interface OnLoadFinishedListener {
        void onSuccess(List<Dependency> list);
        void onSuccessDelete(List<Dependency> list);
        void onSuccessOrder(List<Dependency> list);

        void onDatabaseError(Error error);

        void onDatabaseError(Exception exception);
    }

    @Override
    public void getAllDependencies() {
        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                listener.onSuccess(DependencyRepository.getInstance().getDependencies());
                return null;
            }
        }.execute();

    }

    @Override
    public void deleteDependency(Dependency dependency) {
        DependencyRepository.getInstance().deleteDependency(dependency, this);
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
