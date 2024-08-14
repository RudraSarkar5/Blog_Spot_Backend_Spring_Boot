package com.example.Blog_Spot_Backend.controller.blogController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Blog_Spot_Backend.model.blogModel.BlogModel;
import com.example.Blog_Spot_Backend.service.blogService.BlogService;
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
    
    @PostMapping("/add")
    public String postMethodName(@RequestBody BlogModel data ) {
        return blogService.addBlog(data);
    }

    @GetMapping("")
    public List<BlogModel>  getMethodName() {
        return blogService.getAllBlog();
        // return "all blog is here";
    }

    @DeleteMapping("/delete")
    public String deleteBlogMethod(@RequestParam("id") long id){
        return blogService.deleteBlog(id);
    }

    @PutMapping("blog-update/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody BlogModel data) {
        Long val = Long.valueOf(id);
        return blogService.updateBlog(val, data);
    }
    
    

}
