package com.mickey.CookBook.controllers;


import com.mickey.CookBook.models.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"","/","/home"})
    public String getHomePage(ModelMap model){
        Recipe recipe = new Recipe("Spaghetti", "John", "Bake that shit", "30 mins", "350 F", "Easy");
        model.addAttribute("recipe",recipe);
        return "index";
    }
}
