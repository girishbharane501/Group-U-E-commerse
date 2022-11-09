package com.ecommerse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
	public void displayTable() {
		ConnectionTest1 connectionTest1=new ConnectionTest1();
	try {
		Connection	connection=connectionTest1.getConnection();
PreparedStatement	ps=connection.prepareStatement("select * from userdata");
			ResultSet rs=ps.executeQuery();
			 System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
             System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s","userId", "user_name", "pass_word", "product_1"," product_2"," product_3"," product_4"," product_5","total_amount");
             System.out.println();
             System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			while(rs.next()) {
				System.out.printf("%-20d %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s ",rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
				System.out.println();

				
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void fetchData(int id) {
		
		ConnectionTest1 connectionTest1=new ConnectionTest1();
	try {
		Connection	connection=connectionTest1.getConnection();
	PreparedStatement	ps1=connection.prepareStatement("select * from userdata where userId=?");
	ps1.setInt(1, id);
ResultSet rs1=ps1.executeQuery();
	System.out.println("-----------------------------------------------------------------------------------------------------------");
	System.out.printf("%-12s %-15s %-15s %-15s %-15s %-15s %-15s","userId","user_name","product_1","product2","product_3","product_4","product_5");
	System.out.println();
	System.out.println("------------------------------------------------------------------------------------------------------------");
	while (rs1.next()) {
	System.out.printf( "%-12d %-15s %-15s %-15s %-15s %-15s %-15s",rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getString(6),rs1.getString(7));
	System.out.println();
	}
	System.out.println("---------------------------------------------------------------------------------------------");
connection.close();
	ps1.close();
	rs1.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
