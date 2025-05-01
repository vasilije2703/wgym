package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private  UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
        String password = user.getPassword_hash();
        String hashed_password = passwordEncoder.encode(password);
        user.setPassword_hash(hashed_password);

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

    //LOGIN
    public  Optional<User> login(String email, String password){
        Optional<User> userOpt = this.userRepository.findByEmail(email);
        if(userOpt.isPresent()) {
            User user = userOpt.get();
            if (this.passwordEncoder.matches(password, user.getPassword_hash())) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }
}
