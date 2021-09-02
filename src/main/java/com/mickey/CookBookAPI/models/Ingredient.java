package com.mickey.CookBookAPI.models;





public class Ingredient {

    private Double amount;


    private String unit;

    private String description;

    private String category;
    public Ingredient(){

    }

    public Ingredient(Double amount, String unit, String description, String category) {
        this.amount = amount;
        this.unit = unit;
        this.description = description;
        this.category = category;

    }


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Ingredient{" +
                " amount=" + amount +
                ", unit='" + unit + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

