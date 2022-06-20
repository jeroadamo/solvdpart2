package com.solvd.entities;

public class Employee {
    private int idEmployee;
    private String name;
    private FoodAndDrinkStand foodAndDrinkStand;
    private Security security;
    private ElectricService electricService;

    public Employee(int idEmployee, String name, FoodAndDrinkStand foodAndDrinkStand, Security security, ElectricService electricService) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.foodAndDrinkStand = foodAndDrinkStand;
        this.security = security;
        this.electricService = electricService;
    }
    public int getIdEmployee() {
        return idEmployee;
    }
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public FoodAndDrinkStand getFoodAndDrinkStand() {
        return foodAndDrinkStand;
    }
    public void setFoodAndDrinkStand(FoodAndDrinkStand foodAndDrinkStand) {
        this.foodAndDrinkStand = foodAndDrinkStand;
    }
    public Security getSecurity() {
        return security;
    }
    public void setSecurity(Security security) {
        this.security = security;
    }
    public ElectricService getElectricService() {
        return electricService;
    }
    public void setElectricService(ElectricService electricService) {
        this.electricService = electricService;
    }
}