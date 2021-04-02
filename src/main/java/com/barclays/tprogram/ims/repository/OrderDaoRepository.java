package com.barclays.tprogram.ims.repository;

import com.barclays.tprogram.ims.dao.OrderDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderDaoRepository extends CrudRepository<OrderDao, Integer> {
}
