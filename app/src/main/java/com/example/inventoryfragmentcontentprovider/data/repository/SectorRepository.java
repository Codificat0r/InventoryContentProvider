package com.example.inventoryfragmentcontentprovider.data.repository;

import com.example.inventoryfragmentcontentprovider.data.base.SectorDao;
import com.example.inventoryfragmentcontentprovider.data.model.Sector;
import com.example.inventoryfragmentcontentprovider.data.provider.dao.SectorDaoImpl;

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
        this.sectorDao = new SectorDaoImpl();
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
