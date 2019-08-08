package com.example.fordlabs.billcalculator.model;

public class Customer {

    private String name;

    private String member;

    private String memberType;

    public String getName() {
        return name;
    }

    public String getMember() {
        return member;
    }

    public String getMemberType() {
        return memberType;
    }

    public Customer(String name, String member, String memberType) {
        this.name = name;
        this.member = member;
        this.memberType = memberType;

    }
}
