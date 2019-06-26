package com.techlab.account;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountConstructorTest {
	private Account account;

	@Test(expected = NullPointerException.class)
	public void testAccountConstructorPassingValueNull_PassValueOfAccountNameAndAccountNumber_ThrowNullPointerException() {
		System.out.println("check null value pass in Constructor");
		account = new Account(null, null);
	}

	@Test
	public void testAccountConstructorPassingValueNotNull_PassValueOfAccountNameAndAccountNumber_ShoulsNotThrowNullPointerException() {
		System.out.println("check not null value pass in Constructor");
		account = new Account("darshan", "120111000021",1000);
	}

}