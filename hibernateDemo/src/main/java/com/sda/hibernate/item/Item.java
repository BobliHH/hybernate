package com.sda.hibernate.item;

import com.sda.hibernate.Car;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "item")
    @GeneratedValue
    private Long itemId;
    @Column(name = "ITEM_TYPE")
    private String itemType;
    @ManyToOne
    @JoinColumn(name = "car_id",nullable = false)
    private Car car;

    public Item() {
    }

    public Item(Long itemId, String itemType) {
        this.itemId = itemId;
        this.itemType = itemType;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
