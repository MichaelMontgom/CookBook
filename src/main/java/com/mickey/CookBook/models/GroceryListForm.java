package com.mickey.CookBook.models;

import java.util.Date;
import java.util.List;

public class GroceryListForm {


    private Long id;
    private String name;
    private Date dateCreated;
    private List<Ingredient> ingredients;

    public GroceryListForm(){

    }
    public GroceryListForm(Long id){
        this.id = id;
    }

    public GroceryListForm(Long id, String name, Date dateCreated, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
