package com.example.inventoryfragmentcontentprovider.data.provider.dao;

import com.example.inventoryfragmentcontentprovider.data.base.DependencyDao;
import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;

import java.util.ArrayList;

/**
 * Dao PARA EL CONTENT PROVIDER
 */

public class DependencyDaoImpl implements DependencyDao {
    @Override
    public ArrayList<Dependency> loadAll() {
        return null;
    }

    @Override
    public long add(Dependency dependency) {
        return 0;
    }

    @Override
    public boolean exists(Dependency dependency) {
        return false;
    }

    @Override
    public long delete(Dependency dependency) {
        return 0;
    }

    @Override
    public long update(Dependency dependency) {
        return 0;
    }
}
