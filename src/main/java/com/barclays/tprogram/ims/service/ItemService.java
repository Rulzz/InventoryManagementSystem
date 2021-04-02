package com.barclays.tprogram.ims.service;

import com.barclays.tprogram.ims.dao.Item;
import com.barclays.tprogram.ims.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository repository;

    public List<Item> getAll(){
        return (List<Item>)repository.findAll();
    }


    public Item getById(Integer id) {
        if(!repository.findById(id).isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item Id is not present");
        return repository.findById(id).get();
    }

    public Item create(Item item) {
        return repository.save(item);
    }

    public Item update(Item item) {
        if(item.getId()==null) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Item Id to update is null");
        if(!repository.findById(item.getId()).isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item Id to update is not present");
        return repository.save(item);
    }

    public void delete(Integer id) {
        if(id==null) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Item Id to delete is null");
        if(!repository.findById(id).isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item Id to delete is not present");
        repository.deleteById(id);
    }

    public List<Item> findAllById(List<Integer> itemIds) {
        return (List<Item>) repository.findAllById(itemIds);
    }
}
