package com.example.inventoryfragmentcontentprovider.data.base;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.inventoryfragmentcontentprovider.data.db.InventoryContract;
import com.example.inventoryfragmentcontentprovider.data.db.InventoryOpenHelper;
import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;

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
