package com.example.inventoryfragmentcontentprovider.data.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.inventoryfragmentcontentprovider.data.db.InventoryContract;
import com.example.inventoryfragmentcontentprovider.data.db.InventoryOpenHelper;

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

                break;
            case PRODUCT_ID:
                break;
            case DEPENDENCY:
                cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder, null, null);
                break;
            case DEPENDENCY_ID:
                break;
            case SECTOR:
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
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
