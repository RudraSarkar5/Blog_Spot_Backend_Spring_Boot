package com.example.Blog_Spot_Backend.service.imageService;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.Blog_Spot_Backend.utilityClass.UploadResponse;

@Service
public class ImageService {
    private final Cloudinary cloudinaryObj = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dq1fcwv4r",
            "api_key", "476246472867228",
            "api_secret", "W7RPBE3YWQP4PvGY_FUzuQLLv-o"));

    public UploadResponse uploadImage(MultipartFile file) {
        try {
           
            Map<String, Object> uploadResult = cloudinaryObj.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String url =  uploadResult.get("url").toString();
            String publicId =  uploadResult.get("public_id").toString();
            return  new UploadResponse(url,publicId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
        return null;
    }

    public boolean deleteImageFromcloudinary(String publicId){
        try {
            cloudinaryObj.uploader().destroy(publicId, null);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
