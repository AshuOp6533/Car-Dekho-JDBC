package com.jspiders.cardekho.main;

import java.util.Scanner;

import com.jspiders.cardekho.operations.AddCar;
import com.jspiders.cardekho.operations.DeleteCar;
import com.jspiders.cardekho.operations.SelectCar;
import com.jspiders.cardekho.operations.UpdateCar;

public class CarMain {
	static boolean flag = true;
	static DeleteCar deleteCar = new DeleteCar();
	static UpdateCar updateCar = new UpdateCar();
	static AddCar addCar = new AddCar();
	static SelectCar selectCar = new SelectCar();
	
	public static void main(String[] args) {
		mainMenu();
	}
	
	public static void mainMenu() {
	    Scanner scanner = new Scanner(System.in);
	    
	    while(flag) {
	        System.out.println("Enter 1 to add the car details");
	        System.out.println("Enter 2 to Search the car");
	        System.out.println("Enter 3 to update the car details");
	        System.out.println("Enter 4 to remove the car");
	        System.out.println("Enter 5 to Exit");

	        int choice = scanner.nextInt();

	        switch (choice) {
	            case 1:
	                addCar.addingCar(scanner);
	                break;
	            case 2:	   
	            	searchingCar();
	            	mainMenu();
	            	break;
	            case 3:
	            	updateCar.updatingCar(scanner);
	            	mainMenu();
	                break;
	            case 4:
	            	deletingCar();
	            	mainMenu();
	                break;
	            case 5:
	                System.out.println("Thank You!!!");
	                flag = false;
	                break;
	            default:
	                System.out.println("Enter valid choice");
	                break;
	        }
	    }
	    scanner.close();
	}
	private static void searchingCar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to search car by Id");
		System.out.println("Enter 2 to search car by name");
		System.out.println("Enter 3 to search car by color");
		System.out.println("Enter 4 to search car by Transmission Type");
		System.out.println("Enter 5 to Exit");
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
			selectCar.searchCarById(scanner);
			break;
		case 2:
			selectCar.searchCarByName(scanner);
			break;
		case 3:
			selectCar.searchCarByColor(scanner);
			break;
		case 4:
			selectCar.searchCarByTransmissionType(scanner);
			break;
		case 5:
			System.out.println("Thank You!!!");
//			flag = false;
            break;
		default:
			System.out.println("Enter valid choice");
            break;
		}

	}
	private static void deletingCar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 if you want to delete car by Id ");
		System.out.println("Enter 2 if you want to delete car by name ");
		System.out.println("Enter 3 to Exit");
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
			deleteCar.deletingCarById(scanner);
			break;
		case 2:
			deleteCar.deletingCarByName(scanner);
			break;
		case 3:
			System.out.println("Thank You!!!");
//			flag = false;
            break;

		default:
			System.out.println("Enter valid choice");
			break;
		}

	}

}
