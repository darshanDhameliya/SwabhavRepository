package com.techlab.account;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountBalanceWithdrawTest {
	private Account account = new Account("darshan", "120000111210", 1000);

	@Test(expected = ArithmeticException.class)
	public void checkWithdrawCash_withdrawMoneyValueIsNegative_ThrowArithmeticException() {
		account.withdrawMoney(-200);
	}

	@Test(expected = InsufficientFundException.class)
	public void checkWithdrawCash_withdrawMoneyAfterAccountBalanceLessThan500_ThrowInsufficientFundException() {

		account.withdrawMoney(600);
	}

	@Test
	public void checkWithdrawCash_withdrawMoneyAfterAccountBalanceGetterThanEqualTo500_AccountBalanceShouldBe500() {

		account.withdrawMoney(500);

		int actual = account.getBalance();
		int excepted = 500;

		assertEquals(actual, excepted);
	}
}