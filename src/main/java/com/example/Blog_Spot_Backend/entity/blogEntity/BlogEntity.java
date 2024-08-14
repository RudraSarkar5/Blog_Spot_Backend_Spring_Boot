package com.example.Blog_Spot_Backend.entity.blogEntity;

import com.example.Blog_Spot_Backend.entity.userEntity.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "blog_data")

public class BlogEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Long id;
    private String content;
    private String caption;
    private String contentType;
    private String publicId;

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getPublicId() {
        return publicId;
    }

    @ManyToOne
    @JoinColumn(name = "createdBy") 
    private UserEntity createdBy;

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public String getCaption() {
        return caption;
    }

    public Long getId() {
        return id;
    }

   

    public void setContent(String content) {
        this.content = content;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

   

    
   
}
