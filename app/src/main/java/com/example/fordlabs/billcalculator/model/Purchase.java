package com.example.fordlabs.billcalculator.model;

public class Purchase {

    private Customer customer;

    private Discount discount;

    private Double serviceCost;

    private Double productCost;


    public Purchase(Customer customer, Discount discount, Double serviceCost, Double productCost) {
        this.customer = customer;
        this.discount = discount;
        this.serviceCost = serviceCost;
        this.productCost = productCost;
    }

    public Double getBill(){

        return null;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Discount getDiscount() {
        return discount;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public Double getProductCost() {
        return productCost;
    }
}
