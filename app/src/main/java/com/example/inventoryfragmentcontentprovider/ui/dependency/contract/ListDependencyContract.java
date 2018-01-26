package com.example.inventoryfragmentcontentprovider.ui.dependency.contract;

import android.view.ActionMode;

import com.example.inventoryfragmentcontentprovider.adapter.DependencyAdapter;
import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;
import com.example.inventoryfragmentcontentprovider.ui.base.BasePresenter;
import com.example.inventoryfragmentcontentprovider.ui.base.BaseView;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

//Esta es otra forma de hacer los contratos. ES como un contarto inmobiliario, deben estar las dos partes. Ya como este engloba
    //dos contratos, ya no son Impl. Si fuera Impl es que tiene una interfaz creada solo para el. Pero aqui unimos las dos.
    //No deberian devolver nada los metodos de estos contratos.
public interface ListDependencyContract {

    interface View extends BaseView {
        void showDependency(List<Dependency> list);
        void updateAdapter();
        void closeActionMode();

        void putActionMode(ActionMode mode);

        void onDatabaseError(Error error);

        void onDatabaseError(Exception exception);

        void showProgressDialog(String message);

        void dismissProgressDialog();
    }

    interface Presenter extends BasePresenter {
        void loadDependency();
        void deleteDependency(Dependency dependency);
        void orderByName();
        void orderById();

        void setNewSelection(int position);
        void removeSelection(int position);
        void deleteSelection(DependencyAdapter adapter);
        void clearSelection();
        boolean isPositionChecked(int position);
        void giveViewActionMode(ActionMode mode);

        void checkActionMode();
    }
}
