package com.udacity.course3.data;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Shrub extends Plant{

    private int height;
    private int width;

    public Shrub(String name, BigDecimal price, int height, int width) {
        super(name, price);
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
