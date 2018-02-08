package com.example.inventoryfragmentcontentprovider.data.base;

import com.example.inventoryfragmentcontentprovider.data.model.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 7/02/18.
 */

public interface DependencyDao {
    ArrayList<Dependency> loadAll();
    long add(Dependency dependency);
    boolean exists(Dependency dependency);
    long delete (Dependency dependency);
    long update(Dependency dependency);
}
