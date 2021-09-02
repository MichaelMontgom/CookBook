package com.mickey.CookBookAPI;

import com.mickey.CookBookAPI.models.Ingredient;
import com.mickey.CookBookAPI.models.Recipe;
import com.mickey.CookBookAPI.repositories.GroceryListMongoRepository;
import com.mickey.CookBookAPI.repositories.RecipeMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class CookBookApiApplication implements CommandLineRunner {

	@Autowired
	private RecipeMongoRepository recipeMongoRepository;
	@Autowired
	private GroceryListMongoRepository groceryListMongoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CookBookApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		ArrayList<Ingredient> ingredients = new ArrayList<>();
		ingredients.add(new Ingredient(5.0, "oz", "sauce", "canned"));


//		recipeMongoRepository.save(new Recipe("Spaghetti", "John","Bake that shit", "30 mins", "350 F", "Easy", ingredients));


		System.out.println();
		for(Recipe r : recipeMongoRepository.findAll()){
			System.out.println(r);
		}
	}



}
