package com.example.inventoryfragment.ui.dependency.presenter;

import android.support.v4.app.Fragment;

import com.example.inventoryfragment.ui.dependency.contract.ListDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenter implements ListDependencyContract.Presenter {
    private ListDependencyContract.View view;

    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.view = view;
    }
}
