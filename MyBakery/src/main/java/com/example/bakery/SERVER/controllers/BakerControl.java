package com.example.bakery.SERVER.controllers;

import com.example.bakery.SERVER.models.Baker;
import com.example.bakery.SERVER.repositories.BakerRep;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("user controller")
public class BakerControl {
    @Autowired
    BakerRep userRepository;


    @GetMapping("/users")
    @ApiOperation("get all clients")
    public ResponseEntity<List<Baker>> getClient() {
        return ResponseEntity.ok(userRepository.findAll());
    }
    @GetMapping("/users/{id}")
    @ApiOperation("get client by id")
    public ResponseEntity<Baker> getClientById(@PathVariable("id") Long id) {
        return userRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/user_by_name/{name}")
    public Baker findClient(@PathVariable("login") String login) {
        return userRepository.findByBakerLogin(login);
    }

    @RequestMapping ("/users/login_in")
    @ApiOperation("create a client")
    public ResponseEntity <List<Baker>> addUser(@RequestParam("name") String name, @RequestParam("surname") String surname,
                                                 @RequestParam("login") String login, @RequestParam("password") String password,
                                                @RequestParam("qualification") String qualification) {

        Baker new_baker = new Baker();
        new_baker.name = name;
        new_baker.surname = surname;
        new_baker.login = login;
        new_baker.password = password; //вроде так делать нехорошо, мб хэш пароля хранить, а, может, вообще не хранить его
        new_baker.qualification = qualification;

        ResponseEntity.ok(userRepository.save(new_baker));
        return  ResponseEntity.ok(userRepository.findAll());
    }

}