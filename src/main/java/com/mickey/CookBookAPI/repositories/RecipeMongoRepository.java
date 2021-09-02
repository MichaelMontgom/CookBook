package com.mickey.CookBookAPI.repositories;

import com.mickey.CookBookAPI.models.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeMongoRepository extends MongoRepository<Recipe, String> {
}
