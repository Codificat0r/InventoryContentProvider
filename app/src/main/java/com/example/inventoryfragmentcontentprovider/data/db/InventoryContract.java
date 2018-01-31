package com.example.inventoryfragmentcontentprovider.data.db;

import android.provider.BaseColumns;

/**
 * Created by usuario on 19/01/18.
 */

public class InventoryContract {

    //Debe tener un constructor private porque no se puede instanciar
    private InventoryContract() {
    }

    public static final int DATABASE_VERSION = 4;
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
        public static final String DEFAULT_SORT = COLUMN_NAME;

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

    public static class ProductEntry implements BaseColumns {
        public static final String TABLE_NAME = "product";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SERIAL = "serial";
        public static final String COLUMN_VENDOR = "vendor";
        public static final String COLUMN_MODEL = "model";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_BUYDATE = "buyDate";
        public static final String COLUMN_URL = "url";
        public static final String COLUMN_NOTES = "notes";
        public static final String COLUMN_CATEGORIA = "categoria";
        public static final String COLUMN_SUBCATEGORIA = "subcategoria";
        public static final String COLUMN_TIPO = "tipo";
        public static final String[] ALL_COLUMNS = {BaseColumns._ID, COLUMN_NAME, COLUMN_SERIAL, COLUMN_VENDOR, COLUMN_MODEL, COLUMN_DESCRIPTION, COLUMN_PRICE, COLUMN_BUYDATE, COLUMN_URL, COLUMN_NOTES, COLUMN_CATEGORIA, COLUMN_SUBCATEGORIA, COLUMN_TIPO};

        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s INTEGER NOT NULL, " +
                        "%s INTEGER NOT NULL, " +
                        "%s INTEGER NOT NULL, " +
                        "FOREIGN KEY (%s) REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE RESTRICT)" +
                        "FOREIGN KEY (%s) REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE RESTRICT)" +
                        "FOREIGN KEY (%s) REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE RESTRICT)",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SERIAL,
                COLUMN_VENDOR,
                COLUMN_MODEL,
                COLUMN_DESCRIPTION,
                COLUMN_PRICE,
                COLUMN_BUYDATE,
                COLUMN_URL,
                COLUMN_NOTES,
                COLUMN_CATEGORIA,
                COLUMN_SUBCATEGORIA,
                COLUMN_TIPO,
                COLUMN_CATEGORIA, CategoriaEntry.TABLE_NAME, CategoriaEntry._ID,
                COLUMN_SUBCATEGORIA, SubcategoriaEntry.TABLE_NAME, CategoriaEntry._ID,
                COLUMN_TIPO, TipoEntry.TABLE_NAME, TipoEntry._ID );

    }

    public static class CategoriaEntry implements BaseColumns {
        public static final String TABLE_NAME = "categoria";
    }

    public static class SubcategoriaEntry implements BaseColumns {
        public static final String TABLE_NAME = "subcategoria";
    }

    public static class TipoEntry implements BaseColumns {
        public static final String TABLE_NAME = "tipo";
    }

}
