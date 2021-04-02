package com.barclays.tprogram.ims.dto;

import com.barclays.tprogram.ims.dao.Item;

import java.util.HashMap;
import java.util.List;


public class OrderDTO {

    private Integer id;
    private List<ItemQuantityDTO> itemQuantity;
    private double value;

    public OrderDTO() {}

    public OrderDTO(Integer id, List<ItemQuantityDTO> itemQuantity, double value) {
        this.id = id;
        this.itemQuantity = itemQuantity;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ItemQuantityDTO> getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(List<ItemQuantityDTO> itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", itemQuantity=" + itemQuantity +
                ", value=" + value +
                '}';
    }
}
