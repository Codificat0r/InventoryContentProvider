package com.example.inventoryfragmentcontentprovider.ui.product.presenter;

import com.example.inventoryfragmentcontentprovider.data.model.ProductView;
import com.example.inventoryfragmentcontentprovider.ui.product.contract.ContractProductDetails;
import com.example.inventoryfragmentcontentprovider.ui.product.interactor.ProductDetailsInteractor;
import com.example.inventoryfragmentcontentprovider.ui.product.interactor.ProductDetailsInteractorImpl;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductDetailsPresenter implements ContractProductDetails.Presenter, ProductDetailsInteractorImpl.OnActionFinishedListener {

    private ContractProductDetails.Vista vista;
    private ProductDetailsInteractor interactor;

    public ProductDetailsPresenter (ContractProductDetails.Vista vista) {
        this.vista = vista;
        this.interactor = new ProductDetailsInteractorImpl(this);
    }

    @Override
    public void viewProduct(int _id) {
        interactor.viewProduct(_id);
    }

    @Override
    public void onSuccess(ProductView productView) {
        vista.onSuccess(productView);
    }

}
