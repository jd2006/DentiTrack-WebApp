package com.dentitrack.model;

public class Treatment {
    private int treatmentId;
    private String treatmentCode;
    private String treatmentName;
    private double cost;
    private int isActive; // 0 for inactive, 1 for active

    // Constructor
    public Treatment(int treatmentId, String treatmentCode, String treatmentName, double cost, int isActive) {
        this.treatmentId = treatmentId;
        this.treatmentCode = treatmentCode;
        this.treatmentName = treatmentName;
        this.cost = cost;
        this.isActive = isActive;
    }

    // Default Constructor
    public Treatment() {}

    // Getters and Setters
    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getTreatmentCode() {
        return treatmentCode;
    }

    public void setTreatmentCode(String treatmentCode) {
        this.treatmentCode = treatmentCode;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
