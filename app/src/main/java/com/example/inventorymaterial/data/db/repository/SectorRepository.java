package com.example.inventorymaterial.data.db.repository;

import com.example.inventorymaterial.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Clase que almacenará diferentes sectores.
 * @author Carlos Cruz Domínguez
 */

public class SectorRepository {
    private ArrayList<Sector> sectors;

    private static SectorRepository sectorRepository;

    static {
        sectorRepository = new SectorRepository();
    }

    public SectorRepository() {
        this.sectors = new ArrayList();
        initialize();
    }

    public void initialize() {
        addSector(new Sector(1, "Armario", "ARM1", "Armario principal del aula 1", 1, true, true));
        addSector(new Sector(2, "Armario", "ARM2", "Armario secundario del aula 1", 1, false, false));
        addSector(new Sector(3, "Estanteria", "EST1", "Estanteria principal del aula 3", 3, false, false));
        addSector(new Sector(4, "Armario", "ARM1", "Armario principal del aula 1", 1, true, true));
        addSector(new Sector(5, "Armario", "ARM2", "Armario secundario del aula 1", 1, false, false));
        addSector(new Sector(6, "Estanteria", "EST1", "Estanteria principal del aula 3", 3, false, false));
        addSector(new Sector(7, "Armario", "ARM1", "Armario principal del aula 1", 1, true, true));
        addSector(new Sector(8, "Armario", "ARM2", "Armario secundario del aula 1", 1, false, false));
        addSector(new Sector(9, "Estanteria", "EST1", "Estanteria principal del aula 3", 3, false, false));
        addSector(new Sector(10, "Armario", "ARM1", "Armario principal del aula 1", 1, true, true));
        addSector(new Sector(11, "Armario", "ARM2", "Armario secundario del aula 1", 1, false, false));
        addSector(new Sector(12, "Estanteria", "EST1", "Estanteria principal del aula 3", 3, false, false));
    }

    public void addSector (Sector sector) {
        sectors.add(sector);
    }

    public static SectorRepository getInstance() {
        //Otra opción para inicializar es esta.
        if (sectorRepository == null)
            return sectorRepository;
        return sectorRepository;
    }

    public ArrayList<Sector> getSectors() {
        return sectors;
    }
}
