package com.jspiders.cardekho.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectCar {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static ResultSet resultSet;

	public void searchCarById(Scanner scanner) {

		System.out.println("Enter id of the car");
		int id = scanner.nextInt();

		try {
			openConnection();
			query = "SELECT * FROM car WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getDouble(3));
				System.out.println(resultSet.getInt(4));
				System.out.println(resultSet.getString(5));
				System.out.println(resultSet.getString(6));
				System.out.println(resultSet.getInt(7));

			} else {
				System.out.println("User not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void searchCarByName(Scanner scanner) {

		System.out.println("Enter name of the car");
		String name = scanner.next();

		try {
			openConnection();
			query = "SELECT * FROM car WHERE name = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getDouble(3));
				System.out.println(resultSet.getInt(4));
				System.out.println(resultSet.getString(5));
				System.out.println(resultSet.getString(6));
				System.out.println(resultSet.getInt(7));

			} else {
				System.out.println("User not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void searchCarByColor(Scanner scanner) {

		System.out.println("Enter color of the car");
		String color = scanner.next();

		try {
			openConnection();
			query = "SELECT * FROM car WHERE color = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, color);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getDouble(3));
				System.out.println(resultSet.getInt(4));
				System.out.println(resultSet.getString(5));
				System.out.println(resultSet.getString(6));
				System.out.println(resultSet.getInt(7));

			} else {
				System.out.println("User not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void searchCarByTransmissionType(Scanner scanner) {
		System.out.println("Enter transmission type of the car");
		String transmissionType = scanner.next();

		try {
			openConnection();
			query = "SELECT * FROM car WHERE transmission_type = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, transmissionType);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1)); // ID
				System.out.println(resultSet.getString(2)); // Name
				System.out.println(resultSet.getDouble(3)); // Price
				System.out.println(resultSet.getInt(4)); // Year
				System.out.println(resultSet.getString(5)); // Color
				System.out.println(resultSet.getInt(6)); // Mileage
				System.out.println(resultSet.getString(7)); // Transmission type
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		if (resultSet != null) {
			resultSet.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}
