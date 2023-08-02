package com.crickburgerweb.shoppingcart.Entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
class ProductTest {


    @Test
    @DisplayName("Product test")
    void productTest() {
        Product product=new Product("s1","Rain",100.00);

        assertAll("Properties Test",
                () -> assertAll("Product Properties",
                        ()->assertEquals("s1",product.getCode(),"Code did not match"),
                        ()->assertEquals("Rain",product.getName(),"Name did not Match"),
                        ()->assertEquals(100.0,product.getPrice(),"Price did not match")

                )
                );


    }

    @Test
    @DisplayName("Product test with create date")
    void productTestWithDate() {
        Product product=new Product("s1","Rain",100.00);
        Date date=new Date();
        assertAll("Properties Test",
                () -> assertAll("Product Properties",
                        ()->assertEquals("s1",product.getCode(),"Code did not match"),
                        ()->assertEquals("Rain",product.getName(),"Name did not Match"),
                        ()->assertEquals(100.0,product.getPrice(),"Price did not match")
                        ,()->assertEquals(date,product.getCreateDate(),"Create date did not match")
                )
        );

    }
}