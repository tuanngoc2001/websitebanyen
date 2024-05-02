package com.example.websitebanyen.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

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
    private List<MultipartFile> file;

    public ProductDto(int id, float price, int number, String description, String title, Date date, int sold, float sale, CategoryDto category) {
        this.id = id;
        this.price = price;
        this.number = number;
        this.description = description;
        this.title = title;
        this.date = date;
        this.sold = sold;
        this.sale = sale;
        this.category = category;
    }
}
