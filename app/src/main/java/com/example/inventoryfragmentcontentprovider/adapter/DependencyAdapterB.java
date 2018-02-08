package com.example.inventoryfragmentcontentprovider.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventoryfragmentcontentprovider.R;
import com.example.inventoryfragmentcontentprovider.data.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.repository.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

//Dentro de un package es el unico sitio donde hay que hacer un import de R.

/**
 * Esta clase nos ayudará a conectar con el XML que nos facilitará mostrar con aspecto personalizado cada elemento
 * del ListView, es decir, cada dependencia.
 */

public class DependencyAdapterB extends ArrayAdapter<Dependency>{

    public DependencyAdapterB(@NonNull Context context) {
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
    }

    //Este metodo es el que devuelve un objeto View. Lo llama el S.O. automaticamente una vez por cada elemento del ArrayAdapter.
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvShortname;

        //Lo inicializamos con el objeto que desapareció de pantalla
        View view = convertView;

        //Si no ha desaparecido ningun elemento de pantalla, sigue inflando nuevos view. Es decir, por asi decirlo, vamos
        //a crear los 8 primeros "rectangulos" que contendran los dos textview y el icon. Luego ya para que pintar mas,
        //sino que se reutilizan
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.item_dependency, null);

        }


        //Inicializar las variables a los objetos ya creados de los widget del xml. ¡¡Cuidado View.findViewId!!
        icon = (MaterialLetterIcon)view.findViewById(R.id.icon);
        txvName = (TextView)view.findViewById(R.id.txvName);
        txvShortname = (TextView)view.findViewById(R.id.txvShortname);

        //Mostrar los datos del arraylist mediante position
        icon.setLetter(getItem(position).getShortname().substring(0,1));
        txvName.setText(getItem(position).getName());
        txvShortname.setText(getItem(position).getShortname());

        return view;
    }
}
