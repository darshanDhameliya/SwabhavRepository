package com.techlab.account;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountBalanceDepositTest {

	private Account account = new Account("darshan", "120000111210", 1000);

	@Test(expected = ArithmeticException.class)
	public void checkDepositCash_DepositCashValueIsNegativeOrZero_ThrowArithmeticException() {
		account.deposit(-10);
	}

	@Test
	public void checkDepositCash_DepositCashValueIs500_AccountBalanceShouldBe1500() {
		account.deposit(500);

		int actual = account.getBalance();
		int excepted = 1500;
		assertEquals(actual, excepted);
	}
}