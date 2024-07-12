package com.dentitrack.model;

public class Questions {
    private int questionId;
    private String question;
    private int isAnswered; // 0 for unanswered, 1 for answered
    private String answer;
    private int patientId;
    private String patientName;

    // Constructor
    public Questions(int questionId, String question, int isAnswered, String answer, int patientId, String patientName) {
        this.questionId = questionId;
        this.question = question;
        this.isAnswered = isAnswered;
        this.answer = answer;
        this.patientId = patientId;
        this.patientName = patientName;
    }

    // Default Constructor
    public Questions() {}

    // Getters and Setters
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getIsAnswered() {
        return isAnswered;
    }

    public void setIsAnswered(int isAnswered) {
        this.isAnswered = isAnswered;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
}
