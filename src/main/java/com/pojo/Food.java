package com.pojo;

public class Food {
	private String name;
	private double price;
	private int foodId; 
	
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Food(String name, double price, int foodId) {
		super();
		this.name = name;
		this.price = price;
		this.foodId = foodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	@Override
	public String toString() {
		return "Food [name=" + name + ", price=" + price + ", foodId=" + foodId + "]";
	}
	
	

	
	
	 
}
