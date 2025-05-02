package com.example.Expense_Tracker.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.example.Expense_Tracker.model.Expense;

public class Operations {

	public void ServiceOperations(int userid) {
		 Scanner sc = new Scanner(System.in);
		 
		 ExpenseService expenseservice=new ExpenseService();
		 LocalDate date;
	    	
		 while(true) {
			
			        	 

			        System.out.println("Logged in user ID: " + userid);
			        System.out.println("\nChoose an option:");
			        System.out.println("1. add expense");
			        System.out.println("2. edit expense");
			        System.out.println("3. all expense");
			        System.out.println("4. expense by date");
			        System.out.println("5. total money spent");
			        System.out.println("6. logout");
			        System.out.println("7. Delete Account");
			        System.out.print("Enter your choice: ");
			        
			        int value=sc.nextInt();
			        sc.nextLine();
			        
			         switch(value) {
			        case 1:
			        	System.out.print("Enter category: ");
			            String category = sc.nextLine();
			            System.out.print("Enter amount: ");
			            double amount = Double.parseDouble(sc.nextLine());
			            System.out.print("Enter description: ");
			            String description = sc.nextLine();
			            System.out.println(userid);
			            expenseservice.addExpense(userid, category, amount, description);
			            break;
			        	
			            
			        case 2:
			        	System.out.print("Enter Date (YYYY-MM-DD): ");
			            date = LocalDate.parse(sc.next());
			        	
			            List<Expense> expense=expenseservice.getExpensesByUserIdAndDate(userid, date);
			        	
			            if (expense.isEmpty()) {
			                System.out.println("No expenses found.");
			                return;
			            }
			            
			            expense.forEach(e -> {
			                System.out.println("ID: " + e.getId() +
			                    ", Category: " + e.getCategory() +
			                    ", Amount: " + e.getAmount() +
			                    ", Description: " + e.getDescription());
			            });
			            System.out.print("Enter Expense ID to update: ");
			            
			            Long expenseId = sc.nextLong();
			            
			            sc.nextLine();
			            System.out.println("new category");
			            String newCategory=sc.nextLine();
			            
			            System.out.print("New Amount: ");
			            double newAmount = sc.nextDouble();
			            sc.nextLine();
			            System.out.print("New Description: ");
			             // consume leftover newline2
			            
			            String newDesc = sc.nextLine();
			            
			            ExpenseService.updateExpenseById(expenseId,newCategory, newAmount, newDesc);
			        	
			            System.out.println("updated-------");
			            break;
			            
			          
			        case 3:
			        	System.out.println("all expenses");
			            List<Expense> expensebyid=expenseservice.getExpensesByUserId(userid);
			            if (expensebyid.isEmpty()) {
			                System.out.println("No expenses found.");
			                return;
			            }
			            
			            expensebyid.forEach(e -> {
			                System.out.println("ID: " + e.getId() +
			                    ", Category: " + e.getCategory() +
			                    ", Amount: " + e.getAmount() +
			                    ", Description: " + e.getDescription());
			            });
			        	
			            break;
			            
			        case 4:
			        	System.out.println("expense by date");
			        	System.out.print("Enter Date (YYYY-MM-DD): ");
			            date = LocalDate.parse(sc.next()); 
			            
			            List<Expense> expensebydate=expenseservice.getExpensesByUserIdAndDate(userid, date);
			            if (expensebydate.isEmpty()) {
			                System.out.println("No expenses found.");
			                return;
			            }
			            
			            expensebydate.forEach(e -> {
			                System.out.println("ID: " + e.getId() +
			                    ", Category: " + e.getCategory() +
			                    ", Amount: " + e.getAmount() +
			                    ", Description: " + e.getDescription());
			            });
			            break;
			        	
			        	
			            
			        case 5:
			        	System.out.println("enter stat date and end date to get total money spent");
			        	System.out.println("start date: ");
			        	LocalDate Sdate=LocalDate.parse(sc.next());
			        	System.out.println("end date: ");
			        	LocalDate Edate=LocalDate.parse(sc.next());
			        	
                        double count=expenseservice.count(userid,Sdate,Edate);
                        
                        System.out.println(count);
			        	 break;
			        	
			        case 6:
			        	System.out.println("Logging out...");
			            return; // or break if you add login loop
			            
			        case 7:
			        	 expenseservice.deleteaccount(userid);
			        	
			        	 Index in=new Index();
			        	 in.authenticateUser();
			        }
			         
			       
			         
			         
			        
			        
			        	
			        
			        }
	}
	
	
}
