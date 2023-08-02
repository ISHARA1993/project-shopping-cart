package com.crickburgerweb.shoppingcart.service;

import com.crickburgerweb.shoppingcart.Entity.Product;
import com.crickburgerweb.shoppingcart.dao.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    Product product;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl serviceImpl;

    //Initialize each test case
    @BeforeEach
    void init() {
        product = new Product();
        product.setCode("testCode");
        product.setName("testName");
        product.setPrice(100.00);
    }


    @DisplayName("Test Find All")
    @Test
    void findAll() {
         List<Product> products = new ArrayList<>();
        products.add(product);

        when(productRepository.findAllByOrderByPriceAsc()).thenReturn(products);

        List<Product> foundProducts = serviceImpl.findAll();
        verify(productRepository).findAllByOrderByPriceAsc();

        assertThat(foundProducts).hasSize(1);

    }

    @DisplayName("Test Find By Code")
    @Test
    void findByCode() {

        when(productRepository.findById(anyString())).thenReturn(Optional.of(product));
        Product foundProduct=serviceImpl.findByCode("testCode");

        verify(productRepository).findById(anyString());
        assertThat(foundProduct).isNotNull();

    }

    @DisplayName("Test Save")
    @Test
    void save() {
        when(productRepository.save(any(Product.class))).thenReturn(product);
        serviceImpl.save(new Product());
        verify(productRepository).save(any(Product.class));


    }

    @DisplayName("Delete By Code")
    @Test
    void deleteByCode() {
        serviceImpl.deleteByCode("testCode");
        verify(productRepository).deleteById(anyString());

    }
}