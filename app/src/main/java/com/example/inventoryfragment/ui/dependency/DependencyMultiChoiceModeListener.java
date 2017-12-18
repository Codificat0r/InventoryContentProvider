package com.example.inventoryfragment.ui.dependency;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryfragment.ui.dependency.presenter.ListDependencyPresenter;

/**
 * Created by usuario on 18/12/17.
 */

class DependencyMultiChoiceModeListener implements AbsListView.MultiChoiceModeListener {

    //Podemos usar este mismo o crear uno nuevo que solamente gestione
    //la multiseleccion.
    private ListDependencyContract.Presenter presenter;
    private int count;

    public DependencyMultiChoiceModeListener(ListDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
        if (checked) {
            count++;
            presenter.setNewSelection(position);
        } else {
            count--;
            presenter.removeSelection(position);
        }
        mode.setTitle(Integer.toString(count) + " seleccionados");

    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        //EL actionMode es configurar un menu de opciones y despues sustituir el actionMode por la toolbar.
        //Primero inflamos las opciones de ese actionMode
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.menu_fragment_listdependency, menu);
        mode.setTitle("Iniciando ActionMode");
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_listdependency_delete:
                presenter.deleteSelection();
                break;
        }
        mode.finish();
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        count = 0;
        presenter.clearSelection();
    }
}
