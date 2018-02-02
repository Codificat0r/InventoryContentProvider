package com.example.inventoryfragmentcontentprovider.ui.product.contract;

import com.example.inventoryfragmentcontentprovider.data.db.model.ProductView;

/**
 * Created by usuario on 1/02/18.
 */

public interface ContractProductDetails {
    interface Vista {
        void onSuccess(ProductView productView);
    }

    interface Presenter {
        void viewProduct(int _id);

        void onSuccess(ProductView productView);
    }
}
