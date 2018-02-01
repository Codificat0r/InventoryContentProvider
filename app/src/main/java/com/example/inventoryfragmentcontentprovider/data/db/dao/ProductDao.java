package com.example.inventoryfragmentcontentprovider.data.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.inventoryfragmentcontentprovider.data.db.InventoryContract;
import com.example.inventoryfragmentcontentprovider.data.db.InventoryOpenHelper;
import com.example.inventoryfragmentcontentprovider.data.db.model.Product;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductDao {
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
}
