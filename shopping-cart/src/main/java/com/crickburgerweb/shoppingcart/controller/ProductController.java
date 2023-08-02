package com.crickburgerweb.shoppingcart.controller;


import com.crickburgerweb.shoppingcart.Entity.Product;
import com.crickburgerweb.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ProductController {

    private ProductService productService;


    @Autowired
    public ProductController(ProductService theProductService) {
        productService = theProductService;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        System.out.println("show all");
        return productService.findAll();

    }

    @GetMapping("/products/{productCode}")
    public Product findByCode(@PathVariable String productCode) {
        Product theProduct = productService.findByCode(productCode);
        if (theProduct == null) {
            return null;
        }
        return theProduct;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product theProduct) {
        productService.save(theProduct);
        return theProduct;
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product theProduct) {
        productService.save(theProduct);
        return theProduct;
    }

    @DeleteMapping("/products/{productCode}")
    public void deleteProduct(@PathVariable String productCode) {
        if (productService.findByCode(productCode) != null) {
            productService.deleteByCode(productCode);
            System.out.println("delete success");
        }
        System.out.println("no product code");
    }

}
