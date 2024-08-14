package com.example.Blog_Spot_Backend.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Blog_Spot_Backend.entity.userEntity.UserEntity;
import com.example.Blog_Spot_Backend.model.userModel.UserModel;
import com.example.Blog_Spot_Backend.repository.userRepository.UserRepository;
import com.example.Blog_Spot_Backend.service.imageService.ImageService;
import com.example.Blog_Spot_Backend.utilityClass.UploadResponse;



@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    ImageService imageService;

    

    public String registerUser(UserModel data) {

        boolean exist = userRepo.existsByEmail(data.getEmail());

        if (exist) {

            return " User already Exist...";
        } else {

            UserEntity user = new UserEntity();

            user.setEmail(data.getEmail());
            user.setFullName(data.getFullName());
            user.setPassword(data.getPassword());

            userRepo.save(user);

            return "successfully registered...";
        }

    }

    public String loginUser(UserModel data) {

        UserEntity user = userRepo.getRegisteredUser(data.getEmail());

        if (user == null) {

            return " No user found . Please create a user first...";
        } else {

            if (data.getPassword().equals(user.getPassword())) {
                return " login successfully...";
            } else {
                return "password not matching ...";
            }
        }

    }

    public String deleteUser ( String email ){

        UserEntity user = userRepo.findById(email).orElse(null);

        if (user == null) {
            return "user not exit";
        }
        if (user.getPublicId() != null) {
            imageService.deleteImageFromcloudinary(user.getPublicId());
        }
        

        userRepo.deleteById(email);
        return "deleted successfully";
       
       
    }

    public String updataUser ( String email , UserModel data ){

        UserEntity user = userRepo.findById(email).orElse(null);

        if ( user == null ){
            return "user not exit";
        }

        if ( data.getEmail() != null ){
            user.setEmail(data.getEmail());
        }
        if ( data.getFullName() != null){
            user.setFullName(data.getFullName());
        }
        if ( data.getPassword() != null ){
            user.setPassword(data.getPassword());
        }

        userRepo.save(user);

        return "successfully updated...";
    }

    public UserModel getUserDetails ( String email ){

        UserModel user = new UserModel();
        UserEntity data = userRepo.findById(email).orElse(null);
        if ( data == null ){
            return user;
        }else {
            if ( data.getUrl() != null ){
                user.setUrl(data.getUrl());
            }
            user.setEmail(data.getEmail());
            user.setPassword(data.getPassword());
            user.setFullName(data.getFullName());
            return user;
        }
    }


    public String uploadImagesMethod ( UploadResponse data , String id){

        UserEntity user = userRepo.findById(id).orElse(null);

        if (user == null) {
            return "user not exit";
        }
        if ( user.getPublicId() != null ){
            imageService.deleteImageFromcloudinary(user.getPublicId());
        }
        user.setUrl(data.getUrl());
        user.setPublicId(data.getPublicId());
        userRepo.save(user);
        return "successrfully uploaded imaages";
    }

}
