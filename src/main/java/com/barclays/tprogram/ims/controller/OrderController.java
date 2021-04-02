package com.barclays.tprogram.ims.controller;

import com.barclays.tprogram.ims.dto.OrderDTO;
import com.barclays.tprogram.ims.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController implements CrudController<OrderDTO> {
    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService service;
    @Override
    @GetMapping
    public List<OrderDTO> readAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public OrderDTO readyById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @Override
    @PostMapping("/add")
    public OrderDTO create(@RequestBody OrderDTO orderDTO) {
        return service.create(orderDTO);
    }

    @Override
    @PutMapping("/update")
    public OrderDTO update(@RequestBody OrderDTO orderDTO) {
        return service.update(orderDTO);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
