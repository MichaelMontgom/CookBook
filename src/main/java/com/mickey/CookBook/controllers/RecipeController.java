package com.mickey.CookBook.controllers;


import com.mickey.CookBook.service.IngredientService;
import com.mickey.CookBook.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {

    private static final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/recipes")
    private String getAllRecipes(Model model){

        model.addAttribute("recipes", recipeService.findAll());
        model.addAttribute("ingredients", recipeService.getIngredients((long) 1));

        return "index";
    }



}
