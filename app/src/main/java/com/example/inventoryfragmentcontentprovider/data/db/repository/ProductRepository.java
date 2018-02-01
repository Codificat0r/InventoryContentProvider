package com.example.inventoryfragmentcontentprovider.data.db.repository;

import com.example.inventoryfragmentcontentprovider.data.db.InteractorCallback;
import com.example.inventoryfragmentcontentprovider.data.db.dao.DependencyDao;
import com.example.inventoryfragmentcontentprovider.data.db.dao.ProductDao;
import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.db.model.Product;

import java.util.ArrayList;

/**
 * Clase que almacenará diferentes productos.
 * @author Carlos Cruz Domínguez
 */

public class ProductRepository {

    private static ProductDao productDao;

    /*
    Declaración
     */
    //Constructor privado y hacemos que esta clase se cree a ella misma para asegurar de que solo hay un objeto
    //de la misma.
    private static ProductRepository productRepository;

    public static boolean cargadosTodos;

    /*
    Inicialización
     */
    /*
    Inicializar todos los atributos de ámbito static o de clase.
     */

    static {
        productRepository = new ProductRepository();
        cargadosTodos = false;
    }

    private ProductRepository() {
        //CADA REPOSITORIO TIENE SU PROPIO DAO.
        this.productDao = new ProductDao();
    }

    /*
    Métodos
     */

    public static ProductRepository getInstance() {
        //Otra opción para inicializar es esta.
        if (productRepository == null)
            return productRepository;
        return productRepository;
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





    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = productDao.loadAll();
        return products;
    }

    /*
    public long deleteProduct(Dependency dependency, InteractorCallback callback) {
        //AHORA CON DAO
        try {
            long count = productDao.delete(dependency);
            if (count == 0)
                callback.onError(new Error("No se ha podido eliminar la dependencia " + dependency.getName() + " de la base de datos"));
            else
                callback.onSuccess();
            return count;
        } catch (Exception e) {
            callback.onError(new Exception("Error: " + e.getMessage(), e));
        }
        return 0;
        return 0;
    }

    public long addProduct(Dependency dependency) {
        //return productDao.add(dependency);
        return 0;
    }

    //Hay otra forma de vincular el repositorio con el interactor a traves del lanzamiento de excepciones con
    //throws y que se la lance la excepcion al repositorio y alli la capturamos y que avise a la vista.
    public long updateProduct(Dependency dependency, InteractorCallback callback) {
        try {
            long count = productDao.update(dependency);
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
        return productDao.exists(dependency);
    }

    public void orderByName() {

    }

    public void orderById() {

    }*/
}
