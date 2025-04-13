package com.example.demo.services;

import com.example.demo.models.TrainingType;
import com.example.demo.repositories.TrainingTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingTypeService {
    private TrainingTypeRepository trainingTypeRepository;

    public TrainingTypeService(TrainingTypeRepository trainingTypeRepository) {
        this.trainingTypeRepository = trainingTypeRepository;
    }

    //GET ALL
    public List<TrainingType> getAllTrainingTypes(){
        List<TrainingType> result = this.trainingTypeRepository.getAllTrainingTypes();
        return result;
    }

    //GET BY ID
    public TrainingType getTrainingTypeById(int id){
        TrainingType result = this.trainingTypeRepository.getTrainingTypeById(id);
        return  result;
    }

    //INSERT
    public int insertTrainingType(TrainingType trainingType){
        int result = this.trainingTypeRepository.insertTrainingType(trainingType);
        return result;
    }

    //UPDATE
    public int updateTrainingType(int id, TrainingType trainingType){
        int result = this.trainingTypeRepository.updateTrainingType(id, trainingType);
        return result;
    }

    //DELETE
    public int deleteTrainingType(int id){
        int result = this.trainingTypeRepository.deleteTrainingType(id);
        return result;
    }
}
