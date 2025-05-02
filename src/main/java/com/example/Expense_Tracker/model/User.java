package com.example.Expense_Tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@NotNull
@Size(min=6,max=14)
private String username;
//@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
@NotNull
//message = "Password must be at least 8 characters long, contain one uppercase letter, one lowercase letter, one digit, and one special character")
private String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int id, @NotNull @Size(min = 6, max = 14) String username, @NotNull String password) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
}




}
