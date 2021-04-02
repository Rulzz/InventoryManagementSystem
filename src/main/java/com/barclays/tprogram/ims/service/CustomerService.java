package com.barclays.tprogram.ims.service;

import com.barclays.tprogram.ims.dao.Customer;
import com.barclays.tprogram.ims.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public List<Customer> getAll(){
        return (List<Customer>)repository.findAll();
    }

    public Customer getById(Integer id) {
        if(!repository.findById(id).isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer Id is not present");
        return repository.findById(id).get();
    }

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public Customer update(Customer customer) {
        if(customer.getId()==null) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Customer Id to update is null");
        if(!repository.findById(customer.getId()).isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer Id to update is not present");
        return repository.save(customer);
    }

    public void delete(Integer id) {
        if(id==null) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Customer Id to delete is null");
        if(!repository.findById(id).isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer Id to delete is not present");
        repository.deleteById(id);
    }
}
