package com.example.Expense_Tracker.service;

import java.util.Scanner;

import com.example.Expense_Tracker.model.User;

public class Index {

    public User authenticateUser() {
        Scanner sc = new Scanner(System.in);
        
        UserService userservice = new UserService();
        
        System.out.println("=== Welcome to Expense Tracker ===");
        int userid = 0;
        
        while (userid <= 0) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Register User");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 
            
            switch(choice) {
                case 1:
                    System.out.println("Enter username:");
                    String username = sc.nextLine();
                    
                    System.out.println("Enter password:");
                    String userpassword = sc.nextLine();
                    
                    if (userservice.isUsernameTaken(username)) {
                        System.out.println("Username already taken. Please choose a different one.");
                        break;
                    }
                    
                    User newuser = new User();
                    newuser.setUsername(username);
                    newuser.setPassword(userpassword);
                    
                    userservice.createUser(newuser);
                    break;
                    
                case 2:
                    System.out.println("Enter username:");
                    String loginUsername = sc.nextLine();
                    
                    System.out.println("Enter password:");
                    String loginUserPassword = sc.nextLine();
                    
                    User existinguser = userservice.login(loginUsername);
                    if (existinguser != null && existinguser.getPassword().equals(loginUserPassword)) {
                        userid = existinguser.getId();
                        username = existinguser.getUsername();
                        
                        System.out.println("Welcome " + username + "!");
                        return existinguser;
                    } else {
                        System.out.println("Invalid credentials, please try again!");
                    }
                    break;
                    
                case 3:
                    System.out.println("Exiting...");
                    return null;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        
        sc.close();
		return null; 
    }
}

