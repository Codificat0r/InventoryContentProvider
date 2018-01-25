package com.example.inventoryfragmentcontentprovider.ui.dependency.Interactor;

import android.text.TextUtils;
import android.widget.TextView;

import com.example.inventoryfragmentcontentprovider.data.db.InteractorCallback;
import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.db.repository.DependencyRepository;
import com.example.inventoryfragmentcontentprovider.ui.dependency.AddEditInteractor;

/**
 * Created by usuario on 24/11/17.
 */

public class AddEditInteractorImpl implements AddEditInteractor, InteractorCallback {

    AddEditInteractor.onEditFinishedListener listener;

    public AddEditInteractorImpl(AddEditInteractor.onEditFinishedListener listener) {
        this.listener = listener;
    }

    //Se puede hacer en lugar que con if else con excepciones y las recoge el presenter.
    @Override
    public void validateDependency(Dependency dependency, onEditFinishedListener onEditFinishedListener) {
        if (TextUtils.isEmpty(dependency.getName()))
            onEditFinishedListener.onNameError();
        else if (TextUtils.isEmpty(dependency.getShortname()))
            onEditFinishedListener.onShortnameError();
        else if (TextUtils.isEmpty(dependency.getDescription()))
            onEditFinishedListener.onDescriptionError();
        else if (dependency.getShortname().length() > 10)
            onEditFinishedListener.onShortnameLenghtError();
        else if (!DependencyRepository.getInstance().existsDependency(dependency)) {
            //DependencyRepository.getInstance().addDependency(new Dependency(1, name, shortname, description, ""));
            addDependency(dependency, onEditFinishedListener);
        } else {
            updateDependency(dependency, onEditFinishedListener);
        }
    }

    private void addDependency(Dependency dependency, onEditFinishedListener onEditFinishedListener) {
        DependencyRepository.getInstance().addDependency(dependency);
        onEditFinishedListener.onSuccess();
    }

    private void updateDependency(Dependency dependency, onEditFinishedListener onEditFinishedListener) {
        DependencyRepository.getInstance().updateDependency(dependency, this);
        onEditFinishedListener.onSuccess();
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
        listener.onSuccess();
    }
}
