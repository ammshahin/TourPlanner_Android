package com.example.tourplanner;

public class model {
    String   detail, imurl,name, offer, price;

    public model() {
    }

    public model(String detail, String imurl, String name, String offer, String price) {
        this.detail = detail;
        this.imurl = imurl;
        this.name = name;
        this.offer = offer;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImurl() {
        return imurl;
    }

    public void setImurl(String imurl) {
        this.imurl = imurl;
    }
}
