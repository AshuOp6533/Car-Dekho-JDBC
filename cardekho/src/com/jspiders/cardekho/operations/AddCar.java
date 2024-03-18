package com.jspiders.cardekho.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddCar {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static String query;

    public void addingCar(Scanner scanner) {
        System.out.println("Enter how many cars do you want to add");
        int count = scanner.nextInt();

        try {
            openConnection();

            for (int i = 0; i < count; i++) {
                System.out.println("Enter the id");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the name of car");
                String name = scanner.nextLine();
                System.out.println("Enter the price of the car");
                double price = scanner.nextDouble();
                System.out.println("Enter the model year of car");
                int model = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the color of car");
                String color = scanner.nextLine();
                System.out.println("Enter the Transmission type of car");
                String transmissionType = scanner.nextLine();
                System.out.println("Enter the no. of doors of car");
                String noOfDoors = scanner.nextLine();

                query = "INSERT INTO car VALUES(?,?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setDouble(3, price);
                preparedStatement.setInt(4, model);
                preparedStatement.setString(5, color);
                preparedStatement.setString(6, transmissionType);
                preparedStatement.setString(7, noOfDoors);
                preparedStatement.execute();
            }
            System.out.println("Car(s) added successfully");
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
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
