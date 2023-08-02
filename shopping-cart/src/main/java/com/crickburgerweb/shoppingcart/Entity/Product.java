package com.crickburgerweb.shoppingcart.Entity;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    private static final long serialVersionUID = -1000119078147252957L;


    @Id
    @Column(name = "code", length = 20, nullable = false)
    private String code;

    @Lob
    @Column(name = "image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;

    @Column(name = "name", length = 255, nullable = false)
    private String name;


    @Column(name = "price", nullable = false)
    private double price;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "Create_Date", nullable = false)
    private Date createDate=new Date();

    public Product() {

    }

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public Product(String code, byte[] image, String name, double price) {
        this.code = code;
        this.image = image;
        this.name = name;
        this.price = price;

    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", image=" + Arrays.toString(image) +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createDate=" + createDate +
                '}';
    }
}
