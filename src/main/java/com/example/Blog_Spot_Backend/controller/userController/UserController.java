package com.example.Blog_Spot_Backend.controller.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Blog_Spot_Backend.model.userModel.UserModel;
import com.example.Blog_Spot_Backend.service.imageService.ImageService;
import com.example.Blog_Spot_Backend.service.userService.UserService;
import com.example.Blog_Spot_Backend.utilityClass.UploadResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("api/v1/user/")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ImageService imageService;

    @PostMapping("login")
    public String postLoginUser(@RequestBody UserModel data) {
        return userService.loginUser(data);
    }

    @PostMapping("signUp")
    public String postMethodName(@RequestBody UserModel data) {
        return userService.registerUser(data);
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteMethodName(@PathVariable String id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/update-user/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody UserModel data) {
        return userService.updataUser( id, data);
    }

    @GetMapping("/get-user-details/{id}")
    public UserModel getMethodName(@PathVariable String id) {
        return userService.getUserDetails(id);
    }

    @PostMapping("/upload-profile-photo")
    public String postMethodName(
                                @RequestParam("profile-photo") MultipartFile imagFile,
                                @RequestParam("email") String id
                                ) {
        
        UploadResponse uploadResponse = imageService.uploadImage(imagFile);
        return userService.uploadImagesMethod(uploadResponse, id);
    }
    
    

}
