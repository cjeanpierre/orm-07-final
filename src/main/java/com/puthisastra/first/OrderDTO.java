package com.puthisastra.first;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

public class OrderDTO {

	private Long id;
	
	private String name;
	
	private OrderDetailDTO orderDetailDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OrderDetailDTO getOrderDetailDTO() {
		return orderDetailDTO;
	}

	public void setOrderDetailDTO(OrderDetailDTO orderDetailDTO) {
		this.orderDetailDTO = orderDetailDTO;
	}
	
	
}
