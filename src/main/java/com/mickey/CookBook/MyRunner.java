package com.mickey.CookBook;

import com.mickey.CookBook.models.GroceryList;
import com.mickey.CookBook.models.Ingredient;
import com.mickey.CookBook.models.Recipe;
import com.mickey.CookBook.repository.GroceryListRepository;
import com.mickey.CookBook.repository.IngredientRepository;
import com.mickey.CookBook.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private GroceryListRepository groceryListRepository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        logger.info("initializing recipes");

        var r1 = new Recipe("Spaghetti", "John","Bake that shit", "30 mins", "350 F", "Easy");
        recipeRepository.save(r1);
        logger.info(r1.toString());

        var r2 = new Recipe("Baked Chicken", "Mary","Bake that shit", "40 mins", "350 F", "Hard");
        recipeRepository.save(r2);




        var i1 = new Ingredient(5.0, "oz", "sauce", "canned", r1);
        ingredientRepository.save(i1);
        logger.info(i1.toString());

        var i2 = new Ingredient(1.0, "box", "noodles", "pasta", r1);
        ingredientRepository.save(i2);

        var i3 = new Ingredient(5.0, "lbs", "skinless chicken breast", "meat", r2);
        ingredientRepository.save(i3);

        var i4 = new Ingredient(1.0, "stick", "butter", "dairy", r2);
        ingredientRepository.save(i4);

        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(i1);
        ingredients.add(i2);
        ingredients.add(i3);

        logger.info(ingredients.toString());

        var g1 = new GroceryList("name", new Date());
        i1.setGroceryList(g1);
        i2.setGroceryList(g1);

        logger.info(g1.toString());
        groceryListRepository.save(g1);

//        var g2 = new GroceryList("Lowes", new Date(), ingredients);
//        logger.info(g2.toString());
//        groceryListRepository.save(g2);
//
//        var g3 = new GroceryList("Home Depot", new Date(), ingredients);
//        logger.info(g3.toString());
//        groceryListRepository.save(g3);





    }
}
