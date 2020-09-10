package com.mickey.CookBook.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class GroceryList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Date dateCreated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groceryList")
    private Set<Ingredient> ingredients = new HashSet<>();



    public GroceryList(){

    }
    public GroceryList(String name, Date dateCreated) {
        this.name = name;
        this.dateCreated = dateCreated;
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
//                ", ingredients=" + ingredients +
                '}';
    }
}
