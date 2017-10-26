package com.example.inventory.repository;

import com.example.inventory.pojo.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 26/10/17.
 */

public class DependencyRepository {

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
        initialize();
    }

    /*
    Métodos
     */
    private void initialize () {
        addDependency(new Dependency(1,"1º Ciclo Formativo Grado Superior","1CFGS","1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2,"2º Ciclo Formativo Grado Superior","2CFGS","2CFGS Desarrollo Aplicaciones Multiplataforma"));
    }

    /**
     * Método que añade una dependencia.
     * @param dependency Dependencia a añadir.
     */
    public void addDependency(Dependency dependency) {
        dependencies.add(dependency);
    }

    //Siempre se llamará igual en el patrón singleton el método que devuelve la única instancia que se puede crear de
    //dicho objeto singleton. El patrón singleton se usa para garantizar que solo hay una instancia de la clase, para ello
    //ponemos el constructor privado e inicializamos de manera estática dentro el propio objeto de la clase que se obtendrá
    //con getInstance.
    public static DependencyRepository getInstance() {
        //Otra opción para inicializar es esta.
        if (dependencyRepository == null)
            return dependencyRepository;
        return dependencyRepository;
    }

    public ArrayList<Dependency> getDependencies() {
        return dependencies;
    }
}
