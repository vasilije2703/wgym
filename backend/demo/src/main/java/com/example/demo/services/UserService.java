package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //GET ALL
    public List<User> getAllUsers(){
        List<User> result = this.userRepository.getAllUsers();
        return result;
    }

    //GET BY ID
    public User getUserById(int id){
        User result = this.userRepository.getUserById(id);
        return result;
    }

    //INSERT
    public int insertUser(User user){
        int result = this.userRepository.insertUser(user);
        return result;
    }

    //UPDATE
    public int updateUser(int id, User user){
        int result = this.userRepository.updateUser(id, user);
        return result;
    }

    //DELETE
    public int deleteUser(int id){
        int result = this.userRepository.deleteUser(id);
        return result;
    }
}
