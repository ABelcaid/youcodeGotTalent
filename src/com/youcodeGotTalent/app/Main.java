package com.youcodeGotTalent.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.youcodeGotTalent.controller.AdminController;
import com.youcodeGotTalent.models.AdminSession;
import com.youcodeGotTalent.validation.Validation;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner scanner = new Scanner(System.in);

		boolean firstMenu = true;
		// Display the title of the chosen module
		while (firstMenu) {
			System.out.println("+-------------------------+ :");
			System.out.println("| You Welcome in Our Application|");
			System.out.println("+-------------------------+ :");
			System.out.println("1\t  Admin Only");
			System.out.println("2\t  Exit");

			System.out.println("Choix :");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				boolean secondMenu = true;
				while (secondMenu) {

					// Display the menu
					System.out.println("1\t Login");
					System.out.println("2\t Find All Users ");
					System.out.println("3\t Find Participations");
					System.out.println("4\t Find Participations By Email");
					System.out.println("5\t Validate Participation");
					System.out.println("6\t Logout");

					System.out.println("\n Please enter your choice:");

					AdminController adminController = new AdminController();
					Validation validation = new Validation();

					// Get user's choice
					int choice2 = scanner.nextInt();
					switch (choice2) {

					case 1:

						System.out.println("Please enter your Email \n");
						String adminEmail = scanner.next();
						System.out.println("Please enter your Password \n");
						String adminPassword = scanner.next();

//						Validation validation = new Validation();

						if (validation.emailValidation(adminEmail) == false
								|| validation.passwordValidation(adminPassword) == false) {
							System.out.println("Invalid  Email/Password  \n");

						} else {

//							System.out.println("valid \n");

							try {
								adminController.adminConnect(adminEmail, adminPassword);
								System.out.println("Hi Ahmed \n");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						break;

					case 2:
						// Check If The Admin is Logged
						try {

							if (adminController.checkAdminIsLogged()) {
								System.out.println("Connected \n");

								try {
//							ArrayList<User> listUsers = adminMethod.findAllUser();
									System.out.println(adminController.findAllUser());

								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else {
								System.out.println("You are not Connected \n");

							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						break;
					case 3:
						// Check If The Admin is Logged
						try {

							if (adminController.checkAdminIsLogged()) {

								try {
									System.out.println(adminController.findParticipation());

								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else {
								System.out.println("You are not Connected \n");

							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						break;
					case 4:
						// Check If The Admin is Logged
						try {

							if (adminController.checkAdminIsLogged()) {

								System.out.println("Insert the email to find particcipation \n");
								String userEmail = scanner.next();
								System.out.println(adminController.findParticipationByUserEmail(userEmail));

							} else {
								System.out.println("You are not Connected \n");

							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;

					case 5:
						// Check If The Admin is Logged
						try {

							if (adminController.checkAdminIsLogged()) {

								System.out.println("Please enter User Id \n");
								long userID = scanner.nextLong();
								System.out.println("Please enter Category ID \n");
								long idCategory = scanner.nextLong();

								adminController.validateParticipation(userID, idCategory);

							} else {
								System.out.println("You are not Connected \n");

							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 6:
						// Check If The Admin is Logged
						try {

							if (adminController.checkAdminIsLogged()) {
								AdminSession adminSession = new AdminSession();
								adminSession.adminDeconnection();
								System.out.println("Logout .....\n");

								secondMenu = false;

							} else {
								System.out.println("You are not Connected \n");

							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						break;
					default:
						System.out.println("Invalid choice");
					}// end of switch
				}
				break;
			}
		}
	}
}
