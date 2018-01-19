package com.example.inventoryfragmentcontentprovider.ui.dependency;

/**
 * Created by usuario on 27/11/17.
 */

//Debe tener su propia interfaz ya que el presenter implementa directamente el interactor sin usar un contrato, asi que solo
    //hacemos la interfaz del interactor que es el que va a tener el presenter por contrato.
public interface AddEditInteractor {

        void validateDependency(String name, String shortname, String description, AddEditInteractor.onEditFinishedListener onEditFinishedListener);

        interface onEditFinishedListener {
            void onNameError();
            void onShortnameError();
            void onDescriptionError();
            void onShortnameLenghtError();
            void onSuccess();
        }
    }
