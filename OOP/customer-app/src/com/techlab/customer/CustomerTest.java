package com.techlab.customer;

public class CustomerTest {
	public static void main(String args[])
	{
		Customer customer1=new Customer("Darshan","Dhameliya");
		Customer customer2=new Customer("Dhanraj","Vansadiya");
		Customer customer3=new Customer("Vivek","Jivani");


		System.out.println("customer Id : "+customer1.getCustomerId());
		System.out.println("customer First Name : "+customer1.getFirstName());
		System.out.println("customer Last Name : "+customer1.getLastName());
		
		System.out.println("customer Id : "+customer2.getCustomerId());
		System.out.println("customer First Name : "+customer2.getFirstName());
		System.out.println("customer Last Name : "+customer2.getLastName());
		
		System.out.println("customer Id : "+customer3.getCustomerId());
		System.out.println("customer First Name : "+customer3.getFirstName());
		System.out.println("customer Last Name : "+customer3.getLastName());
		
	}
}
