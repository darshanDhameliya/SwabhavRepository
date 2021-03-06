package com.techlab.account.test;

import com.techlab.account.*;

public class AccountTest {
	public static void main(String args[]) {
		Account account1 = new Account("darshan", "120000016001", 1000);
		boolean withdrawSuccess = false;
		
		account1.deposit(500);
		
		try {
			withdrawSuccess = account1.withdrawMoney(501);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Balance Withdraw Successfully : " + withdrawSuccess);
		System.out.println("Balance : " + account1.getBalance());

	}

	public static void printAccountDetail(Account account) {
		System.out.println("Name : " + account.getName());
		System.out.println("Account Number : " + account.getAccountNumber());
		System.out.println("Balance : " + account.getBalance());
	}
}
