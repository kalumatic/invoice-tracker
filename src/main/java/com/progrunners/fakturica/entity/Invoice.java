package com.progrunners.fakturica.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "goods")
    private String goods;

    @Column(name = "amount")
    private double amount;

    @Column(name = "invoice_date")
    private String date = null;

    @Column(name = "price")
    private double price;

    public Invoice() {

    }

    public Invoice(String username, String goods, double amount, String date, double price) {
        this.username = username;
        this.goods = goods;
        this.amount = amount;
        this.date = date;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getGoods() {
        return goods;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }
}
