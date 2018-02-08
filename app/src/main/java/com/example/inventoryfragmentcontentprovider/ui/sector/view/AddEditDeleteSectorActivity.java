package com.example.inventoryfragmentcontentprovider.ui.sector.view;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.inventoryfragmentcontentprovider.R;
import com.example.inventoryfragmentcontentprovider.data.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.model.Sector;
import com.example.inventoryfragmentcontentprovider.ui.sector.contract.ContractAddEditDeleteSector;
import com.example.inventoryfragmentcontentprovider.ui.sector.presenter.AddEditDeleteSectorPresenter;

import java.util.ArrayList;

public class AddEditDeleteSectorActivity extends AppCompatActivity implements ContractAddEditDeleteSector.View{

    Sector extraSector;
    public final static int MODE_EDIT = 0;
    public final static int MODE_ADD = 1;
    public static int mode = 0;
    private EditText edtNombre;
    private EditText edtShortname;
    private EditText edtDescripcion;
    private EditText edtImageName;
    private Spinner spnDependencia;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private ArrayAdapter<Dependency> simpleSpinnerAdapter;

    private ContractAddEditDeleteSector.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_delete_sector);

        presenter = new AddEditDeleteSectorPresenter(this);

        edtNombre = findViewById(R.id.edtNombre);
        edtShortname = findViewById(R.id.edtNombreCorto);
        edtDescripcion = findViewById(R.id.edtDescripcion);
        edtImageName = findViewById(R.id.edtImageName);
        spnDependencia = findViewById(R.id.spnDependencias);
        toolbar = findViewById(R.id.toolbar);
        fab = findViewById(R.id.fab);

        setSupportActionBar(toolbar);

        presenter.cargarSpinnerDependencies();


        if (mode == MODE_EDIT) {
            extraSector = (Sector) getIntent().getExtras().getParcelable("sector");
            edtNombre.setText(extraSector.get_name());
            edtShortname.setText(extraSector.get_shortname());
            edtDescripcion.setText(extraSector.get_description());
            edtImageName.setText(extraSector.get_imageName());
            for (int i = 0; i < simpleSpinnerAdapter.getCount(); i++) {
                Dependency tmp = simpleSpinnerAdapter.getItem(i);
                if (tmp.get_ID() == extraSector.get_dependencyId()) {
                    spnDependencia.setSelection(i);
                }
            }
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mode == MODE_ADD)
                    presenter.addSector(new Sector(0, edtNombre.getText().toString(), edtShortname.getText().toString(), edtDescripcion.getText().toString(), ((Dependency) spnDependencia.getSelectedItem()).get_ID(), true, false, edtImageName.getText().toString()));
                else {
                    presenter.updateSector(new Sector(extraSector.getId(), edtNombre.getText().toString(), edtShortname.getText().toString(), edtDescripcion.getText().toString(), ((Dependency) spnDependencia.getSelectedItem()).get_ID(), extraSector.is_enabled(), extraSector.is_default(), edtImageName.getText().toString()));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_delete_sector, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mitm_delete_sector) {
            if (mode == MODE_EDIT)
                presenter.delete(extraSector);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSuccess() {
        finish();
    }

    @Override
    public void onDependenciesLoaded(ArrayList<Dependency> dependencies) {
        if (simpleSpinnerAdapter == null)
            simpleSpinnerAdapter = new ArrayAdapter<Dependency>(this, android.R.layout.simple_spinner_item, dependencies);
        else {
            simpleSpinnerAdapter.clear();
            simpleSpinnerAdapter.addAll(dependencies);
        }
        spnDependencia.setAdapter(simpleSpinnerAdapter);
    }
}
