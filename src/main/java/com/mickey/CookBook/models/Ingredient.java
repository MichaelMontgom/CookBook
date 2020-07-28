package com.mickey.CookBook.models;

import javax.persistence.*;


@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double amount;
    private String unit;
    private String description;
    private String category;

    @ManyToOne
    private Recipe recipe;

    public Ingredient(){

    }

    public Ingredient(Double amount, String unit, String description, String category, Recipe recipe) {
        this.amount = amount;
        this.unit = unit;
        this.description = description;
        this.category = category;
        this.recipe = recipe;
    }


}
