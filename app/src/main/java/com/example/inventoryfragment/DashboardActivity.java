package com.example.inventoryfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.inventoryfragment.data.prefs.AppPreferencesHelper;
import com.example.inventoryfragment.ui.dependency.DependencyActivity;
import com.example.inventoryfragment.ui.inventory.InventoryActivity;
import com.example.inventoryfragment.ui.inventory.InventoryApplication;
import com.example.inventoryfragment.ui.prefs.AccountSettingActivity;
import com.example.inventoryfragment.ui.prefs.GeneralSettingActivity;
import com.example.inventoryfragment.ui.product.ProductActivity;
import com.example.inventoryfragment.ui.sector.view.SectorActivity;

/**
 * Esta clase se encarga de realizar el menú principal.
 * @author Carlos Cruz Domínguez
 */

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        InventoryApplication inventoryApplication = new InventoryApplication();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_dashboard, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_account_settings:
                startActivity(new Intent(DashboardActivity.this, AccountSettingActivity.class));
                break;
            case R.id.action_general_settings:
                startActivity(new Intent(DashboardActivity.this, GeneralSettingActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Vamos a meter las imagenes desde codigo.
    private GridLayout grdDashboard;
    private ClickListenerDashboard listenerDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_support);

        //Sabe que nos referimos al de la activity actual.
        grdDashboard = (GridLayout) findViewById(android.R.id.content);

        //Definir un array de int, que contendra el id de las imagenes Inventory, Product, Dependencias, Secciones,
        //Preferencias.
        int[] images = {R.drawable.ic_inventory, R.drawable.ic_product, R.drawable.ic_dependency,
                R.drawable.ic_section, R.drawable.ic_preferences};
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
        listenerDashboard = new ClickListenerDashboard();

        //Es ineficiente lo hacemos directamente con un imageview
        //ArrayList<ImageView> arrayListImageViews = new ArrayList<>();

        for (int i = 0; i < images.length; i++) {
            image = new ImageView(this);
            image.setId(images[i]);
            image.setImageResource(images[i]);
            //Creamos un objeto de la clase LayoutParams
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = (int) width;
            params.height = (int) height;
            //Para especificar el peso tenemos que usar las especificaciones de fila, rowSpec y de la columna columnSpec.
            //Establecemos lo definido en el objeto LayoutParams en esa imagen. Decimos que la fila es indefinida
            //porque se rellena solo. En orden es: numero de fila, layout_gravity y el peso.
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1F);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1F);
            image.setLayoutParams(params);
            image.setOnClickListener(listenerDashboard);
            grdDashboard.addView(image);
        }

    }

    class ClickListenerDashboard implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.drawable.ic_inventory:
                    intent = new Intent(DashboardActivity.this, InventoryActivity.class);
                    startActivity(intent);
                    break;
                case R.drawable.ic_product:
                    intent = new Intent(DashboardActivity.this, ProductActivity.class);
                    startActivity(intent);
                    break;
                case R.drawable.ic_dependency:
                    intent = new Intent(DashboardActivity.this, DependencyActivity.class);
                    startActivity(intent);
                    break;
                case R.drawable.ic_section:
                    intent = new Intent(DashboardActivity.this, SectorActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

    private void showAppPreferences() {
        AppPreferencesHelper sharedPreferences = ((InventoryApplication)getApplicationContext()).getAppPreferencesHelper();
        sharedPreferences.setCurrentUserName("Lolita");
        String message="Tu usuario de sesión es " + sharedPreferences.getCurrentUserName();
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

