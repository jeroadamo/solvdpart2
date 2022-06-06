package com.solvd.entities;
public class Toilet {
    private int idToilets;
    private Area area;
    private boolean usable;
    public Toilet(int idToilets, Area area, boolean usable) {
        this.idToilets = idToilets;
        this.area = area;
        this.usable = usable;
    }
    public Toilet(){}
    public int getIdToilets() {
        return idToilets;
    }
    public void setIdToilets(int idToilets) {
        this.idToilets = idToilets;
    }
    public boolean isUsable() {
        return usable;
    }
    public void setUsable(boolean usable) {
        this.usable = usable;
    }
    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }
    @Override
    public String toString() {
        return "Toilet{" + "idToilets=" + idToilets + ", area=" + area + ", usable=" + usable + '}';
    }
}
