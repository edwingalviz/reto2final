/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.g8.controller;

import com.example.g8.entities.User;
import com.example.g8.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bmao9
 */
@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService service;
    
    //lista de usuarios
    @GetMapping("/all")
    public List<User> findAllUser(){
        return service.getAll();
    }
    
    //autenticacion correos existentes
    @GetMapping("emailexist/{email}")
    public boolean findAllAdres(@PathVariable("email")String email){
        return service.findAdress(email);
        
    }
    
    //autenticacion al ingreso
    @GetMapping("/emailexist/{email}/{password}")
    public User findUserExistend(@PathVariable("email")String email,@PathVariable("password") String password){
        return service.findExistens(email, password);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user){
        
         return service.save(user);  
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User editclothe(@RequestBody User clothe){
        return service.update(clothe);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }
    
    
    
}
