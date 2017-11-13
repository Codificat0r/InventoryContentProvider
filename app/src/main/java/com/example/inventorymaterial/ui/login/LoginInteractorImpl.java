package com.example.inventorymaterial.ui.login;

import android.text.TextUtils;

import com.example.inventorymaterial.data.db.repository.UserRepository;
import com.example.inventorymaterial.ui.utils.CommonUtils;

/**
 * Esta clase implementará el interactor, la interfaz del interactor del login.
 */

public class LoginInteractorImpl {
    //Quien haya llamado a este metodo establezco que debe implementar una interfaz que vamos a llamar
    //LoginInteractor.OnLoginFinishedListener. Se le pasará en ese parametro el presenter que lo use, ya que
    //puede haber más de uno.
    public void validateCredentials(String user, String password, LoginInteractor.OnLoginFinishedListener listener) {
        //Realiza todas las comprobaciones, y avisa al presenter, que avisará al login.
        if (TextUtils.isEmpty(user))
            listener.onUserEmptyError();
        else if (TextUtils.isEmpty(password))
            listener.onPasswordEmptyError();
        else if (!CommonUtils.isPasswordValid(password))
            listener.onPasswordError();
        //else if (UserRepository.getInstance().validateCredentials(user, password))
        //    listener.onPasswordError();
        //Y es correcto
    }
}
