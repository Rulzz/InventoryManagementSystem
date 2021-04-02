package com.barclays.tprogram.ims.repository;

import com.barclays.tprogram.ims.dao.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>  {
}
