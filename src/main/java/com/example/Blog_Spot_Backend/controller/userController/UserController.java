package com.example.Blog_Spot_Backend.controller.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Blog_Spot_Backend.model.userModel.UserModel;
import com.example.Blog_Spot_Backend.service.userService.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("api/v1/user/")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    public String postLoginUser(@RequestBody UserModel data) {

        return userService.loginUser(data);
    }

    @PostMapping("signUp")
    public String postMethodName(@RequestBody UserModel data) {

        // System.out.println("got their request...");
        // return "successfully created user";
        return userService.registerUser(data);
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteMethodName(@PathVariable String id) {
        return "deleted successfully.";
    }

    @PutMapping("/update-user/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody String entity) {
        // TODO: process PUT request

        return entity;
    }

}
