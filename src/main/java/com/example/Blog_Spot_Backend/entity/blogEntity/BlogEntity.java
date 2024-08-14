package com.example.Blog_Spot_Backend.entity.blogEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "blog_data")
@Data
public class BlogEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Long id;
    private String content;
    private String caption;
    private String createdBy;
}
