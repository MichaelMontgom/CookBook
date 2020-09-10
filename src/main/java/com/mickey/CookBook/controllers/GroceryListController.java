package com.mickey.CookBook.controllers;

import com.mickey.CookBook.models.GroceryList;
import com.mickey.CookBook.models.GroceryListForm;
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
public class GroceryListController {

    private static final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private GroceryListService groceryListService;


    @GetMapping("/create/GroceryList")
    private String createGroceryList(Model model){
        GroceryList groceryList = new GroceryList();
        model.addAttribute("groceryList", groceryList);

        return "createRecipe";
    }

    @PostMapping("/grocery-list/add")
    private String addToGroceryList(Model model, @RequestParam("recipeId") Long id, @ModelAttribute GroceryListForm groceryListForm){


//        Optional<Recipe> recipe = recipeService.findById(id);
//
//        Optional<GroceryList> g = groceryListService.findById(groceryListForm.getId());
//
//        if(recipe.isPresent()){
//            if(g.isPresent()){
//                GroceryList gL = g.get();
//                Recipe r = recipe.get();
////
////                gL.addIngredients(recipeService.getIngredients(r.getId()));
////                groceryListService.saveGroceryList(gL);
//
//
//
//            }
//
//
//        }
        model.addAttribute("recipes", recipeService.findAll());
        return "recipes";
    }

    @GetMapping("/grocery-lists")
    private String getGroceryLists(Model model){

        model.addAttribute("groceryLists", groceryListService.findAll());

        return "groceryList/groceryLists";
    }

    @GetMapping("/grocery-list/{id}")
    private String getGroceryList(Model model, @PathVariable String id){
        Long GLID = Long.parseLong(id);
        Optional<GroceryList> gl = groceryListService.findById(GLID);

        if(gl.isPresent()){
            model.addAttribute("groceryList", gl.get());
            logger.info(gl.get().toString());
            model.addAttribute("ingredients", groceryListService.getIngredients(gl.get().getId()));
        }
        return "groceryList/view";
    }


}
