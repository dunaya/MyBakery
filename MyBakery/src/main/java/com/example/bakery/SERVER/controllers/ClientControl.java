package com.example.bakery.SERVER.controllers;

import com.example.bakery.SERVER.models.Client;
import com.example.bakery.SERVER.repositories.ClientRep;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("user controller")
public class ClientControl {
    @Autowired
    ClientRep userRepository;


    @GetMapping("/users")
    @ApiOperation("get all clients")
    public ResponseEntity<List<Client>> getClient() {
        return ResponseEntity.ok(userRepository.findAll());
    }
    @GetMapping("/users/{id}")
    @ApiOperation("get client by id")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id) {
        return userRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/user_by_name/{name}")
    public Client findClient(@PathVariable("login") String login) {
        return userRepository.findByClientLogin(login);
    }

    @RequestMapping ("/users/login_in")
    @ApiOperation("create a client")
    public ResponseEntity <List<Client>> addUser(@RequestParam("name") String name, @RequestParam("surname") String surname,
                                                 @RequestParam("login") String login, @RequestParam("password") String password) {

        Client new_client = new Client();
        new_client.name = name;
        new_client.surname = surname;
        new_client.login = login;
        new_client.password = password; //вроде так делать нехорошо, мб хэш пароля хранить, а, может, вообще не хранить его

        ResponseEntity.ok(userRepository.save(new_client));
        return  ResponseEntity.ok(userRepository.findAll());
    }

}