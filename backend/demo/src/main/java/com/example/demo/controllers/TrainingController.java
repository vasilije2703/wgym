package com.example.demo.controllers;

import com.example.demo.models.Training;
import com.example.demo.services.TrainingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainings")
public class TrainingController {
    private TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    //GET ALL
    @GetMapping
    public List<Training> getAllTrainings(){
        List<Training> result = this.trainingService.getAllTrainings();
        return result;
    }

    //GET BY ID
    @GetMapping(value = "/{id}")
    public Training getTrainingById(@PathVariable("id") int id){
        Training result = this.trainingService.getTrainingById(id);
        return result;
    }

    //INSERT
    @PostMapping
    public int insertTraining(@RequestBody Training training){
        int result = this.trainingService.insertTraining(training);
        return result;
    }

    //UPDATE
    @PutMapping(value = "/{id}")
    public int updateTraining(@PathVariable("id") int id, @RequestBody Training training){
        int result = this.trainingService.updateTraining(id, training);
        return result;
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public int deleteTraining(@PathVariable("id") int id){
        int result = this.trainingService.deleteTraining(id);
        return result;
    }
}
