package com.example.websitebanyen.model;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float price;
    private String imageRoot;
    private int number;
    private String description;
    private String title;
    private Date date;
    //trạng thái sản phẩm này còn hay không
    private int status;
    private float sale;

//    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
//    private Collection<Cart> cart;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private Collection<Comment> comments;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private Collection<ReceiptDetail>receiptDetails;

    public Product() {
    }

    public Product(int id, float price, String imageRoot, int number, String description, String title, Date date, int status, float sale, Category category, Collection<Comment> comments, Collection<ReceiptDetail> receiptDetails) {
        this.id = id;
        this.price = price;
        this.imageRoot = imageRoot;
        this.number = number;
        this.description = description;
        this.title = title;
        this.date = date;
        this.status = status;
        this.sale = sale;
        this.category = category;
        this.comments = comments;
        this.receiptDetails = receiptDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImageRoot() {
        return imageRoot;
    }

    public void setImageRoot(String imageRoot) {
        this.imageRoot = imageRoot;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Collection<ReceiptDetail> getReceiptDetails() {
        return receiptDetails;
    }

    public void setReceiptDetails(Collection<ReceiptDetail> receiptDetails) {
        this.receiptDetails = receiptDetails;
    }
}
