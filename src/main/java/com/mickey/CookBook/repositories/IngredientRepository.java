package com.mickey.CookBook.repositories;

import com.mickey.CookBook.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
