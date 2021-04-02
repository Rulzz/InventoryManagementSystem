package com.barclays.tprogram.ims.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Order_Items")
@IdClass(OrderItemRelationship.class)
public class OrderItemDao implements Serializable {
    @Id
    private Integer orderId;
    @Id
    private Integer itemId;
    private Integer quantity;
    public OrderItemDao() {}
    public OrderItemDao(Integer orderId, Integer itemId, Integer quantity) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}