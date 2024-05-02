package com.example.websitebanyen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
//bảng comment của từng sản phẩm
@Entity
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

}
