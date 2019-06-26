package com.techlab.shopping.cart.test;

import com.techlab.item.Item;
import com.techlab.payment.strategy.CreditCardStrategy;
import com.techlab.payment.strategy.PaypalStrategy;
import com.techlab.shopping.cart.ShoppingCart;

public class ShoppingCartTest {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		
		Item item1 = new Item("1234",10);
		Item item2 = new Item("5678",40);
		
		cart.addItem(item1);
		cart.addItem(item2);
		
		cart.pay(new PaypalStrategy("myemail@email.com", "mypwd"));
		
		cart.pay(new CreditCardStrategy("Darshan Dhameliya", "3214567890123456", "255", "12/21"));
	}

}