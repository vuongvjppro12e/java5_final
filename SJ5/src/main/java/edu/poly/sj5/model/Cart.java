package edu.poly.sj5.model;

import java.util.Map;

public class Cart {

	// Key: ma san pham, Value: so luong san pham
	private Map<Integer, Integer> cartDetails;

	public Map<Integer, Integer> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(Map<Integer, Integer> cartDetails) {
		this.cartDetails = cartDetails;
	}
	
}
