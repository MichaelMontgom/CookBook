package com.mickey.CookBook.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;


@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String author;
    private String instructions;
//    private Set<Ingredient> ingredients;
    private String cookTime;
    private String cookTemp;
    private String difficulty;

    public Recipe(){

    }


    public Recipe(String name, String author, String instructions, Set<Ingredient> ingredients, String cookTime, String cookTemp, String difficulty) {
        this.name = name;
        this.author = author;
        this.instructions = instructions;
//        this.ingredients = ingredients;
        this.cookTime = cookTime;
        this.cookTemp = cookTemp;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

//    public Set<Ingredient> getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(Set<Ingredient> ingredients) {
//        this.ingredients = ingredients;
//    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public String getCookTemp() {
        return cookTemp;
    }

    public void setCookTemp(String cookTemp) {
        this.cookTemp = cookTemp;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", instructions='" + instructions + '\'' +
//                ", ingredients=" + ingredients +
                ", cookTime='" + cookTime + '\'' +
                ", cookTemp='" + cookTemp + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
