package com.mickey.CookBookAPI.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import java.util.*;

@Document(collection = "grocerylists")
public class GroceryList {


    @Id
    private String id;
    private String name;
    private Date dateCreated;
    private Set<Ingredient> ingredients = new HashSet<>();



    public GroceryList(){

    }
    public GroceryList(String name, Date dateCreated) {
        this.name = name;
        this.dateCreated = dateCreated;
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "GroceryList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
