package com.example.websitebanyen.repository;

import com.example.websitebanyen.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    // Lấy danh sách tất cả image theo thời gian tạo giảm dần
    List<Image> findByOrderByCreatedAtDesc();
}
