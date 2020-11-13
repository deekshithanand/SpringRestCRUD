package com.tut.RestCrud.service;

import java.util.List;

import com.tut.RestCrud.entity.Product;
import com.tut.RestCrud.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    // posting single product
    public Product saveProduct(Product product) {
        return repo.save(product);
    }

    // posting all methods
    public List<Product> saveProducts(List<Product> products) {
        return repo.saveAll(products);
    }

    // get all objects
    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).get();
    }

    // based on name
    public Product getByName(String name) {
        return repo.findByName(name);
    }

    // method for delete
    public String deleteProduct(int id) {
        repo.deleteById(id);
        return "Product Deleted Sucessfully" + id;
    }

    // method for update
    public String updateProductById(Product newProduct) {
        Product prod = repo.findById(newProduct.getId()).get();
        if (prod != null) {
            repo.save(newProduct);
        }

        return "Product Updated SucessFully!...";
    }
}
