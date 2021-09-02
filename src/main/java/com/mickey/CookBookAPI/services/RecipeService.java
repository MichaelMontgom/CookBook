package com.mickey.CookBookAPI.services;

import com.mickey.CookBookAPI.models.Recipe;
import com.mickey.CookBookAPI.repositories.RecipeMongoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private static final Logger logger = LoggerFactory.getLogger(RecipeService.class);

    @Autowired
    private RecipeMongoRepository recipeMongoRepository;

    public List<Recipe> findAll(){
        return recipeMongoRepository.findAll();
    }

    public Optional<Recipe> findById(String id){
        Optional<Recipe> r = recipeMongoRepository.findById(id);
        return r;
    }
    public Long count(){
        return recipeMongoRepository.count();
    }

    public boolean addRecipe(Recipe recipe){
        try{
            recipeMongoRepository.save(recipe);
            return true;
        }catch (Exception e){
            logger.info(e.toString());
            return false;
        }
    }

    public boolean deleteRecipe(Recipe recipe){
        try{
            recipeMongoRepository.delete(recipe);
            return true;
        }catch (Exception e){
            logger.info(e.toString());
            return false;
        }
    }

    public boolean updateRecipe(Recipe recipe){
        try{
            recipeMongoRepository.save(recipe);
            return true;
        }catch (Exception e){
            logger.info(e.toString());
            return false;
        }

    }

}
