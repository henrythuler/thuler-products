package com.thulerproducts.models;

import java.math.BigDecimal;

public class Product {

    private int code;
    private String name;
    private String description;
    private BigDecimal value;

    public Product(){}

    public Product(int code, String name, String description, BigDecimal value){
        this.code = code;
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public int getCode(){
        return code;
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }

}
