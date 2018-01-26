package com.example.inventoryfragmentcontentprovider.data.db.repository;

import com.example.inventoryfragmentcontentprovider.data.db.dao.SectorDao;
import com.example.inventoryfragmentcontentprovider.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Clase que almacenará diferentes sectores.
 * @author Carlos Cruz Domínguez
 */

public class SectorRepository {

    private static SectorRepository sectorRepository;
    private static SectorDao sectorDao;

    static {
        sectorRepository = new SectorRepository();
    }

    public SectorRepository() {
        this.sectorDao = new SectorDao();
    }

    public void addSector (Sector sector) {
        sectorDao.add(sector);
    }

    public static SectorRepository getInstance() {
        //Otra opción para inicializar es esta.
        if (sectorRepository == null)
            return sectorRepository;
        return sectorRepository;
    }

    public ArrayList<Sector> getSectors() {
        return sectorDao.loadAll();
    }

    public void deleteSector(Sector sector) {
        sectorDao.delete(sector);
    }

    public void updateSector(Sector sector) {
        sectorDao.update(sector);
    }
}
