package com.example.inventoryfragmentcontentprovider.data.db;

/**
 * Created by usuario on 25/01/18.
 */

public interface InteractorCallback {
    void onError(Error error);

    void onError(Exception exception);

    void onSuccess();
}
