package com.dentitrack.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointments {
	private int appointmentId;
	private LocalDate date;
	private LocalTime time;
	//private LocalTime endTime;
	private int isActive;
	private int doctorId;
	private int patientId;
	private int reminderSent;

	// Default constructor
	public Appointments() {
	}

	// Parameterized constructor
	public Appointments(int appointmentId, LocalDate date, LocalTime startTime, LocalTime endTime, int isActive,
			int doctorId, int patientId, int reminderSent) {
		this.appointmentId = appointmentId;
		this.date = date;
		this.time = startTime;
		//this.endTime = endTime;
		this.isActive = isActive;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.reminderSent = reminderSent;
	}

	// Getters and Setters
	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getStartTime() {
		return time;
	}

	public void setStartTime(LocalTime startTime) {
		this.time = startTime;
	}

	/*
	 * public LocalTime getEndTime() { return endTime; }
	 * 
	 * public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
	 */

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getReminderSent() {
		return reminderSent;
	}

	public void setReminderSent(int reminderSent) {
		this.reminderSent = reminderSent;
	}
}
