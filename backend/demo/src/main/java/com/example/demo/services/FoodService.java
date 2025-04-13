package com.example.demo.services;

import com.example.demo.models.Food;
import com.example.demo.repositories.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    private FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    //GET ALL
    public List<Food> getAllFood(){
        List<Food> result = this.foodRepository.getAllFood();
        return result;
    }

    //GET BY ID
    public Food getFoodById(int id){
        Food result = this.foodRepository.getFoodById(id);
        return result;
    }

    //INSERT
    public int insertFood(Food food){
        int result = this.foodRepository.insertFood(food);
        return result;
    }

    //UPDATE
    public int updateFood(int id, Food food){
        int result = this.foodRepository.updateFood(id, food);
        return result;
    }

    //DELETE
    public int deleteFood(int id){
        int result = this.foodRepository.deleteFood(id);
        return result;
    }
}
