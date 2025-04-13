package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET ALL
    @GetMapping
    public List<User> getAllUsers(){
        List<User> result = this.userService.getAllUsers();
        return result;
    }

    //GET BY ID
    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable("id") int id){
        User result = this.userService.getUserById(id);
        return result;
    }

    //INSERT
    @PostMapping
    public int insertUser(@RequestBody User user){
        int result = this.userService.insertUser(user);
        return result;
    }

    //UPDATE
    @PutMapping(value = "/{id}")
    public int updateUser(@PathVariable("id") int id, @RequestBody User user){
        int result = this.userService.updateUser(id, user);
        return result;
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public int deleteUser(@PathVariable("id") int id){
        int result = this.userService.deleteUser(id);
        return result;
    }
}
