package com.crickburgerweb.shoppingcart.service;

import com.crickburgerweb.shoppingcart.Entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    public Product findByCode(String theCode);

    public void save(Product theProduct);

    public void deleteByCode(String theCode);

}
