package com.example.inventorymaterial.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.inventorymaterial.R;
import com.example.inventorymaterial.pojo.Sector;
import com.example.inventorymaterial.repository.SectorRepository;

import java.util.ArrayList;

/**
 * Created by usuario on 30/10/17.
 */

public class SectorAdapter extends RecyclerView.Adapter<SectorAdapter.SectorViewHolder>{

    private ArrayList<Sector> sectors;
    //Array que almacenará los sector que se han modificado en la interfaz y no se han guardado aun en la base de datos.
    //En nuestro caso en el repository.
    private ArrayList<Sector> sectorsModified;
    private OnSwitchCheckedChangeListener onSwitchCheckedChangeListener;

    public SectorAdapter() {
        sectors = SectorRepository.getInstance().getSectors();
        sectorsModified = new ArrayList<>();
    }

    //Solo se llamará este constructor cuando SectorActivity venga de un cambio de configuración
    //y se haya salvado el estado dinámico.
    public SectorAdapter(ArrayList<Sector> sectorsModified) {
        sectors = SectorRepository.getInstance().getSectors();
        this.sectorsModified = sectorsModified;
    }

    @Override
    public SectorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Usamos el contexto de la lista que vaya a contener los elementos, es decir, el REcyclerView de nuestro layout.
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Inflamos la vista
        View view = inflater.inflate(R.layout.item_sector, null);
        SectorViewHolder sectorViewHolder = new SectorViewHolder(view);
        return sectorViewHolder;
    }

    //Aqui asignamos los textos y los estados a los switchs.
    @Override
    public void onBindViewHolder(SectorViewHolder holder, int position) {
        holder.swEnabled.setChecked(sectors.get(position).is_enabled());
        holder.swEnabled.setOnCheckedChangeListener(onSwitchCheckedChangeListener);
        holder.txvName.setText(sectors.get(position).get_name());
        if (sectors.get(position).is_default())
            holder.txvSectorShortName.setText(sectors.get(position).get_shortname());
    }

    //Se crearán tantos elementos SectorViewHolder como elementos haya en el ArrayList definido dentro de la clase.
    @Override
    public int getItemCount() {
        return sectors.size();
    }

    public static class SectorViewHolder extends RecyclerView.ViewHolder {
        private Switch swEnabled;
        private TextView txvName;
        private TextView txvSectorShortName;


        public SectorViewHolder(View itemView) {
            super(itemView);
            swEnabled = (Switch) itemView.findViewById(R.id.swchDefault);
            txvName = (TextView) itemView.findViewById(R.id.txvSectorName);
            txvSectorShortName = (TextView) itemView.findViewById(R.id.txvSectorShortname);
        }
    }

    //Devuelve los sectores que han sido modificados cuando la activity estaba visible y antes de darle al boton save, es decir,
    //antes de guardarlo en la base de datos. Hay que guardar el estado dinamico, es decir, hay que guardar los datos que no
    //estan guardados de manera persistente en la base de datos.
    public ArrayList<Sector> getSectorsModified() {
        return sectorsModified;
    }

    //En el onBindViewHolder enganchamos los switch a este listener, para que cuando cambien, guardemos
    //su estado, por si se gira la pantalla que se destruye y se crea la activity.
    //https://stackoverflow.com/questions/19587141/saving-and-restoring-instance-state-in-dynamically-created-ui
    //https://developer.android.com/training/basics/activity-lifecycle/recreating.html?hl=es-419
    class OnSwitchCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        }
    }


}
