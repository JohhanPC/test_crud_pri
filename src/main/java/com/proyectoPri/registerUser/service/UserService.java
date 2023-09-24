package com.proyectoPri.registerUser.service;

import com.proyectoPri.registerUser.dtos.responses.SearchUserByEmail;
import com.proyectoPri.registerUser.entity.User;
import com.proyectoPri.registerUser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long userId){
        return userRepository.findById(userId);
    }

    public void saveOrUpdateUser(User user){
        userRepository.save(user);
    }

    public Optional<User> getUserByUsername(String name) {
        return userRepository.findByname(name);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<Object[]> findUserNameAndEmailByEmail(String email) {
        return userRepository.findNameAndEmailByEmail(email);
    }

    public Optional<SearchUserByEmail> findNameAndEmailKeyValue (String email) {
        return userRepository.findNameAndEmailKeyValue(email);
    }


}
