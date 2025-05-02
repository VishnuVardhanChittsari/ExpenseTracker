package com.example.Expense_Tracker.service;

import java.time.LocalDate;
import java.util.List;

import com.example.Expense_Tracker.model.Expense;
import com.example.Expense_Tracker.model.User;
import com.example.Expense_Tracker.util.JPAutil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;



public class ExpenseService {

	public void addExpense(int userId, String category, double amount, String description) {
			EntityManager entityManager = JPAutil.getentitymanager();
			EntityTransaction transaction = entityManager.getTransaction();

  try {
      transaction.begin();

      // Fetch the User from the database using the userId
      User user = entityManager.find(User.class, userId);
      
      if (user == null) {
          System.out.println("❌ User not found!");
          return;
      }

      // Create and set the Expense details
      Expense expense = new Expense();
      expense.setCategory(category);
      expense.setAmount(amount);
      expense.setDescription(description);
      expense.setDate(LocalDate.now()); 
      expense.setUser(user); 

      // Save the expense in the database
      entityManager.persist(expense);

      transaction.commit();
      System.out.println("✅ Expense added successfully!");
  } catch (Exception e) {
      transaction.rollback();
      System.out.println("❌ Error while adding expense: " + e.getMessage());
  } finally {
      entityManager.close();
  }
}
	

	
	
	public List<Expense> getExpensesByUserIdAndDate(int userid,LocalDate date){
		EntityManager em = JPAutil.getentitymanager();
		
		String jpql="select e from Expense e where e.user.id=:userid and e.date=:date";
        TypedQuery<Expense> query = em.createQuery(jpql, Expense.class);
        query.setParameter("userid", userid);
        query.setParameter("date", date);
        return query.getResultList();

	}
	
	public List<Expense> getExpensesByUserId(int userid){
		EntityManager em = JPAutil.getentitymanager();
		
		String jpql="select e from Expense e where e.user.id=:userid";
        TypedQuery<Expense> query = em.createQuery(jpql, Expense.class);
        query.setParameter("userid", userid);
        return query.getResultList();

	}
	
	




	public static void updateExpenseById(Long expenseId, String newCategory, double newAmount, String newDesc) {
		EntityManager em = JPAutil.getentitymanager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			
			
			
       Expense expense=em.find(Expense.class, expenseId);
       
       
       
       
       if (expense == null) {
           throw new RuntimeException("Expense not found with ID: " + expenseId);
       }
       expense.setAmount(newAmount);
       expense.setCategory(newCategory);
       expense.setDescription(newDesc);
       et.commit();
		}
       catch (Exception e) {
           if (et.isActive()) {
               et.rollback();
           }
           e.printStackTrace();
       } finally {
           em.close();
		
	}
}









	public double count(long userid, LocalDate sdate, LocalDate edate) {
     
		EntityManager em = JPAutil.getentitymanager();
		
		
		String jpql="select sum(amount) from Expense e where e.user.id= :userid and e.date between :sdate and :edate";
				TypedQuery<Double> query = em.createQuery(jpql, Double.class);
	    query.setParameter("userid", userid);		
        query.setParameter("sdate", sdate);
        query.setParameter("edate", edate);	
        double c=query.getSingleResult();
        
				return c;
	}




	public String deleteaccount(int userid) {
		
		EntityManager em = JPAutil.getentitymanager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		Query deleteExpense=em.createQuery("delete from Expense e WHERE e.user.id = :userid");
		deleteExpense.setParameter("userid",userid);
		
		deleteExpense.executeUpdate();
		
		 Query deleteUser =em.createQuery("DELETE FROM User u WHERE u.id = :userId");
		  deleteUser.setParameter("userId", userid);
		     deleteUser.executeUpdate();

		    et.commit();
		    em.close();

		return "account deleted";
	}
	
}




































