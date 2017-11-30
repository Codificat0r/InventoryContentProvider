package com.example.inventoryfragment.ui.dependency;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.adapter.DependencyAdapter;
import com.example.inventoryfragment.data.db.model.Dependency;
import com.example.inventoryfragment.data.db.repository.DependencyRepository;
import com.example.inventoryfragment.ui.base.BasePresenter;
import com.example.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryfragment.ui.utils.CommonDialogUtils;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

//Esta es nuestra vista, antes era la activity, ahora es el fragment. El presenter implementa la interfaz del presenter
    //y la vista la de la vista.
public class ListDependency extends ListFragment implements ListDependencyContract.View{
    public static final String TAG = "listdependency";
    private ListDependencyListener callback;
    private DependencyAdapter adapter;
    private ListDependencyContract.Presenter presenter;

    //Este metodo asigna el presentador a la vista
    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListDependencyContract.Presenter) presenter;
    }

    //Para poder pasarle el re
    interface ListDependencyListener {
        void addNewDependency(Bundle bundle);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new DependencyAdapter(getActivity());
        setRetainInstance(true);
    }

    public ListDependency() {
        setRetainInstance(true);
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
                callback.addNewDependency(null);
            }
        });
        presenter.loadDependency();

        //Si se encontrase en el xml de la activity:
        //FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Le ponemos el adapter y le pasamos al adapter el contexto de la activity
        setListAdapter(adapter);
        ListView lv = (ListView) view.findViewById(android.R.id.list);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("dependency", (Dependency) parent.getItemAtPosition(position));
                //DependencyRepository.getInstance().getDependencies().remove(position);
                bundle.putInt("position", position);
                callback.addNewDependency(bundle);
            }
        });
        //Este metodo va a llamar al onCreateContextMenu
        registerForContextMenu(getListView());
    }

    //Menu contextual (pulsacion larga) sobre la lisya
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //Le ponemos el titulo
        menu.setHeaderTitle("Opciones de la dependencia");
        //Inflamos el el layout del menu en el menu.
        getActivity().getMenuInflater().inflate(R.menu.menu_fragment_listdependency, menu);
    }

    //https://www.mikeplate.com/2010/01/21/show-a-context-menu-for-long-clicks-in-an-android-listview/
    //Cuando se selecciona una opcion del menu contextual realizaremos las acciones correspondientes a esa opcion:
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //En este caso si vamos a usar un switch, pasando del Clean Code.
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.action_listdependency_delete:
                Bundle bundle = new Bundle();
                bundle.putString(CommonDialogUtils.MESSAGE, "¿Desea eliminar la dependencia " + DependencyRepository.getInstance().getDependencies().get(info.position).getName() + "?");
                bundle.putString(CommonDialogUtils.TITLE, "Eliminar dependencia " + DependencyRepository.getInstance().getDependencies().get(info.position).getName());
                //No pasar position, sino el objeto Dependency ya que si se ordena por medio o lo que sea eliminamos el que no es.
                bundle.putInt(CommonDialogUtils.POSITION, info.position);
                CommonDialogUtils.showConfirmDialog(bundle, getActivity(), presenter).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    //Este metodo es el que usa la vista para cargar los datos del repositorio a traves del MVP.
    @Override
    public void showDependency(List<Dependency> list) {
        adapter.clear();
        adapter.addAll(list);
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
        adapter = null;
    }
}
