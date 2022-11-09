package com.ecommerse;

import java.sql.SQLException;
import java.util.Scanner;

public class TestMain1 {

	private static int Id;

	public static void main(String[] args) throws SQLException, IncorrectPasswordException {
Scanner scanner=new Scanner(System.in);
		Registration1 registration = new Registration1();
		System.out.println("Welcome E-Commerse App");
		System.out.println("Are you existing user ?");
		String input=scanner.next();
		if(input.equalsIgnoreCase("No")) {
			System.out.println("Please Register to login");
		
		try {
			registration.getRegistration();
			registration.insertData();
			registration.userLogin();
			
			MainProduct1 mainProduct = new MainProduct1();
			mainProduct.getMainProduct();

			registration.selectProduct();
			
			Admin admin = new Admin();
			admin.displayTable();

			
			System.out.println("Enter userId for Fetching user data");
			int id = scanner.nextInt();
			admin.fetchData(id);
		} catch (UsernameExistExeception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(input.equalsIgnoreCase("yes")) {
			
		}
		MainProduct1 mainProduct = new MainProduct1();
		registration.userLogin();
		mainProduct.getMainProduct();
		
		registration.selectProduct();
		registration.insertData();
		Admin admin = new Admin();
		admin.displayTable();

		
		System.out.println("Enter userId for Fetching user data");
		int id = scanner.nextInt();
		admin.fetchData(id);

		// registration.getRegisteredList();

		// Cart cart=new Cart();
		// cart.addCart();
	}
}