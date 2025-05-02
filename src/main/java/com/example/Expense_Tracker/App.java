package com.example.Expense_Tracker;

import java.util.Scanner;

import com.example.Expense_Tracker.model.User;
import com.example.Expense_Tracker.service.Index;
import com.example.Expense_Tracker.service.Operations;





public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);


    	
    	Index index=new Index();
    	User main=index.authenticateUser();
    	
    	 if (main == null) {
             System.out.println("Exiting application.");
             return;
         }
    	 
          
    	 //get user id 
         int userid = main.getId();
         
         

        Operations ops=new Operations();
        ops.ServiceOperations(userid);
 
        
        	
        
        }
    }
    

    
    


