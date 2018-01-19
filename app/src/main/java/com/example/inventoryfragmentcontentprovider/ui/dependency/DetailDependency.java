package com.example.inventoryfragmentcontentprovider.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by usuario on 23/11/17.
 */

public class DetailDependency extends Fragment{
    public static final String TAG = "detaildependency";

    //Patron factory
    public static Fragment newInstance(@Nullable Bundle arguments) {
        DetailDependency detailDependency = new DetailDependency();
        if (arguments != null) {
            detailDependency.setArguments(arguments);
        }
        return detailDependency;
    }
}
