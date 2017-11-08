package com.example.inventorymaterial.repository;

import com.example.inventorymaterial.pojo.Sector;
import com.example.inventorymaterial.pojo.User;

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
        saveUser(new User(1, "Paco", "1234", "Paco", "paco1@gmail.com", true, true));
        saveUser(new User(1, "Pepe", "1234", "Pepe", "pepe121311@gmail.com", false, false));
        saveUser(new User(1, "Maria", "1234", "Maria", "maria1@gmail.com", false, false));
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

}
