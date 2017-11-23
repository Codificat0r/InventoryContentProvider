package com.example.inventoryfragment.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependency extends Fragment implements AddEditDependencyContract.View {
    public static final String TAG = "addeditdependency";
    private AddEditDependencyContract.Presenter presenter;

    //Patron factory
    public static AddEditDependency newInstance(@Nullable Bundle arguments) {
        AddEditDependency addEditDependency = new AddEditDependency();
        if (arguments != null) {
            addEditDependency.setArguments(arguments);
        }
        return addEditDependency;
    }


    @Override
    public void setPresenter(AddEditDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_edit_dependency, container, false);
        if (getArguments() != null) { //SI HAY ARGUMENTOS, SE TRATA DE UNA EDICION

        }
        return rootView;
    }
}
