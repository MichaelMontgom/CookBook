package com.mickey.CookBook.controllers;


import com.mickey.CookBook.models.GroceryList;
import com.mickey.CookBook.models.GroceryListForm;
import com.mickey.CookBook.models.Ingredient;
import com.mickey.CookBook.models.Recipe;
import com.mickey.CookBook.service.GroceryListService;
import com.mickey.CookBook.service.IngredientService;
import com.mickey.CookBook.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class RecipeController {

    private static final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private GroceryListService groceryListService;

    @GetMapping("/")
    private String getHome(Model model){
        return "home";
    }

    @GetMapping("/recipes")
    private String getAllRecipes(Model model){

        model.addAttribute("recipes", recipeService.findAll());


        return "recipes";
    }

    @GetMapping("/recipes/edit/{id}")
    private String editRecipe(Model model, @PathVariable String id){

        Long recipeId = Long.parseLong(id);
        Optional<Recipe> recipe = recipeService.findById(recipeId);

        if(recipe.isPresent()){
            Recipe r = recipe.get();
            logger.info(r.toString());
            model.addAttribute("recipe", r);
            model.addAttribute("id", r.getId());
        }

        return "edit";
    }

    @PostMapping("/recipes/edit")
    private String submitEditRecipe(Model model,  @ModelAttribute Recipe recipe, @RequestParam("recipeId") Long id){

        logger.info(recipe.toString());
        logger.info(id.toString());

        Optional<Recipe> recipe2 = recipeService.findById(id);

        if(recipe2.isPresent()){
            Recipe r = recipe2.get();

            r.setAuthor(recipe.getAuthor());
            r.setName(recipe.getName());
            r.setInstructions(recipe.getInstructions());
            r.setCookTemp(recipe.getCookTemp());
            r.setCookTime(recipe.getCookTime());
            r.setDifficulty(recipe.getDifficulty());

            recipeService.saveRecipe(r);
        }

        model.addAttribute("recipes", recipeService.findAll());

        return "recipes";
    }

    @GetMapping("/create/recipe")
    private String createRecipe(Model model){
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        Ingredient ingredient = new Ingredient();
        model.addAttribute("ingredient",ingredient);

        return "createRecipe";
    }

    @PostMapping("/create/recipe")
    private String recipeSubmit(@ModelAttribute Recipe recipe, Model model){
        Recipe r = new Recipe();
        r  = recipe;
        recipeService.addRecipe(r);
        model.addAttribute("recipe", r);
        Long id = r.getId();
        model.addAttribute("recipe", recipe);
        model.addAttribute("recipes", recipeService.findAll());
        return "recipes";

    }


    @GetMapping("/recipes/delete/{id}")
    private String deleteRecipe(Model model, @PathVariable String id){
        Long recipeId = Long.parseLong(id);



        return "delete";
    }


    @GetMapping("/view/{id}")
    private String viewRecipe(@PathVariable String id, Model model){
        Long recipeId = Long.parseLong(id);
        Optional<Recipe> recipe = recipeService.findById(recipeId);

        if(recipe.isPresent()){
            Recipe r = recipe.get();
            logger.info(r.toString());
            model.addAttribute("recipe", r);
            logger.info(recipeService.getIngredients(recipeId).toString());
            model.addAttribute("ingredients", recipeService.getIngredients(recipeId));
        }
        else{
            logger.info("recipe not found");
        }
        GroceryListForm gf = new GroceryListForm();
        model.addAttribute("groceryListForm", gf);
        model.addAttribute("groceryLists", groceryListService.findAll() );



        return "view";
    }



}
