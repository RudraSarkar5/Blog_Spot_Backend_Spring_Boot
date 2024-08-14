package com.example.Blog_Spot_Backend.service.blogService;

import java.util.List;
import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Blog_Spot_Backend.entity.blogEntity.BlogEntity;
import com.example.Blog_Spot_Backend.entity.userEntity.UserEntity;
import com.example.Blog_Spot_Backend.model.blogModel.BlogModel;
import com.example.Blog_Spot_Backend.repository.blogRepository.BlogRepository;
import com.example.Blog_Spot_Backend.repository.userRepository.UserRepository;
import com.example.Blog_Spot_Backend.service.imageService.ImageService;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    ImageService imageService;

    
    
    public String addBlog( BlogModel data ){

        UserEntity userData = userRepo.findById(data.getCreatedBy()).orElse(null);
        BlogEntity blog = new BlogEntity();
        if ( userData != null){
            blog.setCreatedBy(userData);

        }else {
            return "at first create an account to do post.";
        }
        if ( data.getPublicId() != null ){
            blog.setPublicId(data.getPublicId());
        }
        blog.setCaption(data.getCaption());
        blog.setContent(data.getContent());
        blog.setContentType(data.getContentType());
        blogRepo.save(blog);
        return "successfully inserted data";
    }

    public List<BlogModel> getAllBlog (){
        List<BlogModel> allBlog = new ArrayList<BlogModel>();
        List<BlogEntity> allBlogAsEntity = new ArrayList<BlogEntity>();
        allBlogAsEntity = blogRepo.findAll();
        for (BlogEntity blogEntity : allBlogAsEntity) {
            BlogModel b = new BlogModel();
            b.setCaption(blogEntity.getCaption());
            b.setId(blogEntity.getId());
            b.setContent(blogEntity.getContent());
            b.setContentType(blogEntity.getContentType());
            UserEntity user = blogEntity.getCreatedBy();
            b.setCreatedBy(user.getEmail());
            allBlog.add(b);
        }

        return allBlog;
    }

    public String deleteBlog(Long id){
        BlogEntity blog = blogRepo.findById(id).orElse(null);
        if ( blog == null ){
            return "no blog found...";
        }else {
            if ( blog.getPublicId() != null ){
                imageService.deleteImageFromcloudinary(blog.getPublicId());
            }
            blogRepo.delete(blog);
            return "blog deleted successfully...";
        }
    }

    public String updateBlog(Long id , BlogModel data){

        BlogEntity blog = blogRepo.findById(id).orElse(null);

        if (blog == null) {
            return "blog not found";
        }

        if (data.getCaption() != null) {
            blog.setCaption(data.getCaption());
        }
        if (data.getContent() != null) {
            blog.setContent(data.getContent());
        }
       

        blogRepo.save(blog);

        return "successfully updated...";
    }


}
