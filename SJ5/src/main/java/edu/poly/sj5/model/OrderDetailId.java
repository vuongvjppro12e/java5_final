package edu.poly.sj5.model;

import java.io.Serializable;

public class OrderDetailId implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private Order order;
	private Product product;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
