package com.techlab.account;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountGetterSetterTest {
	private Account account = new Account("darshan", "120000111021",1000);

	@Test
	public void testSetName_SetAccountNameValueGivenIsDarshan_ResultAccountNameShouldBeDarshan() {
		account.setName("darshan");
		String exceptedName = account.getName();

		assertEquals("darshan", exceptedName);
	}

	@Test
	public void testSetAccountNumber_SetAccountNumberValueGivanIs120000111021_ResultAccountNumberShouldBe120000111021() {
		account.setAccountNumber("120000111021");
		String exceptedAccountNumber = account.getAccountNumber();

		assertEquals("120000111021", exceptedAccountNumber);
	}

	@Test
	public void testSetBalance_SetAccountBalanceValueGivenIs1000_ResultAccountBalanceShouldBe1000() {
		account.setBalance(1000);
		int exceptedBalance = account.getBalance();

		assertEquals(1000, exceptedBalance);
	}
	@Test
	public void testGetName_GetAccountName_ResultAccountNameShouldBeDarshan() {
		String actualAccountName= account.getName();
		String exceptedAccountName ="darshan";
		assertEquals(actualAccountName, exceptedAccountName);
	}

	@Test
	public void testGetAccountNumber_GetAccountNumber_ResultAccountNumberShouldBe120000111021() {
		String actualAccountNumber= account.getAccountNumber();
		String exceptedAccountNumber ="120000111021";
		assertEquals(actualAccountNumber, exceptedAccountNumber);
	}

	@Test
	public void testGetBalance_GetAccountBalance_ResultAccountBalanceShouldBe1000() {
		int actualAccountBalance= account.getBalance();
		int exceptedAccountBalance =1000;
		assertEquals(actualAccountBalance, exceptedAccountBalance);
	}
}