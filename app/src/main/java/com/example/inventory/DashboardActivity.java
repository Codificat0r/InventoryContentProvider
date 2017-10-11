package com.example.inventory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by usuario on 9/10/17.
 */

public class DashboardActivity extends AppCompatActivity {

    //Vamos a meter las imagenes desde codigo.
    private GridLayout grdDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_support);

        grdDashboard = (GridLayout) findViewById(R.id.grdDashboard);

        //Definir un array de int, que contendra el id de las imagenes.
        int[] images = {R.drawable.ic_chair, R.drawable.ic_closet, R.drawable.ic_cpu, R.drawable.ic_inventory,
                        R.drawable.ic_keyboard, R.drawable.ic_monitor, R.drawable.ic_mouse, R.drawable.ic_printer,
                        R.drawable.ic_table, R.drawable.ic_whiteboard, R.drawable.ic_proyector};
        //Definir un array de ImageView. En java los arrays de objetos no son eficientes por lo que definimos
        //un vector. Para los tipos primitivos si.
        //ImageView[] imageViews = new ImageView[images.length];
        //Un vector y un ArrayList son listas de longitud variable. Un vector es sincrono, es decir, que si se modifica
        //un vector se modifca en todos los hilos que usan ese vector. Si no necesitamos un objeto sincrono porque
        //no vamos a usar hilos, usamos un ArrayList.
        //Vector<ImageView> vectorImageViews = new Vector<ImageView>();

        //Podriamos hacer el ArrayList sin tipo, pero tendriamos que hacer el casting comprobando
        //antes que se puede hacer, es decir, que el objeto candidato de casting es del mismo tipo del casting:

        /*ArrayList arrayListImageViews = new ArrayList();

        for (int i = 0; i < images.length; i++) {
            arrayListImageViews.add(new ImageView(this));
            if (arrayListImageViews.get(i) instanceof ImageView) {
                ((ImageView) arrayListImageViews.get(i)).setImageResource(images[i]);
            }
            grdDashboard.addView((ImageView)arrayListImageViews.get(i));
        }*/
        //Obtenemos las dimensiones
        float width = getResources().getDimension(R.dimen.imgDashboardWidthSupport);
        float height = getResources().getDimension(R.dimen.imgDashboardHeightSupport);
        ImageView image;

        //ES ineficiente lo hacemos directamente con un imageview
        //ArrayList<ImageView> arrayListImageViews = new ArrayList<>();

        for (int i = 0; i < images.length; i++) {
            image = new ImageView(this);
            image.setImageResource(images[i]);
            //Creamos un objeto de la clase LayoutParams
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width=(int)width;
            params.height=(int)height;
            //Para especificar el peso tenemos que usar las especificaciones de fila, rowSpec y de la columna columnSpec.
            //Establecemos lo definido en el objeto LayoutParams en esa imagen. Decimos que la fila es indefinida
            //porque se rellena solo. En orden es: numero de fila, layout_gravity y el peso.
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1F);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1F);
            image.setLayoutParams(params);
            grdDashboard.addView(image);
        }

    }

}
