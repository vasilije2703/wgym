package com.example.demo.services;

import com.example.demo.dto.SignUpRequest;
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

    //SIGN IN
    public int signUp(SignUpRequest request) {
        if (request.uloga_id == null) {
            throw new IllegalArgumentException("Role ID is necessary");
        }

        if (request.ime == null || request.ime.isEmpty()) {
            throw new IllegalArgumentException("Name is necessary");
        }

        if (request.prezime == null || request.prezime.isEmpty()) {
            throw new IllegalArgumentException("Surname is necessary");
        }

        if (request.datum_rodjenja == null) {
            throw new IllegalArgumentException("Birthdate is necessary");
        }

        if (request.password == null || request.password.isEmpty()) {
            throw new IllegalArgumentException("Password is necessary");
        }

        if (request.email == null || request.email.isEmpty()) {
            throw new IllegalArgumentException("Email is necessary");
        }

        if (request.uloga_id == 3) { // Clan
            if (request.visina == null || request.tezina == null || request.email == null || request.email.isEmpty() || request.teretana_pib == null) {
                throw new IllegalArgumentException("For member, all data is necessary");
            }
        }

        if (userRepository.findByEmail(request.email).isPresent()) {
            throw new IllegalArgumentException("User with this email already exists");
        }


        User user = new User();
        user.setIme(request.ime);
        user.setPrezime(request.prezime);
        user.setEmail(request.email);
        user.setPassword_hash(passwordEncoder.encode(request.password));
        user.setVisina(request.visina);
        user.setTezina(request.tezina);
        user.setDatum_rodjenja(request.datum_rodjenja);
        user.setUloga_id(request.uloga_id);
        user.setTeretana_pib(request.teretana_pib);

        return this.userRepository.insertUser(user);
    }

}
