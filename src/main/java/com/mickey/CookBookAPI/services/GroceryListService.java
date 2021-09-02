package com.mickey.CookBookAPI.services;

import com.mickey.CookBookAPI.models.GroceryList;
import com.mickey.CookBookAPI.repositories.GroceryListMongoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryListService {

    private static final Logger logger = LoggerFactory.getLogger(GroceryListService.class);

    @Autowired
    private GroceryListMongoRepository groceryListMongoRepository;



    public List<GroceryList> findAll(){
        return groceryListMongoRepository.findAll();
    }

    public Optional<GroceryList> findById(String id){
        return groceryListMongoRepository.findById(id);
    }

    public Long count(){
        return groceryListMongoRepository.count();
    }

    public boolean addGroceryList(GroceryList groceryList){
        try{
            groceryListMongoRepository.save(groceryList);
            return true;
        } catch (Exception e){
            logger.info(e.toString());
            return false;
        }
    }

    public boolean deleteGroceryList(GroceryList groceryList){
        try{
            groceryListMongoRepository.delete(groceryList);
            return true;
        }catch (Exception e){
            logger.info(e.toString());
            return false;
        }
    }

    public boolean updateGroceryList(GroceryList groceryList){
        try{
            groceryListMongoRepository.save(groceryList);
            return true;
        } catch (Exception e){
            logger.info(e.toString());
            return false;
        }
    }



}
