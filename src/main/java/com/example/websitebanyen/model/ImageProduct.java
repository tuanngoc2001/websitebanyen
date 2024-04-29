package com.example.websitebanyen.model;

import jakarta.persistence.*;

@Entity
@Table(name = "imageProduct")
public class ImageProduct {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private String image;

    public ImageProduct(long id, Product product, String image) {
        this.id = id;
        this.product = product;
        this.image = image;
    }

    public ImageProduct() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
