package com.example.websitebanyen.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float price;
    private int number;
    private String description;
    private String title;
    private Date date;
    //trạng thái sản phẩm này còn hay

    //số lượng đã bán
    private int sold;
    private float sale;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Image> image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Comment> comments;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<ReceiptDetail> receiptDetails;

    public Product(float price, int number, String description, String title, Date date, int sold, float sale) {
        this.price = price;
        this.number = number;
        this.description = description;
        this.title = title;
        this.date = date;
        this.sold = sold;
        this.sale = sale;
    }

}
