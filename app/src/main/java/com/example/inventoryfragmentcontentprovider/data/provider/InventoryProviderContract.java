package com.example.inventoryfragmentcontentprovider.data.provider;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.inventoryfragmentcontentprovider.data.db.InventoryContract;

import java.util.HashMap;

/**
 * Created by usuario on 5/02/18.
 */

public final class InventoryProviderContract {
    private static final String AUTHORITY = "com.example.inventory";
    //Debe tener un protocolo para ser una uri valida. Será content nuestro protocolo.
    public static final Uri AUTHORITY_URI = Uri.parse("content://"+AUTHORITY);

    //Esta clase no se debe poder instanciar.
    private InventoryProviderContract() {

    }

    public static class Dependency implements BaseColumns {
        public static final String CONTENT_PATH="dependency";
        //La barra (/) ya la mete el mismo metodo de Uri.
        public static final Uri CONTENT_URI = Uri.withAppendedPath(InventoryProviderContract.AUTHORITY_URI, CONTENT_PATH);
        public static final String NAME = "name";
        public static final String SHORTNAME = "shortname";
        public static final String DESCRIPTION = "description";
        public static final String IMAGENAME = "imageName";
        public static final String[] PROJECTION = new String[] {
                BaseColumns._ID,NAME,SHORTNAME,DESCRIPTION,IMAGENAME
        };
    }

    public static class Sector implements BaseColumns {
        public static final String CONTENT_PATH="sector";
        //La barra (/) ya la mete el mismo metodo de Uri.
        public static final Uri CONTENT_URI = Uri.withAppendedPath(InventoryProviderContract.AUTHORITY_URI, CONTENT_PATH);
        public static final String DEPENDENCYID = "dependencyId";
        public static final String NAME = "name";
        public static final String SHORTNAME = "shortname";
        public static final String DESCRIPTION = "description";
        public static final String IMAGENAME = "imageName";
        public static final String[] PROJECTION = new String[] {
                BaseColumns._ID,DEPENDENCYID,NAME,SHORTNAME,DESCRIPTION,IMAGENAME
        };
    }

    public static class Product implements BaseColumns {
        public static final String CONTENT_PATH="product";
        //La barra (/) ya la mete el mismo metodo de Uri.
        public static final Uri CONTENT_URI = Uri.withAppendedPath(InventoryProviderContract.AUTHORITY_URI, CONTENT_PATH);
        public static final String NAME = "name";
        public static final String SERIAL = "serial";
        public static final String VENDOR = "vendor";
        public static final String MODEL = "model";
        public static final String DESCRIPTION = "descriptionProducto";
        public static final String PRICE = "price";
        public static final String BUYDATE = "buyDate";
        public static final String URL = "url";
        public static final String NOTES = "notes";
        public static final String CATEGORIA_ID = "categoria";
        public static final String CATEGORIA_NOMBRE = "categoriaNombre";
        public static final String TIPO_ID = "tipo";
        public static final String TIPO_DESCRIPCION = "tipoDescripcion";
        public static final String[] PROJECTION = {BaseColumns._ID, NAME, SERIAL, VENDOR, MODEL, DESCRIPTION, PRICE, BUYDATE, URL, NOTES, CATEGORIA_ID, CATEGORIA_NOMBRE, TIPO_ID, TIPO_DESCRIPCION};

        public static HashMap<String, String> sProductInnerProjectionMap;
        //Al ser estatico inicializamos en ambito static
        static {
            //Hay que indicar el nombre de todas las columnas que vayamos a obtener aunque vayan a ser las mismas.
            //1er parametro: nombre "mote" de la columna. 2do parametro es la columna real.
            sProductInnerProjectionMap = new HashMap<>();
            sProductInnerProjectionMap.put(InventoryContract.ProductEntry._ID, InventoryContract.ProductEntry.TABLE_NAME + "." + InventoryContract.ProductEntry._ID);
            //Por ejemplo, el nombre se va a repetir, entonces debemos indicar de tal tabla tal nombre de columna va a corresponderse
            //con el que hemos puesto aqui.
            sProductInnerProjectionMap.put(NAME, InventoryContract.ProductEntry.TABLE_NAME+"."+ InventoryContract.ProductEntry.NAME);
            sProductInnerProjectionMap.put(SERIAL, InventoryContract.ProductEntry.SERIAL);
            sProductInnerProjectionMap.put(VENDOR, InventoryContract.ProductEntry.VENDOR);
            sProductInnerProjectionMap.put(MODEL, InventoryContract.ProductEntry.MODEL);
            sProductInnerProjectionMap.put(DESCRIPTION, InventoryContract.ProductEntry.TABLE_NAME + "." + InventoryContract.ProductEntry.DESCRIPTION);
            sProductInnerProjectionMap.put(PRICE, InventoryContract.ProductEntry.PRICE);
            sProductInnerProjectionMap.put(BUYDATE, InventoryContract.ProductEntry.BUYDATE);
            sProductInnerProjectionMap.put(URL, InventoryContract.ProductEntry.URL);
            sProductInnerProjectionMap.put(NOTES, InventoryContract.ProductEntry.NOTES);
            sProductInnerProjectionMap.put(CATEGORIA_ID, InventoryContract.CategoriaEntry.TABLE_NAME+"."+ InventoryContract.CategoriaEntry._ID);
            sProductInnerProjectionMap.put(CATEGORIA_NOMBRE, InventoryContract.CategoriaEntry.TABLE_NAME+"."+ InventoryContract.CategoriaEntry.NAME);
            sProductInnerProjectionMap.put(TIPO_ID, InventoryContract.TipoEntry.TABLE_NAME+"."+ InventoryContract.TipoEntry._ID);
            sProductInnerProjectionMap.put(TIPO_DESCRIPCION, InventoryContract.TipoEntry.TABLE_NAME+"."+ InventoryContract.TipoEntry.DESCRIPTION);
        }
    }

}
