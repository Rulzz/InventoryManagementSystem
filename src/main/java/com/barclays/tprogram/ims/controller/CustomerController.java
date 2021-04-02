package com.barclays.tprogram.ims.controller;

import com.barclays.tprogram.ims.dao.Customer;
import com.barclays.tprogram.ims.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController implements CrudController<Customer> {

    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService service;

    @Override
    @GetMapping
    public List<Customer> readAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Customer readyById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @Override
    @PostMapping("/add")
    public Customer create(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @Override
    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return service.update(customer);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
