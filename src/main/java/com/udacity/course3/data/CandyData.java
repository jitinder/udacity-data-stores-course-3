package com.udacity.course3.data;

import java.math.BigDecimal;

public class CandyData {
    Long candyId;
    String name;
    BigDecimal price;

    public CandyData() {
    }

    public CandyData(Long candyId, String name, BigDecimal price) {
        this.candyId = candyId;
        this.name = name;
        this.price = price;
    }

    public Long getCandyId() {
        return candyId;
    }

    public void setCandyId(Long candyId) {
        this.candyId = candyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
