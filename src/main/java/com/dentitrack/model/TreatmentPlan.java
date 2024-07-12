package com.dentitrack.model;

public class TreatmentPlan {
    private int treatmentPlanId;
    private String treatmentCode;
    private String treatmentName;
    private String remarks;
    private String feedback;
    private int isActive; // 0 for inactive, 1 for active
    private int patientId;
    private String status; // "confirmed", "cancelled", "in progress"

    // Constructor
    public TreatmentPlan(int treatmentPlanId, String treatmentCode, String treatmentName, String remarks, String feedback, int isActive, int patientId, String status) {
        this.treatmentPlanId = treatmentPlanId;
        this.treatmentCode = treatmentCode;
        this.treatmentName = treatmentName;
        this.remarks = remarks;
        this.feedback = feedback;
        this.isActive = isActive;
        this.patientId = patientId;
        this.status = status;
    }

    // Default Constructor
    public TreatmentPlan() {}

    // Getters and Setters
    public int getTreatmentPlanId() {
        return treatmentPlanId;
    }

    public void setTreatmentPlanId(int treatmentPlanId) {
        this.treatmentPlanId = treatmentPlanId;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
