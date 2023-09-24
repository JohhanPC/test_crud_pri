package com.proyectoPri.registerUser.controller;

import com.proyectoPri.registerUser.dtos.responses.SearchUserByEmail;
import com.proyectoPri.registerUser.entity.User;
import com.proyectoPri.registerUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getUsers();
    }
    @PostMapping
    public void saveUpdate(@RequestBody User user){
        userService.saveOrUpdateUser(user);
    }

    @GetMapping("/id/{userId}")
    public Optional<User> getById(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
    }

    @GetMapping("/name")
    public Optional<User> getName(@RequestParam(value = "name") String name){
        return userService.getUserByUsername(name);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User>  getUserByEmail(@PathVariable String email){
        Optional<User> user = userService.getUserByEmail(email);

        if (user.isPresent()){
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   @GetMapping("/NameAndEmail/{email}")
   @ResponseBody
    public ResponseEntity<Object[]> getNameAndEmailByEmail(@PathVariable String email) {
        Optional<Object[]> result = userService.findUserNameAndEmailByEmail(email);

        if (result.isPresent()) {
            Object[] data = result.get();
            return ResponseEntity.ok(data);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/keyValue/{email}")
    public ResponseEntity<SearchUserByEmail> getUserByEmailKeyValue(@PathVariable String email){
        Optional<SearchUserByEmail> result = userService.findNameAndEmailKeyValue(email);

        if (result.isPresent()){
            return ResponseEntity.ok(result.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/key")
    public ResponseEntity<SearchUserByEmail> getUserByKeyValue(@RequestParam(value = "email") String email){
        Optional<SearchUserByEmail> result = userService.findNameAndEmailKeyValue(email);

        if (result.isPresent()){
            return ResponseEntity.ok(result.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
