package com.mickey.CookBook.repository;

import com.mickey.CookBook.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
