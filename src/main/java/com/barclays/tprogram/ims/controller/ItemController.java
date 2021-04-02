package com.barclays.tprogram.ims.controller;


import com.barclays.tprogram.ims.dao.Item;
import com.barclays.tprogram.ims.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController implements CrudController<Item> {
    private final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    ItemService service;

    @Override
    @GetMapping
    public List<Item> readAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Item readyById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @Override
    @PostMapping("/add")
    public Item create(@RequestBody Item item) {
        return service.create(item);
    }

    @Override
    @PutMapping("/update")
    public Item update(@RequestBody Item item) {
        return service.update(item);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
