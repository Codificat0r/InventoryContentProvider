package com.example.inventorymaterial;

import android.app.Application;

/**
 * Esta clase sirve como contenedor de datos para cargar en un ListView.
 * @author Carlos Cruz Domínguez
 */

//Hay que añadirla en el manifest a <application> en su atrib. android:name=".InventoryApplication". ESta es la forma mala.
//Usamos esta clase para cargar datos en el ListView sin acceder a la base de datos. Lo añadimos al manifest para
//que como se crea una Application por defecto y es lo primero que se crea decimos que cree este Application
//para que esta clase sea el contexto de la aplicacion y poder acceder a esta.

public class InventoryApplication extends Application {
    //ArrayList<Dependency> dependencies;

    public InventoryApplication() {
        //dependencies = new ArrayList();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //addDependency(new Dependency(1,"1º Ciclo Formativo Grado Superior","1CFGS","1CFGS Desarrollo Aplicaciones Multiplataforma"));
        //addDependency(new Dependency(2,"2º Ciclo Formativo Grado Superior","2CFGS","2CFGS Desarrollo Aplicaciones Multiplataforma"));
    }

        /**
         * Método que añade una dependencia.
         * @param dependency Dependencia a añadir.
         */

    /*
        public void addDependency(Dependency dependency) {
            dependencies.add(dependency);
        }

        public ArrayList<Dependency> getDependencies() {
            return dependencies;
        }
        */
    }

