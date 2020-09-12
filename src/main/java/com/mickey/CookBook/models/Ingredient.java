package com.mickey.CookBook.models;

import javax.persistence.*;


@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Double amount;

    @Column
    private String unit;

    @Column
    private String description;

    @Column
    private String category;

    @ManyToOne
    private Recipe recipe;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private GroceryList groceryList;

    public Ingredient(){

    }

    public Ingredient(Double amount, String unit, String description, String category, Recipe recipe) {
        this.amount = amount;
        this.unit = unit;
        this.description = description;
        this.category = category;
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public GroceryList getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", recipe=" + recipe +
                ", groceryList=" + groceryList +
                '}';
    }
}
