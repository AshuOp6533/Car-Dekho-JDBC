package com.jspiders.cardekho.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateCar {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	public void updatingCar(Scanner scanner) {
		System.out.println("Enter the id of car");
		int id = scanner.nextInt();
		System.out.println("Enter the updated price of car");
		double price = scanner.nextDouble();
		
		try {
			openConnection();
			
			query = "UPDATE  car SET price = ? WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, price);
			preparedStatement.setInt(2, id);
			int res = preparedStatement.executeUpdate();
			
			if (res == 1) {
				System.out.println("Price of car Updated");
			}
			else {
				System.out.println("car not found");
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

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root", "root");
	}

	private static void closeConnection() throws SQLException {

		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}

	}
}
