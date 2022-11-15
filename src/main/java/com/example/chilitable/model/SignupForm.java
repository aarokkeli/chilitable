package com.example.chilitable.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SignupForm {	
	
	// Minimum length for username will be 5 characters and max 30 characters
	@NotEmpty
	@Size(min = 5, max = 30)
	private String username = "";

	// For password minimum 7 and max 30
	@NotEmpty
	@Size(min = 7, max = 30)
	private String password = "";

	@NotEmpty
	@Size(min = 7, max = 30)
	private String passwordCheck = "";

	// All registered users will be "USER" by default
	@NotEmpty
	private String role = "USER";

	// Getters and setters
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

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
