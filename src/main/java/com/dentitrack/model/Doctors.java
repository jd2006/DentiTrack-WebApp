package com.dentitrack.model;

public class Doctors extends Users {
    private String specialty;
    private String licenseNumber;

    // Constructor
    public Doctors(int userId, String firstName, String lastName, String email, String contactNo,int isActive, String username, String password, String userType, String specialty, String licenseNumber) {
        super(userId, firstName, lastName, email, contactNo, isActive, username, password, userType);
        this.specialty = specialty;
        this.licenseNumber = licenseNumber;
    }
    
    

    public Doctors() {
		super();
	}



	public Doctors(int userId, String firstName, String lastName, String email, String contactNo, int isActive,
			String username, String password, String userType) {
		super(userId, firstName, lastName, email, contactNo, isActive, username, password, userType);
		// TODO Auto-generated constructor stub
	}



	// Getters and Setters
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
