package com.example.demo.controllers;

import com.example.demo.models.Meal;
import com.example.demo.services.MealService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {
    private MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    //GET ALL
    @GetMapping
    public List<Meal> getAllMeals(){
        List<Meal> result = this.mealService.getAllMeals();
        return result;
    }

    //GET BY ID
    @GetMapping(value = "/{id}")
    public Meal getMealById(@PathVariable("id") int id){
        Meal result = this.mealService.getMealById(id);
        return result;
    }

    //INSERT
    @PostMapping
    public int insertMeal(@RequestBody Meal meal){
        int result = this.mealService.insertMeal(meal);
        return result;
    }

    //UPDATE
    @PutMapping(value = "/{id}")
    public int updateMeal(@PathVariable("id") int id, @RequestBody Meal meal){
        int result = this.mealService.updateMeal(id, meal);
        return result;
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public int deleteMeal(@PathVariable("id") int id){
        int result = this.mealService.deleteMeal(id);
        return result;
    }
}
