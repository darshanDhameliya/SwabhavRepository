package com.techlab.account.test;

import com.techlab.account.Account;

public class TestToString {
	public static void main(String args[])
	{
		Account account=new Account("mitul","120000123001");
		System.out.println(account.toString());
		System.out.println(account);
	}
	 
}
