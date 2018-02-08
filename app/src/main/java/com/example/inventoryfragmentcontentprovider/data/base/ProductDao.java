package com.example.inventoryfragmentcontentprovider.data.base;

import com.example.inventoryfragmentcontentprovider.data.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.model.Product;
import com.example.inventoryfragmentcontentprovider.data.model.ProductView;

import java.util.ArrayList;

/**
 * Created by usuario on 8/02/18.
 */

public interface ProductDao {
    ArrayList<Product> loadAll();
    ProductView getProductViewInnerJoin(int _idProducto);
}
