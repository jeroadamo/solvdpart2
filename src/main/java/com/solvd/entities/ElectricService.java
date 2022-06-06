package com.solvd.entities;

public class ElectricService {
    private int idElectricService;
    private Area area;
    private boolean worksOnAltitude;
    public ElectricService(int idElectric_service, Area area, boolean worksOnAltitude) {
        idElectricService = idElectric_service;
        this.area = area;
        this.worksOnAltitude = worksOnAltitude;
    }
    public ElectricService(){}
    public int getIdElectricService() {
        return idElectricService;
    }
    public void setIdElectricService(int idElectricService) {
        this.idElectricService = idElectricService;
    }
    public boolean isWorksOnAltitude() {
        return worksOnAltitude;
    }
    public void setWorksOnAltitude(boolean worksOnAltitude) {
        this.worksOnAltitude = worksOnAltitude;
    }
    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }
    @Override
    public String toString() {
        return "ElectricService{" + "idElectricService=" + idElectricService + ", area=" + area + ", worksOnAltitude=" + worksOnAltitude + '}';
    }
}
