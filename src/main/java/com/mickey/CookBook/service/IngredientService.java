package com.mickey.CookBook.service;


import com.mickey.CookBook.models.Ingredient;
import com.mickey.CookBook.models.Recipe;
import com.mickey.CookBook.repository.IngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class IngredientService {

    private static final Logger logger = LoggerFactory.getLogger(IngredientService.class);

    @Autowired
    private IngredientRepository ingredientRepository;

    public ArrayList<Ingredient> findAll(){
        var it = ingredientRepository.findAll();

        var ingredients = new ArrayList<Ingredient>();
        it.forEach(e -> ingredients.add(e));

        return ingredients;
    }

    public Optional<Ingredient> findById(Long id){
        Optional<Ingredient> i = ingredientRepository.findById(id);
        return i;
    }

    public Long count(){
        return ingredientRepository.count();
    }

    public void deleteById(Long recipeId){
        ingredientRepository.deleteById(recipeId);
    }

    public boolean addIngredient(Ingredient ingredient){
        try{
            ingredientRepository.save(ingredient);
            return true;
        }catch(Exception e){
            logger.info(e.toString());
            return false;
        }



    }

    public void saveIngredient(Ingredient ingredient){
        ingredientRepository.save(ingredient);
    }
}
