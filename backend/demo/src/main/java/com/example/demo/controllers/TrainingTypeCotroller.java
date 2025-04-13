package com.example.demo.controllers;

import com.example.demo.models.TrainingType;
import com.example.demo.services.TrainingTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training_types")
public class TrainingTypeCotroller {
    private TrainingTypeService trainingTypeService;

    public TrainingTypeCotroller(TrainingTypeService trainingTypeService) {
        this.trainingTypeService = trainingTypeService;
    }

    //GET ALL
    @GetMapping
    public List<TrainingType> getAllTrainingTypes(){
        List<TrainingType> result = this.trainingTypeService.getAllTrainingTypes();
        return result;
    }

    //GET BY ID
    @GetMapping(value = "/{id}")
    public TrainingType getTrainingTypeById(@PathVariable("id") int id){
        TrainingType result = this.trainingTypeService.getTrainingTypeById(id);
        return result;
    }

    //INSERT
    @PostMapping()
    public int insertTrainingType(@RequestBody TrainingType trainingType){
        int result = this.trainingTypeService.insertTrainingType(trainingType);
        return result;
    }

    //UPDATE
    @PutMapping(value = "/{id}")
    public int updateTrainingType(@PathVariable("id") int id, @RequestBody TrainingType trainingType){
        int result = this.trainingTypeService.updateTrainingType(id, trainingType);
        return result;
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public int deleteTrainingType(@PathVariable("id") int id){
        int result = this.trainingTypeService.deleteTrainingType(id);
        return result;
    }
}
