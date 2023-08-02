package com.crickburgerweb.shoppingcart.service;

import com.crickburgerweb.shoppingcart.Entity.Product;
import com.crickburgerweb.shoppingcart.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository theProductRepository) {
        productRepository = theProductRepository;
    }


    @Override
    public List<Product> findAll() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public Product findByCode(String theCode) {
        Optional<Product> result = productRepository.findById(theCode);
        if (!result.isPresent()) {
            System.out.println("no product");
            return null;
        }
        return result.get();

    }

    @Override
    public void save(Product theProduct) {
        productRepository.save(theProduct);
    }

    //new method check
    @Override
    public void deleteByCode(String theCode) {
        productRepository.deleteById((theCode));
    }
}
