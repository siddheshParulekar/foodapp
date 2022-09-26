package com.pojo;
public class Cart {
	private int cartId;
	private int foodId;
	private String username;
	private int foodQuantity;
	private double totalPrice;
	
	public Cart() {
		super();
	}

	public Cart(int cartId, int foodId, String username, int foodQuantity, double totalPrice) {
		super();
		this.cartId = cartId;
		this.foodId = foodId;
		this.username = username;
		this.foodQuantity = foodQuantity;
		this.totalPrice = totalPrice;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", foodId=" + foodId + ", username=" + username + ", foodQuantity="
				+ foodQuantity + ", totalPrice=" + totalPrice + "]";
	}
}