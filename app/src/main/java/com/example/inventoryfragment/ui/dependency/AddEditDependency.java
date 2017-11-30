package com.example.inventoryfragment.ui.dependency;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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
import com.example.inventoryfragment.ui.utils.AddEdit;

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
    private AddEditDependencyListener callback;
    private boolean descripcionCambiada;
    Dependency dependency;
    static AddEdit mode;

    //Patron factory
    public static AddEditDependency newInstance(@Nullable Bundle arguments) {
        AddEditDependency addEditDependency = new AddEditDependency();
        mode = new AddEdit();
        if (arguments != null) {
            addEditDependency.setArguments(arguments);
            mode.setMode(AddEdit.EDIT_MODE);
        } else {
            mode.setMode(AddEdit.ADD_MODE);
        }
        return addEditDependency;
    }

    interface AddEditDependencyListener {
        void returnToList();
        void editDependency(Dependency dependency);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (AddEditDependencyListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must implements AddEditDependencyListener");
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
                tilName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        tilShortname = (TextInputLayout) rootView.findViewById(R.id.tilShortname);
        edtShortname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilShortname.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        tilDescription = (TextInputLayout) rootView.findViewById(R.id.tilDescription);
        edtDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilDescription.setError(null);
                descripcionCambiada = true;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Hay que delegar la edicion en el interactor.
                if (mode.getMode() == AddEdit.EDIT_MODE) {
                    if (descripcionCambiada == true) {
                        dependency.setDescription(edtDescription.getText().toString());
                        DependencyRepository.getInstance().getDependencies().remove(getArguments().getInt("position"));
                        callback.editDependency(dependency);
                    }
                    descripcionCambiada = false;
                    callback.returnToList();
                } else {
                    presenter.validateDependency(edtName.getText().toString(), edtShortname.getText().toString(), edtDescription.getText().toString());
                }
            }
        });
        if (mode.getMode() == AddEdit.EDIT_MODE) { //SI HAY ARGUMENTOS, SE TRATA DE UNA EDICION
            Bundle arguments = getArguments();
            dependency = arguments.getParcelable("dependency");
            edtName.setText(dependency.getName());
            edtName.setEnabled(false);
            edtShortname.setText(dependency.getShortname());
            edtShortname.setEnabled(false);
            edtDescription.setText(dependency.getDescription());
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
        callback.returnToList();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
