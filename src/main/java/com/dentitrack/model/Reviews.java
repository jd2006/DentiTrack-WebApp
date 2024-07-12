package com.dentitrack.model;

public class Reviews {
    private int reviewId;
    private int patientId;
    private String patientName;
    private int starRating; // 1 to 5
    private String reviewRemark;

    // Constructor
    public Reviews(int reviewId, int patientId, String patientName, int starRating, String reviewRemark) {
        this.reviewId = reviewId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.starRating = starRating;
        this.reviewRemark = reviewRemark;
    }

    // Default Constructor
    public Reviews() {}

    // Getters and Setters
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
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

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public String getReviewRemark() {
        return reviewRemark;
    }

    public void setReviewRemark(String reviewRemark) {
        this.reviewRemark = reviewRemark;
    }
}
