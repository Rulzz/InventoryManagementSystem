package com.barclays.tprogram.ims.service;

import com.barclays.tprogram.ims.dao.Item;
import com.barclays.tprogram.ims.dto.ItemQuantityDTO;
import com.barclays.tprogram.ims.dto.OrderDTO;
import com.barclays.tprogram.ims.dao.OrderDao;
import com.barclays.tprogram.ims.dao.OrderItemDao;
import com.barclays.tprogram.ims.repository.OrderDaoRepository;
import com.barclays.tprogram.ims.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@Service
public class OrderService {
    @Autowired
    OrderDaoRepository orderDaoRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    ItemService itemService;

    public List<OrderDTO> getAll(){
        List<Integer> orderIds = orderItemRepository.findAllOrderIds();

        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(Integer orderId : orderIds){
            List<Object[]> itemQuantity = orderItemRepository.findAllItemQuantitiesInOrder(orderId);
            List<ItemQuantityDTO> itemQuantityDTOs = new ArrayList<>();
            for(Object[] itemQ : itemQuantity) itemQuantityDTOs.add(new ItemQuantityDTO(itemService.getById((Integer) itemQ[0]), (Integer) itemQ[1]));
            orderDTOS.add(new OrderDTO(orderId, itemQuantityDTOs, getTotal(itemQuantityDTOs)));
        }
        return orderDTOS;
    }

    public OrderDTO getById(Integer id) {
        if(!orderDaoRepository.findById(id).isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order Id is not present");
        List<Object[]> itemQuantity = orderItemRepository.findAllItemQuantitiesInOrder(id);
        List<ItemQuantityDTO> itemQuantityDTOs = new ArrayList<>();
        for(Object[] itemQ : itemQuantity) itemQuantityDTOs.add(new ItemQuantityDTO(itemService.getById((Integer)itemQ[0]), (Integer)itemQ[1]));
        return new OrderDTO(id, itemQuantityDTOs, getTotal(itemQuantityDTOs));
    }

    public OrderDTO create(OrderDTO orderDTO) {
        OrderDao order = new OrderDao(getTotal(orderDTO.getItemQuantity()));
        if(orderDTO.getId()!=null) order.setId(orderDTO.getId());
        OrderDao savedOrder = orderDaoRepository.save(order);
        for(ItemQuantityDTO itemQ : orderDTO.getItemQuantity()) {
            itemService.getById(itemQ.getItem().getId()); // validate item ids
            orderItemRepository.save(new OrderItemDao(savedOrder.getId(), itemQ.getItem().getId(), itemQ.getQuantity()));
        }

        return this.getById(savedOrder.getId());
    }

    public OrderDTO update(OrderDTO orderDTO) {

        if(orderDTO.getId()==null) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Order Id to update is null");
        if(!orderDaoRepository.findById(orderDTO.getId()).isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order Id is not present");
        orderItemRepository.deleteByOrderId(orderDTO.getId());

        OrderDao order = new OrderDao(getTotal(orderDTO.getItemQuantity()));
        order.setId(orderDTO.getId());
        orderDaoRepository.save(order);

        for(ItemQuantityDTO itemQ : orderDTO.getItemQuantity()) {
            itemService.getById(itemQ.getItem().getId()); // validate item ids
            orderItemRepository.save(new OrderItemDao(orderDTO.getId(), itemQ.getItem().getId(), itemQ.getQuantity()));
        }
        
        return getById(orderDTO.getId());
    }

    public void delete(Integer id) {
        if(id==null) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Order Id to update is null");
        if(!orderDaoRepository.findById(id).isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order Id is not present");
        orderDaoRepository.deleteById(id);
        orderItemRepository.deleteByOrderId(id);
    }

    public double getTotal(List<ItemQuantityDTO> items){
        double value = 0f;
        for(ItemQuantityDTO itemQ : items) value = value + itemQ.getItem().getCost()*itemQ.getQuantity();
        return value;
    }
}
