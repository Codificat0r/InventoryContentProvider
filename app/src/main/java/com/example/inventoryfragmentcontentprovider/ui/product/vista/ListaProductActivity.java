package com.example.inventoryfragmentcontentprovider.ui.product.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.inventoryfragmentcontentprovider.R;
import com.example.inventoryfragmentcontentprovider.data.model.Product;
import com.example.inventoryfragmentcontentprovider.ui.product.contract.ContractListaProduct;
import com.example.inventoryfragmentcontentprovider.ui.product.presenter.ListaProductPresenter;

import java.util.ArrayList;

public class ListaProductActivity extends AppCompatActivity implements ContractListaProduct.Vista {

    private ListView lstvProduct;
    private ArrayAdapter<Product> adapter;
    private ContractListaProduct.Presenter presenter;
    public static final String PRODUCTBUNDLETAG = "product";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_product);

        presenter = new ListaProductPresenter(this);

        adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1);

        lstvProduct = findViewById(R.id.lstvProduct);
        lstvProduct.setAdapter(adapter);

        presenter.loadProducts();

        lstvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaProductActivity.this, ProductDetailsActivity.class);
                intent.putExtra(PRODUCTBUNDLETAG, adapter.getItem(i).get_id());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onLoadedProducts(ArrayList<Product> products) {
        adapter.clear();
        adapter.addAll(products);
    }
}
