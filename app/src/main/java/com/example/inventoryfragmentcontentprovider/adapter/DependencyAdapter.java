package com.example.inventoryfragmentcontentprovider.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventoryfragmentcontentprovider.R;
import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

//Dentro de un package es el unico sitio donde hay que hacer un import de R.

/**
 * Esta clase nos ayudará a conectar con el XML que nos facilitará mostrar con aspecto personalizado cada elemento
 * del ListView, es decir, cada dependencia.
 */

public class DependencyAdapter extends ArrayAdapter<Dependency>{

    public DependencyAdapter(@NonNull Context context) {
        //LO dejamos vacio porque los cargaremos cuando el interactor nos diga que carguemos los datos:
        super(context, R.layout.item_dependency, new ArrayList<Dependency>());
        //SE HACE AQUI EL SORT
        //sort(un new comparator)
    }

    //Este metodo es el que devuelve un objeto View. Lo llama el S.O. automaticamente una vez por cada elemento del ArrayAdapter.
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvShortname;

        DependencyHolder dependencyHolder;

        //Lo inicializamos con el objeto que desapareció de pantalla
        View view = convertView;

        //Si no ha desaparecido ningun elemento de pantalla, sigue inflando nuevos view. Es decir, por asi decirlo, vamos
        //a crear los 8 primeros "rectangulos" que contendran los dos textview y el icon. Luego ya para que pintar mas,
        //sino que se reutilizan
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            dependencyHolder = new DependencyHolder();

            view = inflater.inflate(R.layout.item_dependency, null);

            //El fin es inicializar las vistas dentro de la vista las veces necesarias, luego
            //reutilizar la ya creada, y solo tener que meter los nuevos datos.
            dependencyHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
            dependencyHolder.txvName = (TextView) view.findViewById(R.id.txvName);
            //AÑADIMOS FUENTE DESDE CODIGO. DESDE UN XML SOLO ES PARA API +26
            dependencyHolder.txvName.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/crypt.ttf"));
            dependencyHolder.txvShortname = (TextView) view.findViewById(R.id.txvShortname);

            //El tag puede parecer el mismo pero es diferente, ya que se crea un nuevo DependencyHolder
            //cada vez.
            view.setTag(dependencyHolder);

        } else {
            dependencyHolder = (DependencyHolder) view.getTag();
        }

        //Mostrar los datos del arraylist mediante position
        dependencyHolder.icon.setLetter(getItem(position).getShortname().substring(0,1));
        dependencyHolder.txvName.setText(getItem(position).getName());
        dependencyHolder.txvShortname.setText(getItem(position).getShortname());

        return view;
    }

    class DependencyHolder {

        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvShortname;

    }
}
