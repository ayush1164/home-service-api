package com.homeservices.booking.dto.serviceoffering.request;

public class ServiceOfferingCreateRequest {
    private String name;
    private String description;
    private double price;
    private long categoryId;

    public ServiceOfferingCreateRequest(){}

    public ServiceOfferingCreateRequest(String name, String description,double price, long categoryId ){
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
