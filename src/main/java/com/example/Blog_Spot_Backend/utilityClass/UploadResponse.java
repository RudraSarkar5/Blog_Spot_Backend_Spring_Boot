package com.example.Blog_Spot_Backend.utilityClass;

import lombok.Data;

@Data
public class UploadResponse {
    private String url;
    private String publicId;

    public UploadResponse(String url, String publicId){
        this.url = url;
        this.publicId = publicId;
    }

}
