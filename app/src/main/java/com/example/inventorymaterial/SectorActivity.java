package com.example.inventorymaterial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.inventorymaterial.adapter.SectorAdapter;
import com.example.inventorymaterial.pojo.Sector;

public class SectorActivity extends AppCompatActivity {

    private RecyclerView recyclerSector;
    private SectorAdapter sectorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);

        recyclerSector = (RecyclerView) findViewById(R.id.rcvwSector);
        recyclerSector.setLayoutManager(new GridLayoutManager(this, 2, 1, false));
        if (savedInstanceState != null) {
            sectorAdapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList("sector"));
        } else {
            sectorAdapter = new SectorAdapter();
        }
        recyclerSector.setAdapter(sectorAdapter);
        //Le decimos que layout va a usar para repartir los elementos en el interior del RecyclerView mediante un
        //GridLayoutManager.




    }

    //Cargamos el menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_sector,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Almaceno los sectores que se han modificado en la vista y no han sido guardados para visualizar
    //el estado correcto en OnCreate()
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("sector", sectorAdapter.getSectorsModified());
    }
}
