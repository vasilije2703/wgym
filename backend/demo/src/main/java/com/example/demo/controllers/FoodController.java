package com.example.demo.controllers;

import com.example.demo.models.Food;
import com.example.demo.services.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {
    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    //GET ALL
    @GetMapping
    public List<Food> getAllFood(){
        List<Food> result = this.foodService.getAllFood();
        return result;
    }

    //GET BY ID
    @GetMapping(value = "/{id}")
    public Food getFoodById(@PathVariable("id") int id){
        Food result = this.foodService.getFoodById(id);
        return result;
    }

    //INSERT
    @PostMapping
    public int insertFood(@RequestBody Food food){
        int result = this.foodService.insertFood(food);
        return result;
    }

    //UPDATE
    @PutMapping(value = "/{id}")
    public int updateFood(@PathVariable("id") int id, @RequestBody Food food){
        int result = this.foodService.updateFood(id, food);
        return result;
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public int deleteFood(@PathVariable("id") int id){
        int result = this.foodService.deleteFood(id);
        return result;
    }
}
