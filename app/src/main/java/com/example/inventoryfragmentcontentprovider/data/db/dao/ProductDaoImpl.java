package com.example.inventoryfragmentcontentprovider.data.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.inventoryfragmentcontentprovider.data.base.ProductDao;
import com.example.inventoryfragmentcontentprovider.data.db.InventoryContract;
import com.example.inventoryfragmentcontentprovider.data.db.InventoryOpenHelper;
import com.example.inventoryfragmentcontentprovider.data.model.Product;
import com.example.inventoryfragmentcontentprovider.data.model.ProductView;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductDaoImpl implements ProductDao {
    public ArrayList<Product> loadAll() {
        ArrayList<Product> products = new ArrayList<>();

        SQLiteDatabase db = InventoryOpenHelper.getInstance().openDatabase();
        Cursor c = db.query(InventoryContract.ProductEntry.TABLE_NAME, InventoryContract.ProductEntry.ALL_COLUMNS, null, null, null, null, null);

        if (c.moveToFirst()) {
            do {
                Product tmp = new Product(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9), c.getInt(10), c.getInt(11), c.getInt(12), c.getInt(13), c.getInt(14));
                products.add(tmp);
            } while (c.moveToNext());
        }

        return products;
    }

    public ProductView getProductViewInnerJoin(int _idProducto) {
        SQLiteDatabase db = InventoryOpenHelper.getInstance().openDatabase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        //Le damos lo de despues del from, las tablas, el inner join
        queryBuilder.setTables(InventoryContract.ProductJoinEntry.PRODUCT_INNER);
        //Le damos la lista de nombres reales y sus respectivos motes, el ProjectionMap
        queryBuilder.setProjectionMap(InventoryContract.ProductJoinEntry.sProductInnerProjectionMap);
        //1. Vamos a mostrar si la consuta es correcta. TOTALMENTE NECESARIO

        //Le damos al buildQuery todas las columnas, color select *, y el ProjectionMap se encargará,
        //al estar ya cargado, de ponerle los "as 'tal'" a cada columna, es decir, de ponerle motes
        //a cada una.
        String sql = queryBuilder.buildQuery(InventoryContract.ProductJoinEntry.ALL_COLUMNS, null,null,null,null,null);
        Log.i("INVENTORYFRAGMENTBD", sql);

        //Hacemos la consulta una vez sea correcta. La interrogacion se sustituye por los elementos del array selectionArgs
        String selection = InventoryContract.ProductJoinEntry.TABLE_NAME+"."+ BaseColumns._ID + "=?";
        String[] selectionArgs = {Integer.toString(_idProducto)};

        Cursor cursor = queryBuilder.query(db, InventoryContract.ProductJoinEntry.ALL_COLUMNS, selection, selectionArgs,null,null,null,null);

        if (cursor.moveToFirst()) {
            ProductView tmp = new ProductView(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getInt(10), cursor.getString(11), cursor.getInt(12), cursor.getString(13));
            return tmp;
        }

        return null;
    }
}
