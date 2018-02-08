package com.example.inventoryfragmentcontentprovider.data.provider.dao;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

import com.example.inventoryfragmentcontentprovider.data.base.SectorDao;
import com.example.inventoryfragmentcontentprovider.data.db.InventoryContract;
import com.example.inventoryfragmentcontentprovider.data.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.model.Product;
import com.example.inventoryfragmentcontentprovider.data.model.Sector;
import com.example.inventoryfragmentcontentprovider.data.provider.InventoryProviderContract;
import com.example.inventoryfragmentcontentprovider.ui.inventory.InventoryApplication;

import java.util.ArrayList;

/**
 * Created by usuario on 8/02/18.
 */

public class SectorDaoImpl implements SectorDao {
    @Override
    public ArrayList<Sector> loadAll() {
        ArrayList<Sector> sectors = new ArrayList<>();
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();

        String[] projection = {
                InventoryContract.SectorEntry._ID,
                InventoryContract.SectorEntry.COLUMN_DEPENDENCYID,
                InventoryContract.SectorEntry.COLUMN_NAME,
                InventoryContract.SectorEntry.COLUMN_SHORTNAME,
                InventoryContract.SectorEntry.COLUMN_DESCRIPTION,
                InventoryContract.SectorEntry.COLUMN_IMAGENAME
        };

        Cursor c = cr.query(InventoryProviderContract.Sector.CONTENT_URI, projection, null,null,null,null);

        if (c.moveToFirst()) {
            do {
                boolean variando = true;
                Sector tmp = new Sector(c.getInt(0), c.getString(2),c.getString(3),c.getString(4), c.getInt(1), variando = !variando, false, c.getString(5));
                sectors.add(tmp);
            } while (c.moveToNext());
        }

        return sectors;
    }

    @Override
    public long add(Sector sector) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();
        Uri uri = cr.insert(InventoryProviderContract.Sector.CONTENT_URI, createContentValue(sector));

        if (uri == null)
            return -1;
        return Long.parseLong(uri.getLastPathSegment());
    }

    @Override
    public long delete(Sector sector) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();
        return cr.delete(InventoryProviderContract.Sector.CONTENT_URI, BaseColumns._ID + "=" + sector.getId(), null);
    }

    @Override
    public long update(Sector sector) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();
        String where = InventoryContract.SectorEntry._ID + "=" + sector.getId();
        return cr.update(InventoryProviderContract.Sector.CONTENT_URI, createContentValue(sector), where, null);
    }

    private ContentValues createContentValue(Sector sector) {

        ContentValues contenido = new ContentValues();
        contenido.put(InventoryContract.SectorEntry.COLUMN_NAME, sector.get_name());
        contenido.put(InventoryContract.SectorEntry.COLUMN_SHORTNAME, sector.get_shortname());
        contenido.put(InventoryContract.SectorEntry.COLUMN_DESCRIPTION, sector.get_description());
        contenido.put(InventoryContract.SectorEntry.COLUMN_DEPENDENCYID, sector.get_dependencyId());
        contenido.put(InventoryContract.SectorEntry.COLUMN_IMAGENAME, sector.get_imageName());

        return contenido;
    }
}
