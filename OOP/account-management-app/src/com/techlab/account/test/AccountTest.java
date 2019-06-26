package com.techlab.account.test;
import com.techlab.account.*;

public class AccountTest {
	public static void main(String args[])
	{
		Account account1=new Account("darshan","120000016001",1400);
		boolean withdrawSuccess;

		printAccountDetail(account1);
		
		withdrawSuccess=account1.withdrawMoney(500);

		System.out.println("Balance Withdraw Successfully : "+withdrawSuccess);
		System.out.println("Balance : "+account1.getBalance());
		
	}
	public static void printAccountDetail(Account account)
	{
		System.out.println("Name : " + account.getName());
		System.out.println("Account Number : " + account.getAccountNumber());
		System.out.println("Balance : " + account.getBalance());}
}
