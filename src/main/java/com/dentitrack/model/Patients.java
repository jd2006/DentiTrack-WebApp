package com.dentitrack.model;

import java.time.LocalDate;

public class Patients extends Users {
    private int patientId;
    private String address;
    private String medicalHistory;
    private LocalDate DOB;
    private String allergy;
    private int age; // Added age attribute

    // Constructor
    public Patients(int userId, String firstName, String lastName, String email, String contactNo, int isActive, String username, String password, String userType, int patientId, String address, String medicalHistory, LocalDate DOB, String allergy, int age) {
        super(userId, firstName, lastName, email, contactNo, isActive, username, password, userType);
        this.patientId = patientId;
        this.address = address;
        this.medicalHistory = medicalHistory;
        this.DOB = DOB;
        this.allergy = allergy;
        this.age = age; // Initialize age attribute
    }

    // Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
