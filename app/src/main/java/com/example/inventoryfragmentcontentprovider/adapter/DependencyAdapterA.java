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
import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.db.repository.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

//Dentro de un package es el unico sitio donde hay que hacer un import de R.

/**
 * Esta clase nos ayudará a conectar con el XML que nos facilitará mostrar con aspecto personalizado cada elemento
 * del ListView, es decir, cada dependencia. Es la primera solución no optimizada.
 */

public class DependencyAdapterA extends ArrayAdapter<Dependency>{

    public DependencyAdapterA(@NonNull Context context) {
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
    }

    //Este metodo es el que devuelve un objeto View. Lo llama el S.O. automaticamente una vez por cada elemento del ArrayAdapter.
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvShortname;
        View view;

        //COnseguimos el inflador del sistema. Es el que infla los View en los layout. getSystemService es la forma
        //de acceder a un servicio o manager del sistema.
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Tambien podemos verlo de la siguiente manera:
        //LayoutInflater inflater = LayoutInflater.from(getContext());
        //Otra opción, en la que hay que acceder al contexto de la Activity, es (no recomendada):
        //LayoutInflater inflater = ((Activity)getContext()).getLayoutInflater();

        //Si ponemos un valor diferente de null, lo que hace es que mete la primera vista, el item_dependency en el ViewGroup
        //(layout) indicado en lugar de null.
        //Inflar la vista. Crea en memoria el objeto View con todos los widget del xml: item_dependency.xml
        view = inflater.inflate(R.layout.item_dependency, null);

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
