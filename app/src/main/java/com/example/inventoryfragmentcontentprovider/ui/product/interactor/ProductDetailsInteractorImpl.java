package com.example.inventoryfragmentcontentprovider.ui.product.interactor;

import com.example.inventoryfragmentcontentprovider.data.db.model.Product;
import com.example.inventoryfragmentcontentprovider.data.db.model.ProductView;
import com.example.inventoryfragmentcontentprovider.data.db.repository.ProductRepository;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductDetailsInteractorImpl implements ProductDetailsInteractor {

    private OnActionFinishedListener listener;

    public interface OnActionFinishedListener {
        void onSuccess(ProductView productView);
    }

    public ProductDetailsInteractorImpl(OnActionFinishedListener listener) {
        this.listener = listener;
    }

    @Override
    public void viewProduct(int _id) {
        listener.onSuccess(ProductRepository.getInstance().getProductViewInfo(_id));
    }
}
