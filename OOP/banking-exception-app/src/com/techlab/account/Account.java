package com.techlab.account;

public class Account {
	private String name;
	private String accountNumber;
	private int balance;
	private int MINIMUM_BALANCE = 500;

	public Account(String name, String accountNumber, int balance) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public Account(String name, String accountNumber) {
		this(name, accountNumber, 500);
	}

	public boolean withdrawMoney(int money) {
		if (checkBalance(money)) {
			this.balance -= money;
			return true;
		}
		return false;
	}

	public boolean checkBalance(int money) {
		if (this.balance-money < 500)
			throw new InsufficientFundException(this,money);
		if (this.balance > MINIMUM_BALANCE)
			return true;
		return false;
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

	public String toString() {
		return "Name : " + this.name + "\nAccount Number : " + this.accountNumber + "\nBalance : " + this.balance + "\n"
				+ super.toString();
	}

	public boolean equals(Account account) {
		return this.name == account.name && this.accountNumber == account.accountNumber
				&& this.balance == account.balance;

	}
}
