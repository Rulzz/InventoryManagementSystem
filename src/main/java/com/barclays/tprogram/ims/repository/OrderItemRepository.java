package com.barclays.tprogram.ims.repository;

import com.barclays.tprogram.ims.dao.OrderItemDao;
import com.barclays.tprogram.ims.dao.OrderItemRelationship;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface OrderItemRepository extends CrudRepository<OrderItemDao, OrderItemRelationship> {
    @Query(value = "select item_id,quantity  from Order_Items oi where oi.order_id=?1", nativeQuery = true)
    List<Object[]> findAllItemQuantitiesInOrder(Integer orderId);

    @Query(value = "select distinct order_id from Order_Items", nativeQuery = true)
    List<Integer> findAllOrderIds();

    @Modifying
    @Query(value = "delete from Order_Items where order_id=?1", nativeQuery = true)
    void deleteByOrderId(Integer orderId);
}
