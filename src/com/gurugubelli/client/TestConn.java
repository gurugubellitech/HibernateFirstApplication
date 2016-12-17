package com.gurugubelli.client;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConn {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sg3tutorials", "sg3tutorials");
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
