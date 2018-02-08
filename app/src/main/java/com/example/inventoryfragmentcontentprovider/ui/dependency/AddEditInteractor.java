package com.example.inventoryfragmentcontentprovider.ui.dependency;

import com.example.inventoryfragmentcontentprovider.data.model.Dependency;

/**
 * Created by usuario on 27/11/17.
 */

//Debe tener su propia interfaz ya que el presenter implementa directamente el interactor sin usar un contrato, asi que solo
    //hacemos la interfaz del interactor que es el que va a tener el presenter por contrato.
public interface AddEditInteractor {

    //Se puede hacer en lugar que con if else con excepciones y las recoge el presenter.
    void validateDependency(Dependency dependency, onEditFinishedListener onEditFinishedListener);

    interface onEditFinishedListener {
            void onNameError();
            void onShortnameError();
            void onDescriptionError();
            void onShortnameLenghtError();
            void onSuccess();

        void onDatabaseError(Error error);

        void onDatabaseError(Exception exception);
    }
}
