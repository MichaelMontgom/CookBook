package com.mickey.CookBook.service;


import com.mickey.CookBook.models.Ingredient;
import com.mickey.CookBook.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

//    public List<Ingredient> findAll(){
//        var it = ingredientRepository.findAll();
//
//    }
}
