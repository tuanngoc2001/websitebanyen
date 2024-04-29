package com.example.websitebanyen.repository;

import com.example.websitebanyen.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAll();
    Product findAllByCategoryId(int id);

    @Modifying
    @Query(value = "select * from product  order by product.price desc", nativeQuery = true)
    List<Product>findAllByPriceDec();

    @Modifying
    @Query(value = "select * from product  order by product.price asc", nativeQuery = true)
    List<Product>findAllByPriceIncr();

//    @Modifying
//    @Query(value = "select * from product where product.title like '%name%'", nativeQuery = true)
    List<Product> findByTitleContaining(String name);

    //lấy những mặt hàng bán được nhiều nhất.


    //lấy các mặt hàng mới
    @Modifying
    @Query(value = "select * from product order by date desc", nativeQuery = true)
    List<Product> findAllByDateNew();

}
