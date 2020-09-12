package com.mickey.CookBook.service;

import com.mickey.CookBook.models.GroceryList;
import com.mickey.CookBook.models.Ingredient;
import com.mickey.CookBook.models.Recipe;
import com.mickey.CookBook.repository.GroceryListRepository;
import com.mickey.CookBook.repository.IngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroceryListService {

    private static final Logger logger = LoggerFactory.getLogger(GroceryListService.class);

    @Autowired
    private GroceryListRepository groceryListRepository;

    @Autowired
    private IngredientRepository ingredientRepository;



    public List<GroceryList> findAll(){
        var it = groceryListRepository.findAll();

        var list = new ArrayList<GroceryList>();
        it.forEach(e -> list.add(e));

        return list;
    }

    public Optional<GroceryList> findById(Long id){
        Optional<GroceryList> g = groceryListRepository.findById(id);
        return g;
    }

    public Long count(){
        return groceryListRepository.count();
    }

    public void deleteById(Long groceryId){
        groceryListRepository.deleteById(groceryId);
    }

    public List<Ingredient> getIngredients(Long groceryId){
        var it = ingredientRepository.findAll();

        var ingredients = new ArrayList<Ingredient>();

        for(Ingredient ingredient: it){
            if( ingredient.getGroceryList() != null && ingredient.getGroceryList().getId() == groceryId ){
                ingredients.add(ingredient);
            }
        }
        return ingredients;
    }

    public boolean addRecipe(GroceryList groceryList){
        try{
            groceryListRepository.save(groceryList);
            return true;
        }catch(Exception e){
            logger.info(e.toString());
            return false;
        }
    }


    public void saveGroceryList(GroceryList groceryList){
        groceryListRepository.save(groceryList);
    }

    public void setIngredients(Recipe recipe, Long GLID){
        var it = ingredientRepository.findAll();



        for(Ingredient ingredient: it){

            if(ingredient.getRecipe().getId() == recipe.getId()){


                ingredient.setGroceryList(groceryListRepository.findById(GLID).get());
                ingredientRepository.save(ingredient);


            }
        }






    }





}
