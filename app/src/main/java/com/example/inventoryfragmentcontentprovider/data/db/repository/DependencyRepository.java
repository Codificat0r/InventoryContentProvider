package com.example.inventoryfragmentcontentprovider.data.db.repository;

import android.database.Cursor;

import com.example.inventoryfragmentcontentprovider.data.db.dao.DependencyDao;
import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;
import com.example.inventoryfragmentcontentprovider.ui.utils.comparator.IdComparator;
import com.example.inventoryfragmentcontentprovider.ui.utils.comparator.NameComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Clase que almacenará diferentes dependencias OBTENIDAS DEL DAO. Es el repository el que
 * obtendrá los datos de la database local y la remota. Habrá un DependencyDao y un DependencyDaoWebService.
 * Este ultimo trabajará lanzando consultas a la API REST o algo asi, es decir, trabajará con la base
 * de datos remota. En un MVP Clean el repositorio si o si deberia devolver un ArrayList y no un cursor.
 * Vamos a hacerlo con Cursor y con ArrayList para ver los diferentes ejemplos.
 * @author Carlos Cruz Domínguez
 */

public class DependencyRepository {

    private static DependencyDao dependencyDao;

    /*
    Declaración
     */
    private ArrayList<Dependency> dependencies;
    //Constructor privado y hacemos que esta clase se cree a ella misma para asegurar de que solo hay un objeto
    //de la misma.
    private static DependencyRepository dependencyRepository;

    /*
    Inicialización
     */
    /*
    Inicializar todos los atributos de ámbito static o de clase.
     */

    static {
        dependencyRepository = new DependencyRepository();
    }

    private DependencyRepository() {
        this.dependencies = new ArrayList<>();
        //CADA REPOSITORIO TIENE SU PROPIO DAO.
        this.dependencyDao = new DependencyDao();
    }

    /*
    Métodos
     */

    public void addDependency(Dependency dependency) {
        //dependencyDao.addDependency(dependency);
    }

    public static DependencyRepository getInstance() {
        //Otra opción para inicializar es esta.
        if (dependencyRepository == null)
            return dependencyRepository;
        return dependencyRepository;
    }

    //Ordenamos por el criterio POR DEFECTO antes de devolver la lista.
    public ArrayList<Dependency> getDependencies() {
        dependencies.clear();
        //Se convertirá el cursor en ArrayList para poder devolver un ArrayList;
        Cursor cursor = getDependenciesCursor();

        //El cursor siempre lo posicionamos el primero, ya que siempre viene before first, antes del primero.
        //Devuelve false si el cursor esta vacio y en caso contrario devuelve true y se mueve al primero
        if (cursor.moveToFirst()) {
            //Accedemos a las columnas en el mismo orden que hemos hecho el ALL_COLUMNS de InventoryContract.
            //Mientras se pueda mover al siguiente (es decir, devuelve true) funciona.
            do {
                Dependency dependency = new Dependency(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                dependencies.add(dependency);
            } while (cursor.moveToNext());
        }

        return dependencies;
    }

    public Cursor getDependenciesCursor() {
        Cursor cursor = dependencyDao.loadAll();
        return cursor;
    }

    public void deleteDependency(Dependency d) {
        //AHORA CON DAO

    }

    public boolean exists(Dependency dependency) {
        return dependencies.contains(dependency);
    }

    public void orderByName() {

    }

    public void orderById() {

    }
}
