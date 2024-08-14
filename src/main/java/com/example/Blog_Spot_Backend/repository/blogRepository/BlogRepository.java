package com.example.Blog_Spot_Backend.repository.blogRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Blog_Spot_Backend.entity.blogEntity.BlogEntity;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity,Long> {
    
}
