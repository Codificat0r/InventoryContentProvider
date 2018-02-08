package com.example.inventoryfragmentcontentprovider.ui.dependency.presenter;

import com.example.inventoryfragmentcontentprovider.data.model.Dependency;
import com.example.inventoryfragmentcontentprovider.ui.dependency.AddEditInteractor;
import com.example.inventoryfragmentcontentprovider.ui.dependency.Interactor.AddEditInteractorImpl;
import com.example.inventoryfragmentcontentprovider.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyPresenter implements AddEditDependencyContract.Presenter, AddEditInteractor.onEditFinishedListener {
    AddEditDependencyContract.View view;
    AddEditInteractorImpl interactor = new AddEditInteractorImpl(this);

    public AddEditDependencyPresenter(AddEditDependencyContract.View view) {
        this.view = view;
    }

    @Override
    public void validateDependency(Dependency dependency) {
        interactor.validateDependency(dependency, this);
    }

    @Override
    public void edit(Dependency dependency) {
        interactor.validateDependency(dependency, this);
    }

    public void onNameError() {
        view.setNameError();
    }

    @Override
    public void onShortnameError() {
        view.setShortnameError();
    }

    @Override
    public void onDescriptionError() {
        view.setDescriptionError();
    }

    @Override
    public void onShortnameLenghtError() {
        view.setShortnameLenghtError();
    }

    @Override
    public void onSuccess() {
        view.showDependencyList();
    }

    @Override
    public void onDatabaseError(Error error) {
        view.showOnDatabaseError(error);
    }

    @Override
    public void onDatabaseError(Exception exception) {
        view.showOnDatabaseError(exception);
    }


    @Override
    public void onDestroy() {
        interactor = null;
        view = null;
    }
}
