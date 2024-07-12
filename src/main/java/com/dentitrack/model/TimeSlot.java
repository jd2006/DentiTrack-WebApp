package com.dentitrack.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeSlot {

	  private final int slotId;
	  private final LocalDate date;
	  private final LocalTime time; // Using LocalTime for time representation
	  private int isBooked;

	  public TimeSlot(int slotId, LocalDate date, LocalTime time) {
	    this.slotId = slotId;
	    this.date = date;
	    this.time = time;
	    this.isBooked = 0; // Default to not booked
	  }
	  
	  // Constructor with isBooked
	  public TimeSlot(int slotId, LocalDate date, LocalTime time, int isBooked) {
		    this.slotId = slotId;
		    this.date = date;
		    this.time = time;
		    this.isBooked = isBooked; 
		  }

	  public int getSlotId() {
	    return slotId;
	  }

	  public LocalDate getDate() {
	    return date;
	  }

	  public LocalTime getTime() {
	    return time;
	  }

	  public int isBooked() {
	    return isBooked;
	  }

	  public void setBooked(int booked) {
	    this.isBooked = booked;
	  }

	  @Override
	  public String toString() {
	    return "TimeSlot{" +
	        "slotId=" + slotId +
	        ", date=" + date +
	        ", time=" + time +
	        ", isBooked=" + isBooked +
	        '}';
	  }
	}

