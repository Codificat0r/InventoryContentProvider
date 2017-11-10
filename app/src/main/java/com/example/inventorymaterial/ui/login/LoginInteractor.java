package com.example.inventorymaterial.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

//Los metodos de las todas estas interfaces que estamos creando no deben devolver nada.
public interface LoginInteractor {

    void validateCredentials(String user, String password);

    interface OnLoginFinishedListener {
        void onUserEmptyError();
        void onPasswordEmptyError();
        void onPasswordError();
    }

}
