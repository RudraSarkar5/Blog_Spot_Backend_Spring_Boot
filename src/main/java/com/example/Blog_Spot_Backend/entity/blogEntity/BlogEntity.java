package com.example.Blog_Spot_Backend.entity.blogEntity;

import com.example.Blog_Spot_Backend.entity.userEntity.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "blog_data")

public class BlogEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Long id;
    private String content;
    private String caption;

    @ManyToOne
    @JoinColumn(name = "createdBy", referencedColumnName = "email") 
    private UserEntity createdBy;

    public String getContent() {
        return content;
    }

    public String getCaption() {
        return caption;
    }

    public Long getId() {
        return id;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    
   
}
