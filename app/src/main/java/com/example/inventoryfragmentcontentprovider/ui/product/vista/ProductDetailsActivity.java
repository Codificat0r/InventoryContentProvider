package com.example.inventoryfragmentcontentprovider.ui.product.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.inventoryfragmentcontentprovider.R;
import com.example.inventoryfragmentcontentprovider.ui.product.contract.ContractProductDetails;
import com.example.inventoryfragmentcontentprovider.ui.product.presenter.ProductDetailsPresenter;

/**
 * Esta clase carga el interfaz de la activity de Product
 * @author Carlos Cruz Domínguez
 */

public class ProductDetailsActivity extends AppCompatActivity implements ContractProductDetails.Vista {

    private ContractProductDetails.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        presenter = new ProductDetailsPresenter(this);
    }
}
