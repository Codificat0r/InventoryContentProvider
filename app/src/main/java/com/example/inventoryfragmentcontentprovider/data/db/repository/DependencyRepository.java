package com.example.inventoryfragmentcontentprovider.data.db.repository;

import com.example.inventoryfragmentcontentprovider.data.base.DependencyDao;
import com.example.inventoryfragmentcontentprovider.data.db.InteractorCallback;
import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.provider.dao.DependencyDaoImpl;

import java.util.ArrayList;

/**
 * Clase que almacenará diferentes dependencias OBTENIDAS DEL DAO. Es el repository el que
 * obtendrá los datos de la database local y la remota. Habrá un DependencyDaoImpl y un DependencyDaoWebService.
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
    //Constructor privado y hacemos que esta clase se cree a ella misma para asegurar de que solo hay un objeto
    //de la misma.
    private static DependencyRepository dependencyRepository;

    public static boolean cargadosTodos;

    /*
    Inicialización
     */
    /*
    Inicializar todos los atributos de ámbito static o de clase.
     */

    static {
        dependencyRepository = new DependencyRepository();
        cargadosTodos = false;
    }

    private DependencyRepository() {
        //CADA REPOSITORIO TIENE SU PROPIO DAO.
        //Ahora mismo tenemos el Dao del ContentProvider. Si necesitamos
        //usar el otro dao de DB, cambiamos el IMPORT por el import de la ruta del otro DAO.
        this.dependencyDao = new DependencyDaoImpl();
    }

    /*
    Métodos
     */

    public static DependencyRepository getInstance() {
        //Otra opción para inicializar es esta.
        if (dependencyRepository == null)
            return dependencyRepository;
        return dependencyRepository;
    }




    /**======================================================================================================
     *
     * IMPORTANTE, VER!!!!!!!!!!!
     *
     * El interactor se comunicará con el repository y el repository delegará todas las tareas que se
     * le pidan al dao, es decir, si quiero los datos ordenados, una consulta con order by, si quiero
     * ver si existe, una consulta con un where, etc.
     *
     * Dependiendo de si la base de datos local y remote comparten los mismos datos, pueden heredar
     * de una misma interfaz. Si cada uno tiene datos diferentes, cada uno será su propio tipo. Tambien
     * puede haber dos bases de datos remotas, Firebase y MySQL como en mi caso, etc. Todas las combinaciones
     * significan diferentes maneras de implementarlos. Ser inteligente.
     *
     * ======================================================================================================*/





    public ArrayList<Dependency> getDependencies() {
        ArrayList<Dependency> dependencies = dependencyDao.loadAll();

        return dependencies;
    }

    public long deleteDependency(Dependency dependency, InteractorCallback callback) {
        //AHORA CON DAO
        try {
            long count = dependencyDao.delete(dependency);
            if (count == 0)
                callback.onError(new Error("No se ha podido eliminar la dependencia " + dependency.getName() + " de la base de datos"));
            else
                callback.onSuccess();
            return count;
        } catch (Exception e) {
            callback.onError(new Exception("Error: " + e.getMessage(), e));
        }
        return 0;
    }

    public long addDependency(Dependency dependency) {
        return dependencyDao.add(dependency);
    }

    //Hay otra forma de vincular el repositorio con el interactor a traves del lanzamiento de excepciones con
    //throws y que se la lance la excepcion al repositorio y alli la capturamos y que avise a la vista.
    public long updateDependency(Dependency dependency, InteractorCallback callback) {
        try {
            long count = dependencyDao.update(dependency);
            if (count == 0)
                callback.onError(new Error("No se ha podido editar la dependencia " + dependency.getName() + " en la base de datos"));
            else
                callback.onSuccess();
            return count;
        } catch (Exception e) {
            callback.onError(new Exception("Error: " + e.getMessage(), e));
        }
        return 0;
    }

    public boolean existsDependency(Dependency dependency) {
        return dependencyDao.exists(dependency);
    }

    public void orderByName() {

    }

    public void orderById() {

    }
}
