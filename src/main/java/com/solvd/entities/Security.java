package com.solvd.entities;

public class Security {
    private int idSecurity;
    private Area area;
    private String tool;
    public Security(int idSecurity, String tool, Area area) {
        this.idSecurity = idSecurity;
        this.tool = tool;
        this.area = area;
    }
    public int getIdSecurity() {
        return idSecurity;
    }
    public void setIdSecurity(int idSecurity) {
        this.idSecurity = idSecurity;
    }
    public String getTool() {
        return tool;
    }
    public void setTool(String tool) {
        this.tool = tool;
    }
    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }
}
