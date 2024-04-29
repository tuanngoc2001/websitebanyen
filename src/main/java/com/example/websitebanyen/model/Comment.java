package com.example.websitebanyen.model;

import jakarta.persistence.*;
import java.util.Date;
//bảng comment của từng sản phẩm
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    private String content;
    private Date date;
    //sao đánh giá của người dùng với sản phẩm
    private float star;
    //trạng thái của comment đã xóa hay chưa mà sửa chưa
    private int status;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public Comment() {
    }

    public Comment(int id, String name, User user, String content, Date date, float star, int status, Product product) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.content = content;
        this.date = date;
        this.star = star;
        this.status = status;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
