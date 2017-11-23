package com.example.inventoryfragment.data.db.repository;

import com.example.inventoryfragment.data.db.model.User;

import java.util.ArrayList;

/**
 * Created by usuario on 8/11/17.
 */

public class UserRepository {

    private ArrayList<User> users;

    private static UserRepository userRepository;

    static {
        userRepository = new UserRepository();
    }

    public UserRepository() {
        this.users = new ArrayList();
        initialize();
    }

    public void initialize() {
        saveUser(new User(1, "paco", "1A2b3c", "Paco", "paco1@gmail.com", true, true));
        saveUser(new User(1, "pepe", "123456", "Pepe", "pepe121311@gmail.com", false, false));
        saveUser(new User(1, "maria", "123456", "Maria", "maria1@gmail.com", false, false));
    }

    public void saveUser (User user) {
        users.add(user);
    }

    public static UserRepository getInstance() {
        //Otra opción para inicializar es esta.
        if (userRepository == null)
            return userRepository;
        return userRepository;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Metodo que comprueba si el usuario está existe en la base de datos
     */
    public boolean isUserExists(User user) {
        return true;
    }

}
