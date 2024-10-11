package com.example.doanfood;

import java.util.Date;

public class Shop {
    int id;
    String name;
    String address;
    String number;
    String category;
    Date open, close;
    byte[] image;
    double rate;

    public Shop(){}

    public Shop(int id, String name, String address, String number, String category, Date open, Date close, byte[] image, double rate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.category = category;
        this.open = open;
        this.close = close;
        this.image = image;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public void setClose(Date close) {
        this.close = close;
    }

    public Date getOpen() {
        return open;
    }

    public Date getClose() {
        return close;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
