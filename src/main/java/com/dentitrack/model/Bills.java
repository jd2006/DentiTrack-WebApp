package com.dentitrack.model;

import java.time.LocalDate;

public class Bills {
    private int billId;
    private LocalDate billDate;
    private String treatmentCode;
    private String treatmentName;
    private double treatmentCharge;
    private int isPaid; // 0 for unpaid, 1 for paid
    private int patientId;
    private String patientName;
    private String doctorName;
    private double professionalFee;
    private double totalAmount;

    // Constructor
    public Bills(int billId, LocalDate billDate, String treatmentCode, String treatmentName, double treatmentCharge, int isPaid, int patientId, String patientName, String doctorName, double professionalFee, double totalAmount) {
        this.billId = billId;
        this.billDate = billDate;
        this.treatmentCode = treatmentCode;
        this.treatmentName = treatmentName;
        this.treatmentCharge = treatmentCharge;
        this.isPaid = isPaid;
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.professionalFee = professionalFee;
        this.totalAmount = totalAmount;
    }

    // Default Constructor
    public Bills() {}

    // Getters and Setters
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
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

    public double getTreatmentCharge() {
        return treatmentCharge;
    }

    public void setTreatmentCharge(double treatmentCharge) {
        this.treatmentCharge = treatmentCharge;
    }

    public int getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(int isPaid) {
        this.isPaid = isPaid;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public double getProfessionalFee() {
        return professionalFee;
    }

    public void setProfessionalFee(double professionalFee) {
        this.professionalFee = professionalFee;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
