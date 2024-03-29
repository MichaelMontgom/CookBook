package com.mickey.CookBook.models;

import com.mickey.CookBook.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private String instructions;

//    @Column
//    private String ingredients;


    @Column
    private String cookTime;
    @Column
    private String cookTemp;
    @Column
    private String difficulty;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] picture;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();



    public Recipe(){

    }


    public Recipe(String name, String author,  String instructions,  String cookTime, String cookTemp, String difficulty) {
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
