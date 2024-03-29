package com.techlab.account;

public class Account {
	private String name;
	private String accountNumber;
	private int balance;
	private static int MINIMUM_BALANCE = 500;

	public Account(String name, String accountNumber, int balance) {
		if (name == null || accountNumber == null) {
			throw new NullPointerException();
		}
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public Account(String name, String accountNumber) {
		this(name, accountNumber, MINIMUM_BALANCE);
	}

	public void setName(String name) {
		this.name=name;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber=accountNumber;
	}

	public void setBalance(int balance) {
		this.balance=balance;
	}
	public String getName() {
		return name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void deposit(int amount) {
		if (amount<=0) 
			throw new ArithmeticException();
		this.balance += amount;
	}

	public boolean withdrawMoney(int money) {
		if (money <= 0)
			throw new ArithmeticException();
		if (checkBalance(money)) {
			this.balance -= money;
			return true;
		}
		return false;
	}

	public boolean checkBalance(int money) {
		if (this.balance - money < MINIMUM_BALANCE)
			throw new InsufficientFundException(this, money);
		if (this.balance-money >= MINIMUM_BALANCE)
			return true;
		return false;
	}

}
