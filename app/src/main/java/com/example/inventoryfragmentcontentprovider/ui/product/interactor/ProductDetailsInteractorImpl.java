package com.example.inventoryfragmentcontentprovider.ui.product.interactor;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductDetailsInteractorImpl implements ProductDetailsInteractor {

    private OnActionFinishedListener listener;

    public interface OnActionFinishedListener {

    }

    public ProductDetailsInteractorImpl(OnActionFinishedListener listener) {
        this.listener = listener;
    }

}
