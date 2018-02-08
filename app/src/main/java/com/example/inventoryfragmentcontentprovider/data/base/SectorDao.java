package com.example.inventoryfragmentcontentprovider.data.base;

import com.example.inventoryfragmentcontentprovider.data.model.Product;
import com.example.inventoryfragmentcontentprovider.data.model.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 8/02/18.
 */

public interface SectorDao {
    ArrayList<Sector> loadAll();
    long add(Sector sector);
    long delete (Sector sector);
    long update(Sector sector);
}
