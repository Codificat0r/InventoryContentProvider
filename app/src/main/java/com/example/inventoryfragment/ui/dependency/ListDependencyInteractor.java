package com.example.inventoryfragment.ui.dependency;

import com.example.inventoryfragment.data.db.model.Dependency;

import java.util.HashMap;

/**
 * Created by usuario on 27/11/17.
 */

public interface ListDependencyInteractor {
        void getAllDependencies();
        void deleteDependency(Dependency dependency);
        void orderByName();
        void orderById();
}
