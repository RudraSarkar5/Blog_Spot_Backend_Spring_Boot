package com.example.Blog_Spot_Backend.repository.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Blog_Spot_Backend.entity.userEntity.UserEntity;



@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

   
}
