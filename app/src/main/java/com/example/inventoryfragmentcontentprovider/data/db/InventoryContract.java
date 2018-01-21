package com.example.inventoryfragmentcontentprovider.data.db;

import android.provider.BaseColumns;

/**
 * Created by usuario on 19/01/18.
 */

public class InventoryContract {

    //Debe tener un constructor private porque no se puede instanciar
    private InventoryContract() {
    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Inventory.db";

    //Por cada tabla se crea una clase que implementa la interfaz BaseColumns. Dicha clase añade
    //ya un ID entre otras cosas.

    public static class DependencyEntry implements BaseColumns {
        public static final String TABLE_NAME = "dependency";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGENAME = "imageName";
        public static final String[] ALL_COLUMNS = new String[] {
          BaseColumns._ID,COLUMN_NAME,COLUMN_SHORTNAME,COLUMN_DESCRIPTION,COLUMN_IMAGENAME
        };

        //Consulta de creacion de la tabla en cuestión.
        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL)",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGENAME);

        //Borrado de la tabla
        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);

        //Insert en la tabla. El id se autoincrementa por lo que no se inserta
        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s','%s','%s','%s'),('%s','%s','%s','%s')",
                TABLE_NAME,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGENAME,
                "Aula de 2CFGS",
                "2CFGS",
                "Aula de los resopladores de 2CFGS",
                "No tengo imagen",

                "Aula de 1CFGS",
                "1CFGS",
                "Aula de los pardillos de 1CFGS",
                "No tengo imagen");
    }

    public static class SectorEntry implements BaseColumns {
        public static final String TABLE_NAME = "sector";
        public static final String COLUMN_DEPENDENCYID = "dependencyId";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGENAME = "imageName";
        public static final String[] ALL_COLUMNS = new String[] {
                BaseColumns._ID,COLUMN_DEPENDENCYID,COLUMN_NAME,COLUMN_SHORTNAME,COLUMN_DESCRIPTION,COLUMN_IMAGENAME
        };

        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "%s INTEGER NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "FOREIGN KEY (%s) REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE RESTRICT)",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_DEPENDENCYID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGENAME,
                COLUMN_DEPENDENCYID,
                DependencyEntry.TABLE_NAME,
                BaseColumns._ID);

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s,%s,%s,%s,%s) VALUES (%s,'%s','%s','%s','%s'),(%s,'%s','%s','%s','%s'),(%s,'%s','%s','%s','%s')",
                TABLE_NAME, COLUMN_DEPENDENCYID, COLUMN_NAME, COLUMN_SHORTNAME, COLUMN_DESCRIPTION, COLUMN_IMAGENAME,
                "1","ARMARIO1","ARM1","Armario de la entrada a la izquierda","No tengo imagen",
                "1","ARMARIO2","ARM2","Armario de la entrada a la derecha","No tengo imagen",
                "2","ARMARIO3","ARM3","Armario de la entrada en el centro","No tengo imagen");

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);

    }


}
