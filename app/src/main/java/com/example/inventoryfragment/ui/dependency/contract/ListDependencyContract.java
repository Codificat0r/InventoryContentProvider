package com.example.inventoryfragment.ui.dependency.contract;

/**
 * Created by usuario on 23/11/17.
 */

//Esta es otra forma de hacer los contratos. ES como un contarto inmobiliario, deben estar las dos partes. Ya como este engloba
    //dos contratos, ya no son Impl. Si fuera Impl es que tiene una interfaz creada solo para el. Pero aqui unimos las dos.
public interface ListDependencyContract {

    interface View {
        void setPresenter(ListDependencyContract.Presenter presenter);
    }

    interface Presenter {

    }
}
