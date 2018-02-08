package com.example.inventoryfragmentcontentprovider.data.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.inventoryfragmentcontentprovider.data.db.InventoryContract;
import com.example.inventoryfragmentcontentprovider.data.db.InventoryOpenHelper;
import com.example.inventoryfragmentcontentprovider.ui.inventory.InventoryApplication;

/**
 * Created by usuario on 5/02/18.
 */

public class InventoryProvider extends ContentProvider {
    //Se debe crear una constante por cada peticion/Uri que pueda recoger el ContentProvider.
    private static final int PRODUCT = 1;
    private static final int PRODUCT_ID = 2;
    private static final int DEPENDENCY = 3;
    private static final int DEPENDENCY_ID = 4;
    private static final int SECTOR = 5;
    private static final int SECTOR_ID = 6;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private SQLiteDatabase sqLiteDatabase;

    //Inicializamos los objetos estaticos en el ambito static
    static {
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Product.CONTENT_PATH, PRODUCT);
        //La almohadilla es un comodin que indica un numero, en este caso el id del product a buscar
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Product.CONTENT_PATH+"/#", PRODUCT_ID);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Dependency.CONTENT_PATH, DEPENDENCY);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Dependency.CONTENT_PATH+"/#", DEPENDENCY_ID);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Sector.CONTENT_PATH, SECTOR);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Sector.CONTENT_PATH+"/#", SECTOR_ID);
    }

    @Override
    public boolean onCreate() {
        //La conexion al ser un content provider se quedara abierta ya que las demas aplicaciones (segun los permisos
        // al registrarlo en el manifest) pueden acceder a mi base de datos en cualquier momento.
        sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor = null;

        switch (uriMatcher.match(uri)) {
            case PRODUCT:
                cursor = sqLiteDatabase.query(InventoryContract.ProductEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder, null, null);
                break;
            case PRODUCT_ID:
                cursor = sqLiteDatabase.query(InventoryContract.ProductJoinEntry.PRODUCT_INNER, projection, selection, selectionArgs, sortOrder, null, null);
                break;
            case DEPENDENCY:
                cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder, null, null);
                break;
            case DEPENDENCY_ID:
                break;
            case SECTOR:
                cursor = sqLiteDatabase.query(InventoryContract.SectorEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder, null, null);
                break;
            case SECTOR_ID:
                break;
            case UriMatcher.NO_MATCH:
                throw  new IllegalArgumentException("Invalid Uri: " + uri);
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        //Es lo que devolvemos. dir es un conjunto de datos del tipo de la segunda parte (despues de la primera /)
        //e item significa un unico item devuelto (caso en el que buscamos por id).
        switch (uriMatcher.match(uri)) {
            case PRODUCT:
                return ("vnd.android.cursor.dir/vnd."+InventoryProviderContract.AUTHORITY+"/"+InventoryProviderContract.Product.CONTENT_PATH);
            case PRODUCT_ID:
                return ("vnd.android.cursor.item/vnd."+InventoryProviderContract.AUTHORITY+"/"+InventoryProviderContract.Product.CONTENT_PATH);
            case DEPENDENCY:
                return ("vnd.android.cursor.dir/vnd."+InventoryProviderContract.AUTHORITY+"/"+InventoryProviderContract.Dependency.CONTENT_PATH);
            case DEPENDENCY_ID:
                return ("vnd.android.cursor.item/vnd."+InventoryProviderContract.AUTHORITY+"/"+InventoryProviderContract.Dependency.CONTENT_PATH);
            case SECTOR:
                return ("vnd.android.cursor.dir/vnd."+InventoryProviderContract.AUTHORITY+"/"+InventoryProviderContract.Sector.CONTENT_PATH);
            case SECTOR_ID:
                return ("vnd.android.cursor.item/vnd."+InventoryProviderContract.AUTHORITY+"/"+InventoryProviderContract.Sector.CONTENT_PATH);
            case UriMatcher.NO_MATCH:
                throw  new IllegalArgumentException("Invalid Uri: " + uri);
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        Uri resultado = null;
        Long resultadoInsert;
        switch (uriMatcher.match(uri)) {
            case PRODUCT:
                resultadoInsert = sqLiteDatabase.insert(InventoryContract.ProductEntry.TABLE_NAME, null, contentValues);

                if (resultadoInsert != -1)
                    resultado = Uri.parse(InventoryProviderContract.Product.CONTENT_URI + "/" + resultadoInsert);
                else
                    resultado = null;
                break;
            case DEPENDENCY:
                //Introducimos en la base de datos los datos que nos pasen al provider
                resultadoInsert = sqLiteDatabase.insert(InventoryContract.DependencyEntry.TABLE_NAME, null, contentValues);
                //Como nos devuelve un long y devolvemos una URI, construimos la uri con el ID de la fila insertada al final.
                //Si devuelve -1 no se ha podido insertar, devolvemos el uri a null.
                if (resultadoInsert != -1)
                    resultado = Uri.parse(InventoryProviderContract.Dependency.CONTENT_URI + "/" + resultadoInsert);
                else
                    resultado = null;
                break;
            case SECTOR:
                resultadoInsert = sqLiteDatabase.insert(InventoryContract.SectorEntry.TABLE_NAME, null, contentValues);

                if (resultadoInsert != -1)
                    resultado = Uri.parse(InventoryProviderContract.Sector.CONTENT_URI + "/" + resultadoInsert);
                else
                    resultado = null;
                break;
            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: " + uri);

        }
        return resultado;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String where, @Nullable String[] whereArgs) {
        int resultado = -1;
        switch (uriMatcher.match(uri)) {
            case PRODUCT:
                resultado = sqLiteDatabase.delete(InventoryContract.ProductEntry.TABLE_NAME, where, whereArgs);
                break;
            case DEPENDENCY:
                resultado = sqLiteDatabase.delete(InventoryContract.DependencyEntry.TABLE_NAME, where, whereArgs);
                break;
            case SECTOR:
                resultado = sqLiteDatabase.delete(InventoryContract.SectorEntry.TABLE_NAME, where, whereArgs);
                break;
            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: " + uri);

        }
        return resultado;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String where, @Nullable String[] whereArgs) {
        int resultado = -1;
        switch (uriMatcher.match(uri)) {
            case PRODUCT:
                resultado = sqLiteDatabase.update(InventoryContract.ProductEntry.TABLE_NAME, contentValues, where, whereArgs);
                break;
            case DEPENDENCY:
                resultado = sqLiteDatabase.update(InventoryContract.DependencyEntry.TABLE_NAME, contentValues, where, whereArgs);
                break;
            case SECTOR:
                resultado = sqLiteDatabase.update(InventoryContract.SectorEntry.TABLE_NAME, contentValues, where, whereArgs);
                break;
            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: " + uri);

        }

        return resultado;
    }
}
