package com.puthisastra.first;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional
	public List<Order> getOrders() {
		List<Order> orders = orderRepository.findAll();
		for (Order order : orders) {
			order.getOrderDetail();
		}
		return orders;
	}

	public List<OrderDTO> getOrdersDTO() {
		List<Order> orders = orderRepository.findAll();
		List<OrderDTO> ordersDTO = new ArrayList<OrderDTO>();
		for (Order order : orders) {
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setId(order.getId());
			orderDTO.setName(order.getName());
			OrderDetail detail = order.getOrderDetail();
			OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
			orderDetailDTO.setId(detail.getId());
			orderDetailDTO.setName(detail.getName());
			orderDTO.setOrderDetailDTO(orderDetailDTO);
			ordersDTO.add(orderDTO);
		}
		return ordersDTO;
	}
	
	public List<OrderDTO> getOrdersWithoutDetailDTO() {
		List<Order> orders = orderRepository.findAll();
		List<OrderDTO> ordersDTO = new ArrayList<OrderDTO>();
		for (Order order : orders) {
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setId(order.getId());
			orderDTO.setName(order.getName());
			ordersDTO.add(orderDTO);
		}
		return ordersDTO;
	}
}
