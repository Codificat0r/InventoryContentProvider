package com.example.inventoryfragment.ui.dependency.presenter;

import android.view.View;

import com.example.inventoryfragment.ui.dependency.Interactor.AddEditInteractor;
import com.example.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyPresenter implements AddEditDependencyContract.Presenter, AddEditDependencyContract.Interactor.onEditFinishedListener {
    AddEditDependencyContract.View view;
    AddEditInteractor interactor = new AddEditInteractor();

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


}
