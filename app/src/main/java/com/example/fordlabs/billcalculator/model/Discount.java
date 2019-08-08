package com.example.fordlabs.billcalculator.model;

public class Discount {

    private Double diamondServiceDiscount = 0.17;

    private Double platinumServiceDiscount = 0.13;

    private Double goldServiceDiscount = 0.09;

    private Double productDiscount = 0.15;




    public Double getServiceDiscount(String membershipType){
        Double serviceDiscount = null;
        if(membershipType.equalsIgnoreCase("DIAMOND")){
            return diamondServiceDiscount;
        }else if (membershipType.equalsIgnoreCase("PLATINUM")){
            return  platinumServiceDiscount;
        }else if (membershipType.equalsIgnoreCase("GOLD")){
            return goldServiceDiscount;
        }
        return 0.00;
    }

    public Double getProductDiscount(String member){
        if(member.equalsIgnoreCase("YES")){
            return productDiscount;
        }
       return 0.00;
    }
}
