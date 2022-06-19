package edu.poly.sj5.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetail")
@IdClass(OrderDetailId.class)
public class OrderDetail {

	@Id
	@ManyToOne
	@JoinColumn(name = "orderid", insertable = false, updatable = false)
	private Order order;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "productid", insertable = false, updatable = false)
	private Product product;
	
	@Column(name="purchasedquantity", nullable = false)
	private Integer purchasedQuantity;
	
	@Column(name="purchasedmoney", nullable = false)
	private BigDecimal purchasedMoney;

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

	public Integer getPurchasedQuantity() {
		return purchasedQuantity;
	}

	public void setPurchasedQuantity(Integer purchasedQuantity) {
		this.purchasedQuantity = purchasedQuantity;
	}

	public BigDecimal getPurchasedMoney() {
		return purchasedMoney;
	}

	public void setPurchasedMoney(BigDecimal purchasedMoney) {
		this.purchasedMoney = purchasedMoney;
	}
	
}
