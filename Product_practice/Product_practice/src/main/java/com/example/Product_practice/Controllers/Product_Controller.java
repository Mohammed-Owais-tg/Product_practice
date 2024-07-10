package com.example.Product_practice.Controllers;

import com.example.Product_practice.Data.Product;
import com.example.Product_practice.Services.Product_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Product_Controller {

    @Autowired
    Product_Service service;

    @GetMapping("products/")
    public List<Product> getProducts(){
        return service.getproducts();
    }

    @GetMapping("products/{prodid}")
    public Product getById(@PathVariable int prodid){
        return service.getById(prodid);
    }

    @PostMapping("products/")
    public void addProducts(@RequestBody Product prod){
        service.addProduct(prod);
    }

    @PutMapping("products/")
    public void updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);
    }

    @DeleteMapping("products/")
    public void DeleteProduct(@RequestBody Product prod){
        service.DeleteProduct(prod);
    }
}
