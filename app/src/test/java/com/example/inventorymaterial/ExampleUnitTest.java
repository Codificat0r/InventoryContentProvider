package com.example.inventorymaterial;

import com.example.inventorymaterial.pojo.User;
import com.example.inventorymaterial.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private ArrayList<User> users;

    //Se creara una clase UserRepository con los metodos pero sin datos, los datos los iremos
    //añadiendo nosotros. El @Mock le indica al sistema de que es un objeto Mock, vacio, sino
    //nos dará NullPointerException al trabajar con el.
    @Mock
    UserRepository userRepository;

    //Lo que hacemos con @Before es quer este metodo siempre se va a ejecutar antes de cualquier metodo de prueba.
    @Before
    public void initialice() {
        userRepository = mock(UserRepository.class);
        users = new ArrayList<>();
        users.add(new User(1, "Paco", "1234", "Paco", "paco1@gmail.com", true, true));
        users.add(new User(1, "Pepe", "1234", "Pepe", "pepe121311@gmail.com", false, false));
        users.add(new User(1, "Maria", "1234", "Maria", "maria1@gmail.com", false, false));
    }

    //1. El usuario existe en la base de datos (Repository)
    //Para poder realizar esta prueba debemos poder comparar dos objetos User

    @Test
    public void isUserExists_isCorrect() {

        //Cuando se llame al método isUserExists con ese parámetro exacto, devuelva un valor predeterminado.
        //Si lo llamamos con otro parametro, como el metodo está vacio, no tiene codigo, que es lo que
        //se hace con la libreria Mockito, fallará. Estamos simulando un comportamiento, no se llama
        //al método real.
        when(userRepository.isUserExists(users.get(0))).thenReturn(true);
        assertTrue(userRepository.isUserExists(users.get(0)));
    }

    @Test
    public void getUsers_isCorrect() {
        when(userRepository.getUsers()).thenReturn(users);
        assertEquals(users.get(0), userRepository.getUsers().get(0));
    }

    //2. Que la contraseña sea correcta (coincide con la base de datos)

    @Test
    public void password_isCorrect() {
        when(userRepository.getUsers()).thenReturn(users);
        assertEquals("1234", userRepository.getUsers().get(0).getPassword());
    }

    @Test
    public void signIn_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testAssertions() {
        User user1 = new User(1, "Paco", "1234", "Paco", "paco1@gmail.com", true, true);
        User user2 = null;
        User user3 = user1;

        //Comprobar si dos objetos son iguales. Debemos implementar en dicho objeto a comparar el metodo Equals
        assertEquals(user1, users.get(0));

        //Comprobar si un objeto es nulo
        assertNull(user2);

        //Comprobar si un objeto no es nulo
        assertNotNull(user1);

        //Comprobar si dos objetos apuntan a la misma direccion de memoria, es decir, que son el mismo
        assertSame(user1, user3);


    }

    //3. El email no existe en la base de datos (Repository)

    //4. El usuario no existe en la base de datos

    @Test
    public void signUp_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);


    }
}