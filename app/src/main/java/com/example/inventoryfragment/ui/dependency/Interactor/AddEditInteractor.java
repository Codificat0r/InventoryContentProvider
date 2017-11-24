package com.example.inventoryfragment.ui.dependency.Interactor;

import android.text.TextUtils;

import com.example.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 24/11/17.
 */

public class AddEditInteractor implements AddEditDependencyContract.Interactor{

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
        else
            onEditFinishedListener.onSuccess();
    }
}
