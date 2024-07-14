package com.dentitrack.model;

public class Doctors extends Users {
    private String specialty;
 

    // Constructor
    public Doctors(int userId, String firstName, String lastName, String email, String contactNo,int isActive, String password, String userType, String specialty) {
        super(userId, firstName, lastName, email, contactNo, isActive, password, userType);
        this.specialty = specialty;
    }
    
    

    public Doctors() {
		super();
	}





	// Getters and Setters
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

}
