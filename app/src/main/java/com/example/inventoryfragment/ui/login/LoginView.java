package com.example.inventoryfragment.ui.login;

/**
 * Contiene los metodos necesarios o expuestos para que el presentador los use.
 */

public interface LoginView {

    void navigateToHome();

    void setUserEmptyError();

    void setPasswordEmptyError();

    void setPasswordError();
}
