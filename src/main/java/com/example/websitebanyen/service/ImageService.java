package com.example.websitebanyen.service;

import com.example.websitebanyen.model.Image;
import com.example.websitebanyen.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    List<Image> getAllImage();

    Image getImage(Integer id);

    void uploadImage(List<MultipartFile> file, Product pro);

    void deleteImage(Integer id);
}
