package com.example.inventoryfragmentcontentprovider.ui.dependency.presenter;

import com.example.inventoryfragmentcontentprovider.ui.dependency.AddEditInteractor;
import com.example.inventoryfragmentcontentprovider.ui.dependency.Interactor.AddEditInteractorImpl;
import com.example.inventoryfragmentcontentprovider.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyPresenter implements AddEditDependencyContract.Presenter, AddEditInteractor.onEditFinishedListener {
    AddEditDependencyContract.View view;
    AddEditInteractorImpl interactor = new AddEditInteractorImpl();

    public AddEditDependencyPresenter(AddEditDependencyContract.View view) {
        this.view = view;
    }

    @Override
    public void validateDependency(String name, String shortname, String description) {
        interactor.validateDependency(name, shortname, description, this);
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
    public void onDestroy() {
        interactor = null;
        view = null;
    }
}
