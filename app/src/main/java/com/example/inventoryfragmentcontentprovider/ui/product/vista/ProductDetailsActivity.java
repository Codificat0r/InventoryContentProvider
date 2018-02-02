package com.example.inventoryfragmentcontentprovider.ui.product.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.inventoryfragmentcontentprovider.R;
import com.example.inventoryfragmentcontentprovider.data.db.model.ProductView;
import com.example.inventoryfragmentcontentprovider.ui.product.contract.ContractProductDetails;
import com.example.inventoryfragmentcontentprovider.ui.product.presenter.ProductDetailsPresenter;

/**
 * Esta clase carga el interfaz de la activity de Product
 * @author Carlos Cruz Domínguez
 */

public class ProductDetailsActivity extends AppCompatActivity implements ContractProductDetails.Vista {

    private ContractProductDetails.Presenter presenter;
    private int productoID;

    private EditText edtNombre;
    private EditText edtSerial;
    private EditText edtModelo;
    private EditText edtVendedor;
    private TextView txvCategoriaDato;
    private TextView txvTipoDato;
    private EditText edtDescripcion;
    private EditText edtPrecio;
    private EditText edtFechaCompra;
    private EditText edtUrl;
    private EditText edtNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        edtNombre = findViewById(R.id.edtNombre);
        edtSerial = findViewById(R.id.edtSerial);
        edtModelo = findViewById(R.id.edtModelo);
        edtVendedor = findViewById(R.id.edtVendedor);
        txvCategoriaDato = findViewById(R.id.txvCategoriaDato);
        txvTipoDato = findViewById(R.id.txvTipoDato);
        edtDescripcion = findViewById(R.id.edtDescripcion);
        edtPrecio = findViewById(R.id.edtPrecio);
        edtFechaCompra = findViewById(R.id.edtFechaCompra);
        edtUrl = findViewById(R.id.edtUrl);
        edtNotas = findViewById(R.id.edtNotas);

        presenter = new ProductDetailsPresenter(this);

        productoID = getIntent().getExtras().getInt(ListaProductActivity.PRODUCTBUNDLETAG);

        presenter.viewProduct(productoID);
    }

    @Override
    public void onSuccess(ProductView productView) {
        edtNombre.setText(productView.getName());
        edtSerial.setText(productView.getSerial());
        edtModelo.setText(productView.getModel());
        edtVendedor.setText(productView.getVendor());
        txvCategoriaDato.setText(productView.getCategoriaID() + " -> " + productView.getCategoriaNombre());
        txvTipoDato.setText(productView.getTipoID() + " -> " + productView.getTipoDescription());
        edtDescripcion.setText(productView.getDescription());
        edtPrecio.setText(productView.getPrice());
        edtFechaCompra.setText(productView.getBuydate());
        edtUrl.setText(productView.getUrl());
        edtNotas.setText(productView.getNotes());
    }
}
