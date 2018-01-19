package com.example.inventoryfragmentcontentprovider;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 *
 * 1. El usuario introduce un usuario (Prueba instrumental)
 *
 * 2. El usuario introduce una contraseña (Prueba instrumental)
 *
 * 3. El usuario introduce un email (Prueba instrumental)
 *
 * 4. La contraseña tiene que ser al menos de longitud 6 caracteres (Prueba instrumental)
 *
 * 5. Doble comprobación de la contraseña (Prueba instrumental)
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    //1.

    /**
     * Metodo que comprueba que el usuario no es vacío
     */
    @Test
    public void isUserEmpty() {
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnackBarDisplayByMessage(R.string.userEmptyError);
    }

    //2.

    /**
     * Metodo que comprueba que la password no es vacío
     *
     */
    @Test
    public void isPasswordEmpty() {
        onView(withId(R.id.edtUser)).perform(typeText("paco"), closeSoftKeyboard());
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnackBarDisplayByMessage(R.string.passwordEmptyError);
    }

    //3.

    /**
     * Metodo que comprueba que el email no es vacío
     */
    @Test
    public void isEmailEmpty() {
        onView(withId(R.id.edtUser)).perform(typeText("paco"), closeSoftKeyboard());
        onView(withId(R.id.edtPassword)).perform(typeText("123456"), closeSoftKeyboard());
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnackBarDisplayByMessage(R.string.emailEmptyError);
    }

    //4.

    /**
     * Caso de prueba que comprueba que la longitud de la contraseña es correcta
     */
    @Test
    public void passwordLength() {
        onView(withId(R.id.edtUser)).perform(typeText("paco"), closeSoftKeyboard());
        onView(withId(R.id.edtPassword)).perform(typeText("pa"), closeSoftKeyboard());
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnackBarDisplayByMessage(R.string.passwordLengthError);
    }

    //5.

    /**
     * Caso de prueba que comprueba la doble comprobación de la contraseña
     */
    @Test
    public void passwordDoubleCheck() {

    }

    //El @StringRes hace que el entero lo busque en los recursos de string.
    public void checkSnackBarDisplayByMessage(@StringRes int message) {
        //Encontramos el snackbar por el texto que contiene.
        //Checkea que obligatoriamente debe estar visible el elemento, en este caso el SnackBar
        onView(withText(message)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.loginlinearlayout", appContext.getPackageName());
    }
}
