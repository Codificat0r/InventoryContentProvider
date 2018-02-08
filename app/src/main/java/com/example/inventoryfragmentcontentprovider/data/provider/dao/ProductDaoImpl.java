package com.example.inventoryfragmentcontentprovider.data.provider.dao;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

import com.example.inventoryfragmentcontentprovider.data.base.ProductDao;
import com.example.inventoryfragmentcontentprovider.data.db.InventoryContract;
import com.example.inventoryfragmentcontentprovider.data.model.Product;
import com.example.inventoryfragmentcontentprovider.data.model.ProductView;
import com.example.inventoryfragmentcontentprovider.data.provider.InventoryProvider;
import com.example.inventoryfragmentcontentprovider.data.provider.InventoryProviderContract;
import com.example.inventoryfragmentcontentprovider.ui.inventory.InventoryApplication;

import java.util.ArrayList;

/**
 * Created by usuario on 8/02/18.
 */

public class ProductDaoImpl implements ProductDao {
    @Override
    public ArrayList<Product> loadAll() {
        ArrayList<Product> products = new ArrayList<>();
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();

        String[] projection = {
                InventoryContract.ProductEntry._ID,
                InventoryContract.ProductEntry.COLUMN_NAME,
                InventoryContract.ProductEntry.COLUMN_SERIAL,
                InventoryContract.ProductEntry.COLUMN_VENDOR,
                InventoryContract.ProductEntry.COLUMN_MODEL,
                InventoryContract.ProductEntry.COLUMN_DESCRIPTION,
                InventoryContract.ProductEntry.COLUMN_PRICE,
                InventoryContract.ProductEntry.COLUMN_BUYDATE,
                InventoryContract.ProductEntry.COLUMN_URL,
                InventoryContract.ProductEntry.COLUMN_NOTES,
                InventoryContract.ProductEntry.COLUMN_CATEGORIA,
                InventoryContract.ProductEntry.COLUMN_SUBCATEGORIA,
                InventoryContract.ProductEntry.COLUMN_TIPO,
                InventoryContract.ProductEntry.COLUMN_SECTOR,
                InventoryContract.ProductEntry.COLUMN_DEPENDENCY
        };

        Cursor c = cr.query(InventoryProviderContract.Product.CONTENT_URI, projection, null,null,null,null);

        if (c.moveToFirst()) {
            do {
                Product tmp = new Product(c.getInt(0), c.getString(1), c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),c.getInt(10), c.getInt(11), c.getInt(12), c.getInt(13), c.getInt(14));
                products.add(tmp);
            } while (c.moveToNext());
        }

        return products;
    }

    @Override
    public ProductView getProductViewInnerJoin(int _idProducto) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();
        return null;


    }
}
