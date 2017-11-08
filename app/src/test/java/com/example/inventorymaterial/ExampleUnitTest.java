package com.example.inventorymaterial;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    //1. El usuario introduce un usuario/email

    //2. El usuario introduce una contraseña

    //3. El usuario existe en la base de datos (Repository)

    //4. Que la contraseña sea correcta (coincide con la base de datos)

    @Test
    public void signIn_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);





    }

    //5. El usuario introduce un usuario

    //6. El usuario introduce una contraseña

    //7. El usuario introduce un email

    //8. La contraseña tiene que ser al menos de longitud 6 caracteres

    //9. El email no existe en la base de datos (Repository)

    //10. El usuario no existe en la base de datos

    //11. Doble comprobación de la contraseña

    @Test
    public void signUp_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);


    }
}