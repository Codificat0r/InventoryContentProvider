package com.example.inventoryfragment.ui.dependency.Interactor;

import android.text.TextUtils;

import com.example.inventoryfragment.data.db.model.Dependency;
import com.example.inventoryfragment.data.db.repository.DependencyRepository;
import com.example.inventoryfragment.ui.dependency.AddEditInteractor;
import com.example.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 24/11/17.
 */

public class AddEditInteractorImpl implements AddEditInteractor{

    //Se puede hacer en lugar que con if else con excepciones y las recoge el presenter.
    @Override
    public void validateDependency(String name, String shortname, String description, onEditFinishedListener onEditFinishedListener) {
        if (TextUtils.isEmpty(name))
            onEditFinishedListener.onNameError();
        else if (TextUtils.isEmpty(shortname))
            onEditFinishedListener.onShortnameError();
        else if (TextUtils.isEmpty(description))
            onEditFinishedListener.onDescriptionError();
        else if (shortname.length() > 10)
            onEditFinishedListener.onShortnameLenghtError();
        else {
            DependencyRepository.getInstance().addDependency(new Dependency(1, name, shortname, description));
            onEditFinishedListener.onSuccess();
        }
    }
}
