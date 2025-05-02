package com.example.Expense_Tracker.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAutil {
	
	private static final EntityManagerFactory emf;

	static {
		emf=Persistence.createEntityManagerFactory("expense_tracker");
		
	}
	
	public static EntityManager getentitymanager() {
		return emf.createEntityManager();
	}
	
	 public static void close() {
	        if (emf != null && emf.isOpen()) {
	            emf.close();
	        }
	
}
}
