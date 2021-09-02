package com.mickey.CookBookAPI.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Document(collection = "recipes")
public class Recipe {


    @Id
    private String id;

    private String name;

    private String author;

    private String instructions;



    private String cookTime;

    private String cookTemp;

    private String difficulty;


    private int views = 0;


    private byte[] picture;

    private List<Ingredient> ingredients = new ArrayList<>();




    public Recipe(){

    }


    public Recipe(String name, String author,  String instructions,  String cookTime, String cookTemp, String difficulty, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.author = author;
        this.instructions = instructions;
        this.cookTime = cookTime;
        this.cookTemp = cookTemp;
        this.difficulty = difficulty;
        this.ingredients = ingredients;

    }

    public String getId() {
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

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
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
                ", ingredients=" + ingredients.toString() + '\'' +
                '}';
    }
}
