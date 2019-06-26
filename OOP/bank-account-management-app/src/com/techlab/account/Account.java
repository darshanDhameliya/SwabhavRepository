package com.techlab.account;

abstract public class Account {
	private String name;
	private Long accountNumber;
	protected int balance;
	
	public Account(String name,Long accountNumber,int balance) {
		this.name=name;
		this.accountNumber=accountNumber;
		this.balance=balance;
	}

	public String getName() {
		return name;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	
	
	public void deposit(int amount) {
		balance+=amount;
	}
	abstract public String withdraw(int amount);
	public boolean checkAccountBalance(int amount,int MIN_BALANCE)
	{
		if((balance-amount)>MIN_BALANCE)
			return true;
		return false;
	}
}
