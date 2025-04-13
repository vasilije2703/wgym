package com.example.demo.controllers;

import com.example.demo.models.Gym;
import com.example.demo.services.GymService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gyms")
public class GymController {
    private GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    //GET ALL
    @GetMapping
    public List<Gym> getAllGyms(){
        List<Gym> result = this.gymService.getAllGyms();
        return result;
    }

    //GET BY pib
    @GetMapping(value = "/{pib}")
    public Gym getGymById(@PathVariable("pib") int pib){
        Gym result = this.gymService.getGymByPib(pib);
        return result;
    }

    //INSERT
    @PostMapping
    public int insertGym(@RequestBody Gym gym){
        int result = this.gymService.insertGym(gym);
        return result;
    }

    //UPDATE
    @PutMapping(value = "/{pib}")
    public int updateGym(@PathVariable("pib") int pib, @RequestBody Gym gym){
        int result = this.gymService.updateGym(pib, gym);
        return result;
    }

    //DELETE
    @DeleteMapping(value = "/{pib}")
    public int deleteGym(@PathVariable("pib") int pib){
        int result = this.gymService.deleteGym(pib);
        return result;
    }
}
