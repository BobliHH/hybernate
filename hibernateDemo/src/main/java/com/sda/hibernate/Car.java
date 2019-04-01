package com.sda.hibernate;

import com.sda.hibernate.item.Item;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "car_color")
    private String color;

    @Column(name = "ca_model")
    private String model;

    @OneToMany(mappedBy = "car", cascade = {CascadeType.REMOVE})
    private Set<Item> items;


    public Car() {
    }


    public Car(Long id, String color, String model, Set<Item> items) {
        this.id = id;
        this.color = color;
        this.model = model;
        this.items = items;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
