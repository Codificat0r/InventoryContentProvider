package com.example.inventoryfragmentcontentprovider.ui.dependency;

import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;

/**
 * Created by usuario on 27/11/17.
 */

public interface ListDependencyInteractor {
        void getAllDependencies();
        void deleteDependency(Dependency dependency);
        void orderByName();
        void orderById();
}
