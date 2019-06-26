package com.techlab.account.test;


import com.techlab.account.Account;
import com.techlab.current.account.CurrentAccount;
import com.techlab.saving.account.SavingAccount;

public class AccountTest {
	private static String withdrawStatus;
	public static void main(String args[])
	{
		SavingAccount savingAccount=new SavingAccount("darshan",120000111001l, 500);
		CurrentAccount currentAccount=new CurrentAccount("vivek",120000111011l, 3000);

		displaynfo(currentAccount);
		withdrawStatus=currentAccount.withdraw(500);
		System.out.println(withdrawStatus+"\n");
		displaynfo(currentAccount);
		//displaynfo(currentAccount);	
	}
	public static void displaynfo(Account account)
	{
		System.out.println("name : "+account.getName());
		System.out.println("account no : "+account.getAccountNumber());
		System.out.println("balance : "+account.getBalance()+"\n");
	}
}
