package com.crickburgerweb.shoppingcart.dao;

import com.crickburgerweb.shoppingcart.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {

    public List<Product> findAllByOrderByPriceAsc();
}
