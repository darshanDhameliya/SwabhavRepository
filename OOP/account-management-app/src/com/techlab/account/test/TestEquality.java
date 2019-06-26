package com.techlab.account.test;

import com.techlab.account.Account;

public class TestEquality {
	public static void main(String args[]) {
		Account account1 = new Account("darshan", "120000016001", 1400);
		Account account2 = new Account("darshan", "120000016001", 1400);

		System.out.println(account1==account1);
		System.out.println(account1==account2);
		System.out.println(account1.equals(account1));
		System.out.println(account1.equals(account2));
	}

}
