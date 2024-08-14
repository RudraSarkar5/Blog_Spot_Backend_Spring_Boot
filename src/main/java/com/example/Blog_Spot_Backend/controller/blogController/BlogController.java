package com.example.Blog_Spot_Backend.controller.blogController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.example.Blog_Spot_Backend.model.blogModel.BlogModel;
import com.example.Blog_Spot_Backend.service.blogService.BlogService;
import com.example.Blog_Spot_Backend.service.imageService.ImageService;
import com.example.Blog_Spot_Backend.utilityClass.UploadResponse;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RequestMapping("api/v1/blog")
@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    ImageService imageService;
    
    @PostMapping("/add")
    public String postMethodName(
        @RequestParam(value = "image" , required = false) MultipartFile imageFile,
        @RequestParam(value = "caption" , required = false) String caption,
        @RequestParam(value = "content" , required = false) String content,
        @RequestParam(value = "createdBy" ) String createdBy
        
    ) {

        BlogModel bm = new BlogModel();
        
        if(caption != null ){
            bm.setCaption(caption);
        }
        if(createdBy != null ){
            bm.setCreatedBy(createdBy);
        }
       
        if(imageFile != null ){
           UploadResponse response = imageService.uploadImage(imageFile);
           bm.setContentType("MEDIA");
           bm.setContent(response.getUrl());
           bm.setPublicId(response.getPublicId());
        }else {
            bm.setContent(content);
            bm.setContentType("TEXT");
            
        }
        
        return blogService.addBlog(bm);
    }

    @GetMapping("")
    public List<BlogModel>  getMethodName() {
        return blogService.getAllBlog();
        
    }

    @DeleteMapping("/delete")
    public String deleteBlogMethod(@RequestParam("id") long id){
        return blogService.deleteBlog(id);
    }

    @PutMapping("/blog-update/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody BlogModel data) {
        Long val = Long.valueOf(id);
        return blogService.updateBlog(val, data);
    }

    
    
    

}
