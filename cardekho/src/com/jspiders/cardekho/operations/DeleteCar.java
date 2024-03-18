package com.jspiders.cardekho.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteCar {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	public void deletingCarById(Scanner scanner) {
		System.out.println("Enter the id of car");
		int id = scanner.nextInt();
		
		try {
			openConnection();
			query = "DELETE FROM car WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int res = preparedStatement.executeUpdate();
			if(res > 0) {
				System.out.println("Car info deleted");
			}
			else {
				System.out.println("No car found enter valid id");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deletingCarByName(Scanner scanner) {
		System.out.println("Enter the name of car");
		String name = scanner.next();
		
		try {
			openConnection();
			query = "DELETE FROM car WHERE name = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			int res = preparedStatement.executeUpdate();
			if(res > 0) {
				System.out.println("Car info deleted");
			}
			else {
				System.out.println("No car found enter valid id");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root","root");
	}
	
	private static void closeConnection() throws SQLException {
		if(preparedStatement != null) {
			preparedStatement.close();
		}
		if(connection != null) {
			connection.close();
		}
	}
}
