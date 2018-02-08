package com.example.inventoryfragmentcontentprovider.ui.product.interactor;

import com.example.inventoryfragmentcontentprovider.data.model.Product;
import com.example.inventoryfragmentcontentprovider.data.repository.ProductRepository;

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
