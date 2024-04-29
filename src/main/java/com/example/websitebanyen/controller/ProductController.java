package com.example.websitebanyen.controller;

import com.example.websitebanyen.model.Product;
import com.example.websitebanyen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    /**
     * get all product
     */
    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll()
    {
        List<Product> products=productService.findAll();
        if(products.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * lọc theo id de vao man chi tiet
     * @param id
     * @return
     */
    @GetMapping("/search-by-id")
    public ResponseEntity<Product> findAllById(@RequestParam int id) {
        Optional<Product> product=productService.findById(id);
        if(!product.isPresent())
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    /**
     * tìm kiểm theo loại sản phẩm
     */
    @GetMapping("/search-by-cateId")
    public ResponseEntity<Product> findAllByCateId(@RequestParam int id) {
        Product product=productService.findAllByCategoryId(id);
        if(product==null)
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * tìm kiểm theo giá từ caop tới thấp
     */

    @GetMapping("/price-decrease")
    public ResponseEntity<Iterable<Product>>findAllByPriceDecrease()
    {
        Iterable<Product> products=productService.findAllByPriceDecrease();
        if(products==null)
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/price-increase")
    public ResponseEntity<Iterable<Product>>findAllByPriceIncrease()
    {
        Iterable<Product> products=productService.findAllByPriceIncrease();
        if(products==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/sort-date")
    public ResponseEntity<List<Product>>findAllByDateNew()
    {
        List<Product> products=productService.findAllByDateNew();
        if(products==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //find by name
    @GetMapping("/search-by-name")
    public ResponseEntity<List<Product>>findAllByName(@RequestParam String name)
    {
        List<Product> products=productService.findAllByName(name);
        if(products==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //admin
    //thêm sản phẩm
    @PostMapping("/add-product")
    public void addProduct(@RequestParam Product product)
    {
        productService.save(product);
    }


    //xóa sản phẩm
    @PostMapping("/delete-product")
    public void removeProduct(@RequestParam int id)
    {
        productService.deleteProduct(id);
    }




}
