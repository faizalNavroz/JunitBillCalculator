package com.example.fordlabs.billcalculator.service;

import com.example.fordlabs.billcalculator.InvalidInputException;
import com.example.fordlabs.billcalculator.model.Purchase;

public class BillCalculationService {


    public Double calculate(Purchase purchase) throws InvalidInputException {

        if(null  == purchase.getServiceCost()){
            throw new InvalidInputException("Invalid entry for service cost");
        }
        if(null == purchase.getProductCost()){
            throw new InvalidInputException("Invalid entry for product cost");
        }
        Double totalAmount = 0.0;
        Double purchasedAmount = purchase.getServiceCost()+ purchase.getProductCost();
        totalAmount = purchasedAmount-(getMembershipDiscount(purchase,purchase.getServiceCost()) + getProductDiscount(purchase,purchase.getProductCost()));
        return totalAmount;
    }

    public Double getProductDiscount(Purchase purchase, Double totalAmount) {
        Double percentage = purchase.getDiscount().getProductDiscount(purchase.getCustomer().getMember());
        return percentage * totalAmount;
    }

    public Double getMembershipDiscount(Purchase purchase, Double totalAmount) {
        Double percentage = purchase.getDiscount().getServiceDiscount(purchase.getCustomer().getMemberType());
        return percentage * totalAmount;
    }
}
