package com.mickey.CookBook.repository;

import com.mickey.CookBook.models.GroceryList;
import com.mickey.CookBook.models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryListRepository extends CrudRepository<GroceryList, Long> {


}