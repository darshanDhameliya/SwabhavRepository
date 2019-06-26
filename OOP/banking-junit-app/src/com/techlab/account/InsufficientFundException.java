package com.techlab.account;

public class InsufficientFundException extends RuntimeException{

	private String message;
	public InsufficientFundException(Account account,int money)
	{
		this.message="Isufficieant fund, "+account.getName()+"`s current balance is "+account.getBalance()+", you trying to withdraw balance : "+money;
	}
	public String getMessage() {
		return message;
	}
}
