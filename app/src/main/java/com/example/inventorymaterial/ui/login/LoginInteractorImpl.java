package com.example.inventorymaterial.ui.login;

/**
 * Esta clase implementará el interactor, la interfaz del interactor del login.
 */

public class LoginInteractorImpl {
    //QUien haya llamado a este metodo establezco que debe implñementar una interfaz que vamos a llamar
    //LoginInteractor.OnLoginFinishedListener. Se le pasará en ese parametro el presenter que lo use, ya que
    //puede haber más de uno.
    public void validateCredentials(String user, String password, LoginInteractor.OnLoginFinishedListener listener) {
        //Realiza todas las comprobaciones
        if listener.onPasswordEmptyError();
        else if
            listener.onUserEmptyError();
        else if
            listener.onPasswordEmptyError();
        else if
            listener.onPasswordError();
        //Y es correcto
    }
}
