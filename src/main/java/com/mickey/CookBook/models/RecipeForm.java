package com.mickey.CookBook.models;


import java.util.HashSet;
import java.util.Set;

public class RecipeForm {

    private Long id;

    private String name;

    private String author;

    private String instructions;




    private String cookTime;

    private String cookTemp;

    private String difficulty;


    private byte[] picture;



    private Set<Ingredient> ingredients = new HashSet<>();



    public RecipeForm(){

    }


    public RecipeForm(String name, String author,  String instructions,  String cookTime, String cookTemp, String difficulty) {
        this.name = name;
        this.author = author;
        this.instructions = instructions;
        this.cookTime = cookTime;
        this.cookTemp = cookTemp;
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
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
        return "RecipeForm{" +
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
