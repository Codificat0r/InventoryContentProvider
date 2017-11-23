package com.example.inventoryfragment.ui.dependency;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.inventoryfragment.R;
import com.example.inventoryfragment.adapter.DependencyAdapter;
import com.example.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryfragment.ui.dependency.presenter.ListDependencyPresenter;

/**
 * Created by usuario on 23/11/17.
 */

//Esta es nuestra vista, antes era la activity, ahora es el fragment. El presenter implementa la interfaz del presenter
    //y la vista la de la vista.
public class ListDependency extends ListFragment implements ListDependencyContract.View{
    public static final String TAG = "listdependency";
    private ListDependencyListener callback;
    private ListDependencyContract.Presenter presenter;

    public void setPresenter(ListDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }

    //Para poder pasarle el re
    interface ListDependencyListener {
        void addNewDependency();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //Comprobamos que la interfaz implementa el contrato
        try {
            callback = (ListDependencyListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must implements ListDependencyListener");
        }
    }

    //Patron factory
    public static ListDependency newInstance(@Nullable Bundle arguments) {
        ListDependency listDependency = new ListDependency();
        if (arguments != null) {
            listDependency.setArguments(arguments);
        }
        return listDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //El container será el ViewGroup de la activity, el FrameLayout. Es decir, le decimos que lo infle en ese cotenedor
        //de vistas.
        View rootView = inflater.inflate(R.layout.fragment_list_dependency, container, false);

        //Como se encuentra en el fragment, usamos rootView
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.addNewDependency();
            }
        });

        //Si se encontrase en el xml de la activity:
        //FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Le ponemos el adapter y le pasamos al adapter el contexto de la activity
        setListAdapter(new DependencyAdapter(getActivity()));
    }
}
