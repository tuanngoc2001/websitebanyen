package com.example.websitebanyen.controller;

import com.example.websitebanyen.dto.CategoryDto;
import com.example.websitebanyen.dto.ProductDto;
import com.example.websitebanyen.model.Category;
import com.example.websitebanyen.model.Product;
import com.example.websitebanyen.service.CategoryService;
import com.example.websitebanyen.service.ImageService;
import com.example.websitebanyen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
@CrossOrigin("*")
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private CategoryService categoryService;
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


    //cập nhật và thêm sản phẩm
    @PutMapping("/update-product")
    public ResponseEntity addProductTest(@ModelAttribute ProductDto dto)
    {
        try{
            Optional<Product> proOld = productService.findById(dto.getId());
            if(proOld.isPresent()) {
                Product product = proOld.get();
                product.setPrice(dto.getPrice());
                product.setNumber(dto.getNumber());
                product.setDescription(dto.getDescription());
                product.setTitle(dto.getTitle());
                product.setDate(dto.getDate());
                product.setSold(dto.getSold());
                product.setSale(dto.getSale());
                productService.save(product);

            } else {
                Optional<Category> category = categoryService.findById(dto.getCategory().getId());
                Product pro = new Product(dto.getPrice(), dto.getNumber(), dto.getDescription(), dto.getTitle(),dto.getDate(), dto.getSold(), dto.getSale());
                if(category.isPresent()){
                    pro.setCategory(category.get());
                }
                productService.save(pro);
                Product productNew = productService.findAllByDateNew().get(0);
                imageService.uploadImage(dto.getFile(), productNew);
            }

            return new ResponseEntity(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    //xóa sản phẩm
    @PostMapping("/delete-product")
    public void removeProduct(@RequestParam int id)
    {
        productService.deleteProduct(id);
    }

    public Product toEntity(ProductDto dto) {
        return new Product(dto.getPrice(), dto.getNumber(), dto.getDescription(), dto.getTitle(),dto.getDate(), dto.getSold(), dto.getSale());
    }
    public ProductDto toDto(Product pro){
        CategoryDto cateDto = new CategoryDto(pro.getCategory().getId(),pro.getCategory().getName(),pro.getCategory().getStatus());
        ProductDto dto = new ProductDto(pro.getId(),pro.getPrice(), pro.getNumber(), pro.getDescription(), pro.getTitle(),pro.getDate(), pro.getSold(), pro.getSale(),cateDto);
        return dto;
    }
}
