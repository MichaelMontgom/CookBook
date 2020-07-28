package com.mickey.CookBook.models;

import java.util.List;

public class Recipe {

    private String name;
    private String author;
    private String instructions;
    private List<Ingredient> ingredientList;
    private String cookTime;
    private String cookTemp;
    private String difficulty;

    public Recipe(String name, String author, String instructions, List<Ingredient> ingredientList, String cookTime, String cookTemp, String difficulty) {
        this.name = name;
        this.author = author;
        this.instructions = instructions;
        this.ingredientList = ingredientList;
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

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

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
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", instructions='" + instructions + '\'' +
                ", ingredientList=" + ingredientList +
                ", cookTime='" + cookTime + '\'' +
                ", cookTemp='" + cookTemp + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
