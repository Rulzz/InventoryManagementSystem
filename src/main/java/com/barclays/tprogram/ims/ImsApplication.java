package com.barclays.tprogram.ims;

import com.barclays.tprogram.ims.dao.OrderDao;
import com.barclays.tprogram.ims.dao.OrderItemDao;
import com.barclays.tprogram.ims.dto.ItemQuantityDTO;
import com.barclays.tprogram.ims.dto.OrderDTO;
import com.barclays.tprogram.ims.service.ItemService;
import com.barclays.tprogram.ims.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ImsApplication implements CommandLineRunner {

	@Autowired
	OrderService orderService;
	@Autowired
	ItemService itemService;

	public static void main(String[] args) {
		SpringApplication.run(ImsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		List<ItemQuantityDTO> itemQuantity = Arrays.asList(
				new ItemQuantityDTO(itemService.getById(1), 2),
				new ItemQuantityDTO(itemService.getById(2), 3),
				new ItemQuantityDTO(itemService.getById(3), 1)
				);
		orderService.create(new OrderDTO(null, itemQuantity, orderService.getTotal(itemQuantity)));

		itemQuantity = Arrays.asList(
				new ItemQuantityDTO(itemService.getById(2), 3),
				new ItemQuantityDTO(itemService.getById(3), 1),
				new ItemQuantityDTO(itemService.getById(4), 2)
		);
		orderService.create(new OrderDTO(null, itemQuantity, orderService.getTotal(itemQuantity)));

		itemQuantity = Arrays.asList(
				new ItemQuantityDTO(itemService.getById(1), 2),
				new ItemQuantityDTO(itemService.getById(2), 3)
		);
		orderService.create(new OrderDTO(null, itemQuantity, orderService.getTotal(itemQuantity)));

		itemQuantity = Arrays.asList(
				new ItemQuantityDTO(itemService.getById(2), 3)
		);
		orderService.create(new OrderDTO(null, itemQuantity, orderService.getTotal(itemQuantity)));
	}
}
