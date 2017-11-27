package com.example.inventoryfragment.ui.dependency;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.data.db.model.Dependency;
import com.example.inventoryfragment.data.db.repository.DependencyRepository;
import com.example.inventoryfragment.ui.base.BasePresenter;
import com.example.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependency extends Fragment implements AddEditDependencyContract.View {
    public static final String TAG = "addeditdependency";
    private AddEditDependencyContract.Presenter presenter;
    private FloatingActionButton fab;
    private EditText edtName;
    private EditText edtShortname;
    private EditText edtDescription;
    private TextInputLayout tilName;
    private TextInputLayout tilShortname;
    private TextInputLayout tilDescription;
    private FloatingActionButtonFragmenAddEditDependencyListener callback;

    //Patron factory
    public static AddEditDependency newInstance(@Nullable Bundle arguments) {
        AddEditDependency addEditDependency = new AddEditDependency();
        if (arguments != null) {
            addEditDependency.setArguments(arguments);
        }
        return addEditDependency;
    }

    interface FloatingActionButtonFragmenAddEditDependencyListener {
        void returnToList();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (FloatingActionButtonFragmenAddEditDependencyListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must implements FloatingActionButtonFragmenAddEditDependencyListener");
        }
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditDependencyContract.Presenter) presenter;
    }

    @Override
    public void showNameEmptyError() {
        tilName.setError(getString(R.string.nameEmptyError));
    }

    @Override
    public void showShortnameEmptyError() {
        tilShortname.setError(getString(R.string.shortnameEmptyError));
    }

    @Override
    public void showShortnameLenghtError() {
        tilShortname.setError(getString(R.string.shortnameLenghtError));
    }

    @Override
    public void showDescriptionEmptyError() {
        tilDescription.setError(getString(R.string.descriptionEmptyError));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_edit_dependency, container, false);
        //Si el floating button estuviera en el activity principal porque todos tienen uno, se usaria getActivity().
        edtName = (EditText) rootView.findViewById(R.id.edtName);
        edtShortname = (EditText) rootView.findViewById(R.id.edtShortname);
        edtDescription = (EditText) rootView.findViewById(R.id.edtDescription);
        tilName = (TextInputLayout) rootView.findViewById(R.id.tilName);
        edtName = (EditText) rootView.findViewById(R.id.edtName);
        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        tilShortname = (TextInputLayout) rootView.findViewById(R.id.tilShortname);
        tilDescription = (TextInputLayout) rootView.findViewById(R.id.tilDescription);
        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validateDependency(edtName.getText().toString(), edtShortname.getText().toString(), edtDescription.getText().toString());
            }
        });
        if (getArguments() != null) { //SI HAY ARGUMENTOS, SE TRATA DE UNA EDICION

        }
        return rootView;
    }

    @Override
    public void setNameError() {
        showNameEmptyError();
    }

    @Override
    public void setShortnameError() {
        showShortnameEmptyError();
    }

    @Override
    public void setDescriptionError() {
        showDescriptionEmptyError();
    }

    @Override
    public void setShortnameLenghtError() {
        showShortnameLenghtError();
    }

    //Si todo es correcto muestro la lista de dependencias con la nueva añadida
    @Override
    public void showDependencyList() {
        DependencyRepository.getInstance().addDependency(new Dependency(1, edtName.getText().toString(), edtShortname.getText().toString(), edtDescription.getText().toString()));
        callback.returnToList();
    }


}
