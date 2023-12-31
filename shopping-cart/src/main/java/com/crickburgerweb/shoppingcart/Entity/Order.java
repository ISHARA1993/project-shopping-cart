package com.crickburgerweb.shoppingcart.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "orders")
//@UniqueConstraint(columnNames = "order_num")
public class Order implements Serializable {


    private static final long serialVersionUID = -2576670215015463100L;

    @Id
    @Column(name = "ID", length = 50)
    private String id;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_num", nullable = false, unique=true)
    private int orderNum;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "customer_name", length = 255, nullable = false)
    private String customerName;

    @Column(name = "customer_address", length = 255, nullable = false)
    private String customerAddress;

    @Column(name = "customer_email", length = 128, nullable = false)
    private String customerEmail;

    @Column(name = "customer_phone", length = 128, nullable = false)
    private String customerPhone;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderDate=" + orderDate +
                ", orderNum=" + orderNum +
                ", amount=" + amount +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                '}';
    }
}
