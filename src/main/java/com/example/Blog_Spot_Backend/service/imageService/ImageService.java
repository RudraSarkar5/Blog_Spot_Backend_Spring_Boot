package com.example.Blog_Spot_Backend.service.imageService;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class ImageService {
    private final Cloudinary cloudinaryObj = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dq1fcwv4r",
            "api_key", "476246472867228",
            "api_secret", "W7RPBE3YWQP4PvGY_FUzuQLLv-o"));

    public String uploadImage(MultipartFile file) {
        try {
            Map<String, Object> uploadResult = cloudinaryObj.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String cloudinaryFileUrl =  uploadResult.get("url").toString();
            return cloudinaryFileUrl;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
        return null;
    }
}
