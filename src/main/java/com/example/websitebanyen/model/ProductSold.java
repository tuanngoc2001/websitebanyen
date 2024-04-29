package com.example.websitebanyen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// bảng này chứa thông tin các sản phẩm đã bán
@Entity
@Table(name = "product_sold")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //số lượng sản phẩm đã mua
    private int number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private float price;

    private Date purchaseDate;

}
