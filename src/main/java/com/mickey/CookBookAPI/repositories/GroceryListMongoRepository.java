package com.mickey.CookBookAPI.repositories;

import com.mickey.CookBookAPI.models.GroceryList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroceryListMongoRepository extends MongoRepository<GroceryList, String> {
}
