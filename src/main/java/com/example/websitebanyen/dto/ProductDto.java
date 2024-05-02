package com.example.websitebanyen.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private int id;
    private float price;
    private int number;
    private String description;
    private String title;
    private Date date;
    private int sold;
    private float sale;
    private CategoryDto category;
}
