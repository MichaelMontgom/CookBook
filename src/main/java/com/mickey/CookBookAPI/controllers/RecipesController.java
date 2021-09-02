package com.mickey.CookBookAPI.controllers;

import com.mickey.CookBookAPI.models.Recipe;
import com.mickey.CookBookAPI.services.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipesController {

    private static final Logger logger = LoggerFactory.getLogger(RecipesController.class);

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    private List<Recipe> all(){

        return recipeService.findAll();
    }

    @GetMapping("/recipes/{id}")
    private Optional<Recipe> getRecipeById(@PathVariable String id){
        return recipeService.findById(id);
    }


}
