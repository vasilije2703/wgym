package com.example.demo.controllers;

import com.example.demo.dto.LogInRequest;
import com.example.demo.dto.LogInResponse;
import com.example.demo.dto.SignUpRequest;
import com.example.demo.models.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.services.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    private JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    //GET ALL
    @GetMapping
    public List<User> getAllUsers(){
        List<User> result = this.userService.getAllUsers();
        return result;
    }

    //LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LogInRequest logInRequest){
        Optional<User> result = this.userService.login(logInRequest.getEmail(), logInRequest.getPassword());
        if(result.isPresent()){
            String token = this.jwtUtil.generateToken(result.get().getEmail(), result.get().getUloga_id());
            LogInResponse logInResponse = new LogInResponse(token, "You logged in successfully");
            return ResponseEntity.ok(logInResponse);
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong email or password!");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest request) {
        try {
            int result = userService.signUp(request);
            if (result == 1) {
                return ResponseEntity.status(HttpStatus.CREATED).body("User signed up successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user due to a server error.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
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
