package com.example.inventoryfragmentcontentprovider.ui.product.contract;

import com.example.inventoryfragmentcontentprovider.data.db.model.Product;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public interface ContractListaProduct {
    interface Vista {

        void onLoadedProducts(ArrayList<Product> products);
    }
    interface Presenter {

        void loadProducts();
    }
}
