package com.barclays.tprogram.ims.dao;


import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double value;
    public OrderDao() {}

    public OrderDao(double value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}