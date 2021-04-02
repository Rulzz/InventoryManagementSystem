package com.barclays.tprogram.ims.dto;

import com.barclays.tprogram.ims.dao.Item;

public class ItemQuantityDTO {

    private Item item;
    private Integer quantity;

    public ItemQuantityDTO(Item item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
