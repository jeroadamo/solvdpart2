package com.solvd.entities;

public class FoodAndDrinkStand {
    private int idFoodDrinksStand;
    private int amountOf;
    private Area area;
    public FoodAndDrinkStand(int idFood_drinks_stand, int amountOf, Area area) {
        idFoodDrinksStand = idFood_drinks_stand;
        this.amountOf = amountOf;
        this.area = area;
    }
    public int getIdFoodDrinksStand() {
        return idFoodDrinksStand;
    }
    public void setIdFoodDrinksStand(int idFoodDrinksStand) {
        this.idFoodDrinksStand = idFoodDrinksStand;
    }
    public int getAmountOf() {
        return amountOf;
    }
    public void setAmountOf(int amountOf) {
        this.amountOf = amountOf;
    }
    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }
}
