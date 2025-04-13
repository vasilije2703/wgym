package com.example.demo.services;

import com.example.demo.models.Gym;
import com.example.demo.repositories.GymRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {
    private GymRepository gymRepository;

    public GymService(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    //GET ALL
    public List<Gym> getAllGyms(){
        List<Gym> result = this.gymRepository.getAllGyms();
        return result;
    }

    //GET BY pib
    public Gym getGymByPib(int pib){
        Gym result = this.gymRepository.getGymByPib(pib);
        return result;
    }

    //INSERT
    public int insertGym(Gym gym){
        int result = this.gymRepository.insertGym(gym);
        return result;
    }

    //UPDATE
    public int updateGym(int pib, Gym gym){
        int result = this.gymRepository.updateGym(pib, gym);
        return result;
    }

    //DELETE
    public int deleteGym(int pib){
        int result = this.gymRepository.deleteGym(pib);
        return result;
    }
}
