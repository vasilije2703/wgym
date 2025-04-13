package com.example.demo.services;

import com.example.demo.models.Training;
import com.example.demo.repositories.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {
   private TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    //GET ALL
    public List<Training> getAllTrainings(){
        List<Training> result = this.trainingRepository.getAllTrainings();
        return result;
    }

    //GET BY ID
    public Training getTrainingById(int id){
        Training result = this.trainingRepository.getTrainingById(id);
        return result;
    }

    //INSERT
    public int insertTraining(Training training){
        int result = this.trainingRepository.insertTraining(training);
        return result;
    }

    //UPDATE
    public int updateTraining(int id, Training training){
        int result = this.trainingRepository.updateTraining(id, training);
        return result;
    }

    //DELETE
    public int deleteTraining(int id){
        int result = this.trainingRepository.deleteTraining(id);
        return result;
    }

}
