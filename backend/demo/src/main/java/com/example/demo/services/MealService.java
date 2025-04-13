package com.example.demo.services;

import com.example.demo.models.Meal;
import com.example.demo.repositories.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    //GET ALL
    public List<Meal> getAllMeals(){
        List<Meal> result = this.mealRepository.getAllMeals();
        return result;
    }

    //GET BY ID
    public Meal getMealById(int id){
        Meal result = this.mealRepository.getMealById(id);
        return result;
    }

    //INSERT
    public int insertMeal(Meal meal){
        int result = this.mealRepository.insertMeal(meal);
        return result;
    }

    //UPDATE
    public int updateMeal(int id, Meal meal){
        int result = this.mealRepository.updateMeal(id, meal);
        return result;
    }

    //DELETE
    public int deleteMeal(int id){
        int result = this.mealRepository.deleteMeal(id);
        return result;
    }
}
