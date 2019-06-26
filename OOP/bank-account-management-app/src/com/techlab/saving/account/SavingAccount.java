package com.techlab.saving.account;

import com.techlab.account.Account;

public class SavingAccount extends Account {

	private int MIN_BALANCE = 500;

	public SavingAccount(String name, Long accountNumber, int balance) {
		super(name, accountNumber, balance);
	}

	@Override
	public String withdraw(int amount) {
		if (checkAccountBalance(amount, MIN_BALANCE)) {
			balance -= amount;
			return "withdraw";
		}

		return "not withdraw";
	}
}
