package com.udacity.course3.data;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String recipientName;

    @Column(name = "address_full", length = 500)
    private String address;

    private LocalDateTime deliveryTime;

    @Type(type = "yes_no")
    private Boolean complete;

    @OneToMany(mappedBy = "delivery")
    private List<Plant> plants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }
}
