package com.barclays.tprogram.ims.repository;

import com.barclays.tprogram.ims.dao.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
}
