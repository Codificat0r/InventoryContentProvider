package com.example.inventoryfragment.ui.utils;

/**
 * En lugar de usar una enum que ocupa mucha memoria usaremos una clase que se ocupe de ello y luego el AddEdit
 * tiene un objeto de esto.
 */

public class AddEdit {
    //Esto puede ser una interfaz
    public static final int ADD_MODE = 0;
    public static final int EDIT_MODE = 1;
    private int mode;

    public AddEdit() {
        this.mode = ADD_MODE;
    }

    public AddEdit(int mode) {
        if (mode < ADD_MODE || mode > EDIT_MODE) {
            throw new IllegalArgumentException("Invalid AddEditMode: " + mode);
        }
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}
