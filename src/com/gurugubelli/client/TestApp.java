package com.gurugubelli.client;

import java.io.Serializable;
import java.util.zip.CRC32;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import com.gurugubelli.pojo.Account;

public class TestApp {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		TestApp testApp = new TestApp();
		
		int accountNumber = testApp.createAccount(session);
		System.out.println("Account number created with: " + accountNumber);
		
		Account account = testApp.getAccountDetails(session, accountNumber);
		if(account.getAccNumber()>= 0) {
			System.out.println("\n===============");
			System.out.println("Account Details");
			System.out.println("===============");
			System.out.println("Name   :" + account.getName());
			System.out.println("Number :" + account.getAccNumber());
			System.out.println("Balance:" + account.getBalance());
		} else {
			System.out.println("Account Not Found");
		}
	}
	
	public int createAccount(Session session) {
		Account saveAccObj = new Account();
		saveAccObj.setAccNumber(1234);
		saveAccObj.setName("Gurugubelli");
		saveAccObj.setBalance(30000);
		Serializable number = session.save(saveAccObj);
		session.beginTransaction().commit();
		return (int)number;
	}
	
	public Account getAccountDetails(Session session, int accountNumber) {
		Object accountObj = session.get("com.gurugubelli.pojo.Account", accountNumber);
		Account account = (Account) accountObj;
		return account;
	}
}
