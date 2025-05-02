package com.example.Expense_Tracker.service;

import com.example.Expense_Tracker.model.User;
import com.example.Expense_Tracker.util.JPAutil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UserService {

	public void createUser(User user) {
		
		EntityManager em=JPAutil.getentitymanager();
		
		EntityTransaction et=em.getTransaction();
		try {
			et.begin();
			em.persist(user);
			et.commit();
			
		} catch (Exception e) {
			if(et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
		}
	    finally {
			em.close();
		}
	}
	
	
	
	public boolean isUsernameTaken(String username) {
	    EntityManager em = JPAutil.getentitymanager();
	    try {
	        return em.createQuery("SELECT COUNT(u) FROM User u WHERE u.username = :username", Long.class)
	                 .setParameter("username", username)
	                 .getSingleResult() > 0;
	    } finally {
	        em.close();
	    }
	}
	
	
	
	public User login(String username) {
        EntityManager em = JPAutil.getentitymanager();
        try {
        	return em.createQuery("select u from User u where u.username=:username",User.class)
        			 .setParameter("username", username)
        			 .getSingleResult();
        		
        }
        catch (Exception e) {
			e.printStackTrace();
			return null;
		}
        finally {
			em.close();
		}
        

	}
	
	
	
	
	 
	
	
	
}
