package com.example.inventoryfragment.ui.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.inventoryfragment.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by usuario on 13/11/17.
 */

public class CommonUtils {

    /**
     * Metodo que comprueba que la contraseña ttenga los siguientes requisitos:
     * Debe contener al menos un dígito 0-9
     * Debe contener al menos un caracter en mayúscula
     * Debe contener al menos un caracter en minuscula
     * Debe tener una longitud de al menos seis caracteres
     * @param password
     * @return
     */
    public static boolean isPasswordValid(String password) {
        Pattern pattern;
        Matcher matcher;

        //Sin espacios tampoco, denota la parte de (?=\S+$)
        final String PASSWORD_PATTERN="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}";
        //ESte objeto va a ser el resultado de comprobar si ese patron es correcto. Primero se compila el patron, si este es erroneo
        //da fallo, y el matcher es el resultado de buscar las coincidencias del patron.
        pattern = Pattern.compile(PASSWORD_PATTERN);
        //Usamos el matcher para comprobar la password con el patron establecido.
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    //Una solucion:

    /*interface ConfirmationDialog {
        String MESSAGE = "message";
        String TITLE = "title";
    }

    public static Dialog showConfirmDialog(Bundle bundle, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(bundle.getString(ConfirmationDialog.MESSAGE))
        .setTitle(bundle.getString(ConfirmationDialog.TITLE))
        .setPositiveButton(R.string.btnOk, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        })
        .setNegativeButton(R.string.btnCancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();
    }*/
}
