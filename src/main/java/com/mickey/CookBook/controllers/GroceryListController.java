package com.mickey.CookBook.controllers;

import com.mickey.CookBook.models.*;
import com.mickey.CookBook.service.GroceryListService;
import com.mickey.CookBook.service.IngredientService;
import com.mickey.CookBook.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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


    @GetMapping("/grocery-list/create")
    private String createGroceryList(Model model){
        GroceryListForm groceryListForm = new GroceryListForm();
        model.addAttribute("groceryListForm", groceryListForm);

        return "groceryList/create";
    }

    @PostMapping("/grocery-list/create")
    private String submitGroceryList(Model model, @ModelAttribute GroceryListForm groceryListForm){
        logger.info(groceryListForm.toString());

        GroceryList gl = new GroceryList();
        gl.setDateCreated(new Date());
        gl.setName(groceryListForm.getName());

        groceryListService.saveGroceryList(gl);


        model.addAttribute("groceryLists", groceryListService.findAll());
        return "groceryList/groceryLists";
    }

    @PostMapping("/grocery-list/add")
    private String addToGroceryList(Model model, @RequestParam("recipeId") Long id, @ModelAttribute GroceryListForm groceryListForm){


            Optional<Recipe> recipe = recipeService.findById(id);

            Optional<GroceryList> g = groceryListService.findById(groceryListForm.getId());

            if(recipe.isPresent()){
                if(g.isPresent()){
                    GroceryList gL = g.get();
                    Recipe r = recipe.get();

                    groceryListService.setIngredients(r, gL.getId());
                    logger.info(gL.toString());
                }
            }
            model.addAttribute("recipes", recipeService.findAll());



        return "recipes";
    }

    @GetMapping("/grocery-list/all")
    private String getGroceryLists(Model model){
        try{
            model.addAttribute("groceryLists", groceryListService.findAll());
        }
        catch (Exception e){
            logger.info(e.toString());
        }


        return "groceryList/groceryLists";
    }

    @GetMapping("/grocery-list/{id}")
    private String getGroceryList(Model model, @PathVariable String id){


            Long GLID = Long.parseLong(id);
            Optional<GroceryList> gl = groceryListService.findById(GLID);
            if(gl.isPresent()){
                model.addAttribute("groceryList", gl.get());
                logger.info(groceryListService.getIngredients(GLID).toString());
                model.addAttribute("ingredients", groceryListService.getIngredients(GLID));
            }



        return "groceryList/view";
    }


    @GetMapping("/grocery-list/delete/{id}")
    private String deleteGroceryList(Model model, @PathVariable String id){

        Long GLID = Long.parseLong(id);


        Optional<GroceryList> gl = groceryListService.findById(GLID);

        if(gl.isPresent()){
            model.addAttribute("groceryList", gl.get());
            model.addAttribute("ingredients", groceryListService.getIngredients(GLID));
            model.addAttribute("groceryListForm", new GroceryListForm());

        }



        return "groceryList/delete";
    }

    @PostMapping("/grocery-list/delete/confirmation")
    private String deleteConfirmation(Model model, @ModelAttribute GroceryListForm groceryListForm, @RequestParam("groceryListId") Long id){

        groceryListService.deleteById(id);

        model.addAttribute("groceryLists", groceryListService.findAll());


        return "groceryList/groceryLists";
    }


    @GetMapping("/grocery-list/delete-ingredient/{grocery_id}/{ingredient_id}")
    private String deleteIngredient(@PathVariable String grocery_id, @PathVariable String ingredient_id, Model model){

        // TODO add way to delete ingredients off of grocery lists
        Long GLID = Long.parseLong(grocery_id);
        Long i_id = Long.parseLong(ingredient_id);

        Optional<GroceryList> gl = groceryListService.findById(GLID);
        Optional<Ingredient> i = ingredientService.findById(i_id);
        if(gl.isPresent()){
            if(i.isPresent()){
                i.get().setGroceryList(null);
                ingredientService.saveIngredient(i.get());

            }
        }

        model.addAttribute("groceryList", gl.get());
        model.addAttribute("ingredients", groceryListService.getIngredients(GLID));



        return "groceryList/view";
    }







}
