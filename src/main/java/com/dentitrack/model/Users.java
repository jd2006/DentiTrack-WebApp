package com.dentitrack.model;

public class Users {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNo;
	private int isActive; // 0 for inactive, 1 for active
	private String password;
	private String userType; // "patient", "clinical_user", "doctor"

	// Constructor
	public Users(int userId, String firstName, String lastName, String email, String contactNo, int isActive, String password, String userType) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
		this.isActive = isActive;
		this.password = password;
		this.userType = userType;
	}

	// Default Constructor
	public Users() {
	}

	// Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
}
