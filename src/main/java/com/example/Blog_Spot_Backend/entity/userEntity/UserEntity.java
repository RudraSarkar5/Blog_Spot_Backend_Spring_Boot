package com.example.Blog_Spot_Backend.entity.userEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
@Table(name = "userTable")
public class UserEntity {

    @Id
    @Email
    private String email;
    private String fullName;
    private String password;
}
