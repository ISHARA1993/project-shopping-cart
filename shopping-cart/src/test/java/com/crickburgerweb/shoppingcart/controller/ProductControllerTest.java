package com.crickburgerweb.shoppingcart.controller;

import com.crickburgerweb.shoppingcart.Entity.Product;
import com.crickburgerweb.shoppingcart.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Product Control Test")
@ExtendWith(MockitoExtension.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {

    Product product;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private ProductService service;

    @Autowired
    ObjectMapper mapper;

    //Initialize each test case
    @BeforeEach
    void init() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        product = new Product();
        product.setCode("testCode");
        product.setName("testName");
        product.setPrice(100.00);
    }


    @DisplayName("Product List All")
    @Test
    void findAll() throws Exception {
        List<Product> allProduct = Arrays.asList(product);

        given(service.findAll()).willReturn(allProduct);
        mvc.perform(get("/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @DisplayName("Product get by Code")
    @Test
    void findByCode() throws Exception {
        given(service.findByCode(product.getCode())).willReturn(product);
        mvc.perform(get("/products/" + product.getCode())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is(product.getName())))
                .andExpect(jsonPath("price", is(product.getPrice())));

    }


    @DisplayName("Add Product ")
    @Test
    void addProduct() throws Exception {
        mvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(product.getCode())))
                .andExpect(jsonPath("$.name", is(product.getName())))
                .andExpect(jsonPath("$.price", is(product.getPrice())));
    }

    @Disabled
    @Test
    void updateProduct() throws Exception {
        //Product updateProduct=new Product();
        product.setName("updateTestName");
        product.setPrice(110.00);

       // ObjectMapper mapper = new ObjectMapper();

        mvc.perform(put("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(product)))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.code", is(product.getCode())))
                .andExpect(jsonPath("$.name", is(product.getName())))
                .andExpect(jsonPath("$.price", is(product.getPrice())));


    }

    @DisplayName("Delete Product ")
    @Test
    void deleteProduct() throws Exception {
        doNothing().when(service).deleteByCode(product.getCode());
        mvc.perform(delete("/products/" + product.getCode())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}