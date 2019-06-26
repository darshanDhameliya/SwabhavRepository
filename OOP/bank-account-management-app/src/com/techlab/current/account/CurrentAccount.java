package com.techlab.current.account;

import com.techlab.account.Account;

public class CurrentAccount extends Account {
	private int MIN_BALANCE = 2000;

	public CurrentAccount(String name, Long accountNumber, int balance) {
		super(name, accountNumber, balance);
	}

	@Override
	public String withdraw(int amount) {
		if (checkAccountBalance(amount,MIN_BALANCE)) {
			balance -= amount;
			return "withdraw";
		}

		return "not withdraw";
	}
}
