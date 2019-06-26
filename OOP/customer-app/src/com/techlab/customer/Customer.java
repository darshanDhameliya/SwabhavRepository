package com.techlab.customer;

public class Customer {
	private String firstName;
	private String lastName;
	private int cutomerId;
	private static int ID_GENERATE=1000;
	
	public Customer(String firstName,String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		ID_GENERATE++;
		
		cutomerId=ID_GENERATE;
	}
	public int getCustomerId() {
		return cutomerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
}
