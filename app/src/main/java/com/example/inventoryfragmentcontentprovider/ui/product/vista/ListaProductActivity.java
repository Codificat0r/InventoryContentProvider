package com.example.inventoryfragmentcontentprovider.ui.product.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.inventoryfragmentcontentprovider.R;
import com.example.inventoryfragmentcontentprovider.data.db.model.Product;
import com.example.inventoryfragmentcontentprovider.ui.product.contract.ContractListaProduct;
import com.example.inventoryfragmentcontentprovider.ui.product.presenter.ListaProductPresenter;

import java.util.ArrayList;

public class ListaProductActivity extends AppCompatActivity implements ContractListaProduct.Vista {

    private ListView lstvProduct;
    private ArrayAdapter<Product> adapter;
    private ContractListaProduct.Presenter presenter;

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
                Toast.makeText(ListaProductActivity.this, "Has hecho click sobre el elemento \"" + adapter.getItem(i).getName() + "\" con id " + adapter.getItem(i).get_id(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onLoadedProducts(ArrayList<Product> products) {
        adapter.clear();
        adapter.addAll(products);
    }
}