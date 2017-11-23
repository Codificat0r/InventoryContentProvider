package com.example.inventoryfragment;

import com.example.inventoryfragment.data.db.model.User;
import com.example.inventoryfragment.data.db.repository.UserRepository;
import com.example.inventoryfragment.ui.utils.CommonUtils;

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
        boolean resultado;
        //Contraseña correcta
        resultado = CommonUtils.isPasswordValid("Aabc1a");
        assertTrue(resultado);
        //No hay mayusculas
        resultado = CommonUtils.isPasswordValid("abc123");
        assertFalse(resultado);
        //No hay numeros
        resultado = CommonUtils.isPasswordValid("Abcdef");
        assertFalse(resultado);
        //No hay minusculas
        resultado = CommonUtils.isPasswordValid("A123BC");
        assertFalse(resultado);
        //No hay mayusculas ni numeros
        resultado = CommonUtils.isPasswordValid("abcdef");
        assertFalse(resultado);
        //No hay mayusculas ni minusculas
        resultado = CommonUtils.isPasswordValid("123456");
        assertFalse(resultado);
        //No hay minusculas ni numeros
        resultado = CommonUtils.isPasswordValid("ABCDEF");
        assertFalse(resultado);
        //Menos de seis digitos
        resultado = CommonUtils.isPasswordValid("Ab123");
        assertFalse(resultado);
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