package com.example.bakery.SERVER.controllers;

import com.example.bakery.SERVER.models.Admin;
import com.example.bakery.SERVER.repositories.AdminRep;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Api("admin controller")
public class AdminControl {
    final
    AdminRep adminRepository;

    public AdminControl(AdminRep adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("/admins")
    @ApiOperation("get all admins")
    public ResponseEntity<List<Admin>> getAdmins() {
        return ResponseEntity.ok(adminRepository.findAll());
    }

    @GetMapping("/admins/{id}")
    @ApiOperation("get admin by id")
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") Long id) {

        return adminRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping("/users/login_in")
    @ApiOperation("create an admin")
    public ResponseEntity<List<Admin>> addUser(@RequestParam("name") String name, @RequestParam("surname") String surname,
                                               @RequestParam("login") String login, @RequestParam("password") String password,
                                               @RequestParam("position") String position) {

        Admin new_admin = new Admin();
        new_admin.name = name;
        new_admin.surname = surname;
        new_admin.position = position;
        new_admin.login = login;
        new_admin.password = password; //вроде так делать нехорошо, мб хэш пароля хранить, а, может, вообще не хранить его

        ResponseEntity.ok(adminRepository.save(new_admin));
        return ResponseEntity.ok(adminRepository.findAll());
    }
}
