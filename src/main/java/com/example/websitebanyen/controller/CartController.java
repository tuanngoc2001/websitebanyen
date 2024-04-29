package com.example.websitebanyen.controller;

import com.example.websitebanyen.model.Cart;
import com.example.websitebanyen.model.Product;
import com.example.websitebanyen.service.CartService;
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
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

//    @Autowired
//    private UserService userService;


    @PostMapping("/update-cart")
    public ResponseEntity findAllByStatus(@RequestBody Cart cart)
    {
        Optional<Product> product = productService.findById(cart.getProduct().getId());
        cart.setProduct(product.get());
//        Optional<User> user = userService.findById(cart.getUser().getId());
        cartService.save(cart);

        return new ResponseEntity(cart,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll()
    {
        return new ResponseEntity(cartService.findAll(),HttpStatus.OK);
    }

    @GetMapping ("/search-by-userId")
    public ResponseEntity findAllUserId(@RequestBody int id)
    {
        List<Cart> lstCart =  cartService.findAllUserId(id);
        if(lstCart.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity(lstCart,HttpStatus.OK);
    }

    @PostMapping ("/delete")
    public ResponseEntity deleteById(@RequestParam int id)
    {
        Cart cart = cartService.findById(id);
        if(cart == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        cartService.deleteCart(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
