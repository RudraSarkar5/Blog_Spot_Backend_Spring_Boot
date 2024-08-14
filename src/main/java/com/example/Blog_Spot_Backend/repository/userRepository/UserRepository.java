package com.example.Blog_Spot_Backend.repository.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Blog_Spot_Backend.entity.userEntity.UserEntity;



@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

     @Query("SELECT COUNT(u) > 0 FROM UserEntity u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);

    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    UserEntity getRegisteredUser(@Param("email") String email);
   
}
