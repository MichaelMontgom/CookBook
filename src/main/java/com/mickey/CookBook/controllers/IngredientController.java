package com.mickey.CookBook.controllers;

import com.mickey.CookBook.models.Ingredient;
import com.mickey.CookBook.service.IngredientService;
import com.mickey.CookBook.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IngredientController {


    private static final Logger logger = LoggerFactory.getLogger(IngredientController.class);

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientService ingredientService;




    @GetMapping("/create/ingredients/{id}")
    private String createIngredients(Model model, @PathVariable String id){
        Long recipeId = Long.parseLong(id);

        Ingredient ingredient = new Ingredient();
        ingredient.setRecipe(recipeService.findById(recipeId).get());
        model.addAttribute("ingredient", ingredient);
        return "createIngredients";
    }

    @PostMapping("/create/ingredients")
    private String submitIngredient(@ModelAttribute Ingredient ingredient,  Model model){

        ingredientService.addIngredient(ingredient);

        Ingredient new_ingredient = new Ingredient();
        model.addAttribute("ingredient", new_ingredient);

        return "createIngredients";
    }

}
