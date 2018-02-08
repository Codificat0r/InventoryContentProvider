package com.example.inventoryfragmentcontentprovider.ui.product.presenter;

import com.example.inventoryfragmentcontentprovider.data.model.Product;
import com.example.inventoryfragmentcontentprovider.ui.product.contract.ContractListaProduct;
import com.example.inventoryfragmentcontentprovider.ui.product.interactor.ListaProductInteractor;
import com.example.inventoryfragmentcontentprovider.ui.product.interactor.ListaProductInteractorImpl;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ListaProductPresenter implements ContractListaProduct.Presenter, ListaProductInteractorImpl.OnActionFinishedListener {

    private ContractListaProduct.Vista vista;
    private ListaProductInteractor interactor;

    public ListaProductPresenter (ContractListaProduct.Vista vista) {
        this.vista = vista;
        this.interactor = new ListaProductInteractorImpl(this);
    }

    @Override
    public void loadProducts() {
        interactor.pedirLoadProducts();
    }

    @Override
    public void onSuccess(ArrayList<Product> products) {
        vista.onLoadedProducts(products);
    }
}
