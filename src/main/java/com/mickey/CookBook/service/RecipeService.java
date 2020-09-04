package com.mickey.CookBook.service;

import com.mickey.CookBook.models.Ingredient;
import com.mickey.CookBook.models.Recipe;
import com.mickey.CookBook.repository.IngredientRepository;
import com.mickey.CookBook.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Recipe> findAll(){
        var it = recipeRepository.findAll();

        var recipes = new ArrayList<Recipe>();
        it.forEach(e -> recipes.add(e));

        return recipes;
    }

    public Optional<Recipe> findById(Long id){
        Optional<Recipe> r = recipeRepository.findById(id);
        return r;
    }

    public Long count(){
        return recipeRepository.count();
    }

    public void deleteById(Long recipeId){
        recipeRepository.deleteById(recipeId);
    }

    public List<Ingredient> getIngredients(Long recipeId){
        var it = ingredientRepository.findAll();

        var ingredients = new ArrayList<Ingredient>();

        for(Ingredient ingredient: it){
            if(ingredient.getRecipe().getId() == recipeId){
                ingredients.add(ingredient);
            }
        }

        return ingredients;
    }

}
