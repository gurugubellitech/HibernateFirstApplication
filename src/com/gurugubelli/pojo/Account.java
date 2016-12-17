package com.gurugubelli.pojo;

public class Account {
	private int accNumber;
	private String name;
	private double balance;

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Account [accNumber=" + accNumber + ", name=" + name
				+ ", balance=" + balance + "]";
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
