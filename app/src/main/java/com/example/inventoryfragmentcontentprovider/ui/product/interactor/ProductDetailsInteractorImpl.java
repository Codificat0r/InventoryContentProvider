package com.example.inventoryfragmentcontentprovider.ui.product.interactor;

import com.example.inventoryfragmentcontentprovider.data.model.ProductView;
import com.example.inventoryfragmentcontentprovider.data.repository.ProductRepository;

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
