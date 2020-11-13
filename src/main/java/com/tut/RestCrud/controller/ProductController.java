package com.tut.RestCrud.controller;

import java.util.List;

import com.tut.RestCrud.entity.Product;
import com.tut.RestCrud.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    // register the service(injected)
    @Autowired
    private ProductService service;

    // Endpoints begin here
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/getProductByName")
    public Product getProductByName(@RequestParam String name) {
        return service.getByName(name);
    }

    // update endpoint
    @PutMapping("/updateProduct")
    public String updateProduct(@RequestBody(required = true) Product product) {
        return service.updateProductById(product);
    }

    @DeleteMapping("/deleteProduct")
    public String deleteProduct(@RequestParam(required = true) int id) {
        return service.deleteProduct(id);
    }

}
