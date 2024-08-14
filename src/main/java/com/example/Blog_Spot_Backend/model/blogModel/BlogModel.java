package com.example.Blog_Spot_Backend.model.blogModel;

import lombok.Data;

@Data
public class BlogModel {
    
    private Long id;
    private String content;
    private String caption;
    private String createdBy;
    private String contentType;
    private String publicId;
}
