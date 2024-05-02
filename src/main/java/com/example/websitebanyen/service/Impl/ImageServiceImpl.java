package com.example.websitebanyen.service.Impl;

import com.example.websitebanyen.model.Image;
import com.example.websitebanyen.model.Product;
import com.example.websitebanyen.repository.ImageRepository;
import com.example.websitebanyen.service.ImageService;
import com.example.websitebanyen.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    private final FileUtils fileUtils;
    @Override
    public List<Image> getAllImage() {
        return imageRepository.findByOrderByCreatedAtDesc();
    }

    @Override
    public Image getImage(Integer id) {
        return imageRepository.findById(Long.valueOf(id)).orElseThrow(() -> {
            throw new NullPointerException();
        });
    }

    @Override
    public void uploadImage(List<MultipartFile> files, Product pro) {
        for (MultipartFile file: files) {
            fileUtils.validateFile(file);

            try {
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                Image image = new Image(fileName, file.getContentType(), file.getBytes());
                image.setProduct(pro);
                imageRepository.save(image);
            } catch (Exception e) {
                throw new RuntimeException("Upload image error");
            }
        }
    }

    @Override
    public void deleteImage(Integer id) {
        Image image = imageRepository.findById(Long.valueOf(id)).orElseThrow(() -> {
            throw new NullPointerException();
        });

        imageRepository.delete(image);
    }
}
