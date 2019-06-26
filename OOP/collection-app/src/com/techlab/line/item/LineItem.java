package com.techlab.line.item;

public class LineItem {
	private int id;
	private String productName;
	private Double price;
	private int quantity;
	public LineItem(int id,String productName,Double price,int quantity)
	{
		this.id=id;
		this.productName=productName;
		this.price=price;
		this.quantity=quantity;
	}
	public int getId() {
		return id;
	}
	public String getProductName() {
		return productName;
	}
	public Double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public Double calculateItemCost()
	{
		return quantity*price;
	}
}
