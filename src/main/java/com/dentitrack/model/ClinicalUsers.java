package com.dentitrack.model;

public class ClinicalUsers extends Users {
	private String designation; // Changed from department to designation

	// Constructor
	public ClinicalUsers(int userId, String firstName, String lastName, String email, String contactNo,int isActive, String username,
			String password, String userType, String designation) {
		super(userId, firstName, lastName, email,contactNo, isActive, username, password, userType);
		this.designation = designation; // Initialize designation attribute
	}

	// Getters and Setters
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
