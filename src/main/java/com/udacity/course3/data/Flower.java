package com.udacity.course3.data;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Flower extends Plant{

    public Flower(String name, BigDecimal price, String color) {
        super(name, price);
        this.color = color;
    }

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
