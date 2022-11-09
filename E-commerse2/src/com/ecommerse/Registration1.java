package com.ecommerse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration1 {

	String user_name;
	String pass_word;
	String product_1;
	String product_2;
	String product_3;
	String product_4;
	String product_5;
	int total_amount;

	public void getRegistration() throws UsernameExistExeception {
		System.out.println("Register Youself ");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter Your User_Name to register");
		user_name = scanner.nextLine();
		ConnectionTest1 connectionTest1=new ConnectionTest1();
	try {
		Connection	connection=connectionTest1.getConnection();
	PreparedStatement	ps=connection.prepareStatement("select user_name from userdata where user_name=?");
	ps.setString(1,user_name);
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		if(user_name.equals(rs.getString(1))) {
			throw new UsernameExistExeception("Usernmae Already Exists");
		}
	}
	System.out.println("Hello "+user_name+",Please Set Password");
	pass_word=scanner.next();
	System.out.println("User Registered successfully");
	connection.close();
	ps.close();
	rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		System.out.println("Please Enter Password");
		pass_word = scanner.nextLine();
		System.out.println("User Register Successfully");

	}
	public void userLogin() throws IncorrectPasswordException  {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please Login..");
		System.out.println("Please Enter your user Id");
		user_name=scanner.next();
		System.out.println("Please Enter your Password");
		pass_word=scanner.next();
		ConnectionTest1  connectionTest1=new ConnectionTest1();
	try {
		Connection	connection=connectionTest1.getConnection();
	PreparedStatement	ps=connection.prepareStatement("select * from userdata where user_name=? and pass_word=?");
	ps.setString(1, user_name);
	ps.setString(2, pass_word);
	ResultSet rs=ps.executeQuery();
	if(rs.next()) {
		System.out.println("You have Logged in Successfully");
	}
	else {
	throw new	IncorrectPasswordException("Incorrect Username or Password...");
		
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void selectProduct() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please select product to insert into cart");
		System.out.println("Select product 1");
		product_1=scanner.nextLine();
		System.out.println("Select product 2");
		product_2=scanner.nextLine();
		System.out.println("Select product 3");
		product_3=scanner.nextLine();
		System.out.println("Select product 4");
		product_4=scanner.nextLine();
		System.out.println("Select product 5");
		product_5=scanner.nextLine();
		System.out.println("Amount");
		total_amount=scanner.nextInt();
		System.out.println("");
		System.out.println("Successfully Added to Cart");
		
	}
	public void insertData() {
		ConnectionTest1  connectionTest1=new ConnectionTest1();
	try {
		Connection  connection=connectionTest1.getConnection();
	PreparedStatement	ps1=connection.prepareStatement("insert into userdata( user_name, pass_word, product_1, product_2, product_3, product_4, product_5, total_amount)values(?,?,?,?,?,?,?,?)");
	ps1.setString(1,user_name);
	ps1.setString(2,pass_word);
	ps1.setString(3, product_1);
	ps1.setString(4, product_2);
	ps1.setString(5, product_3);
	ps1.setString(6, product_4);
	ps1.setString(7, product_5);
	ps1.setInt(8, total_amount);
	ps1.execute();
	System.out.println("Successfully data inserted");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
