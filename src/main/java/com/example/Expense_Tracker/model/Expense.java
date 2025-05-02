package com.example.Expense_Tracker.model;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Expense {


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    private String category;
	    private double amount;
	    private String description;
	    private LocalDate date=LocalDate.now();

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Expense(long id, String category, double amount, String description, LocalDate date, User user) {
			super();
			this.id = id;
			this.category = category;
			this.amount = amount;
			this.description = description;
			this.date = date;
			this.user = user;
		}

		public Expense() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Expense [id=" + id + ", category=" + category + ", amount=" + amount + ", description="
					+ description + ", date=" + date + ", user=" + user + "]";
		}

	    
	
}
