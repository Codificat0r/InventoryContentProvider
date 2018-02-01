package com.example.inventoryfragmentcontentprovider.ui.product.interactor;

import android.database.sqlite.SQLiteDatabase;

import com.example.inventoryfragmentcontentprovider.data.db.InventoryOpenHelper;
import com.example.inventoryfragmentcontentprovider.data.db.model.Product;
import com.example.inventoryfragmentcontentprovider.data.db.repository.ProductRepository;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ListaProductInteractorImpl implements ListaProductInteractor {

    private OnActionFinishedListener listener;

    public interface OnActionFinishedListener {
        void onSuccess(ArrayList<Product> products);
    }

    public ListaProductInteractorImpl(OnActionFinishedListener listener) {
        this.listener = listener;
    }

    @Override
    public void pedirLoadProducts() {
        listener.onSuccess(ProductRepository.getInstance().getProducts());
    }
}
