package com.dentitrack.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.dentitrack.model.TimeSlot;
import com.dentitrack.util.DatabaseUtil;


//@WebServlet("/GetTimeSlotsServlet")
public class GetTimeSlotsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetTimeSlotsServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String selectedDate = request.getParameter("date");
		List<TimeSlot> availableTimeSlots = getTimeSlotsFromDatabase(selectedDate); // Implement this method
		
		try (PrintWriter out = response.getWriter()) {
            out.println(toJson(availableTimeSlots)); // Convert List<TimeSlot> to JSON array
        }
	}

	private String toJson(List<TimeSlot> timeSlots) {
		
		StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < timeSlots.size(); i++) {
            TimeSlot slot = timeSlots.get(i);
            json.append("{");
            json.append("\"time\": \"").append(slot.getTime()).append("\"");
            json.append("}");
            if (i < timeSlots.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
		
	}


	private List<TimeSlot> getTimeSlotsFromDatabase(String selectedDate) {
		List<TimeSlot> timeSlots = new ArrayList<>();
		String query = "SELECT slot_id, date, slot_time, is_booked FROM timeslots WHERE date = ? AND is_booked = 0";
		try (Connection conn = DatabaseUtil.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {

	            ps.setString(1, selectedDate);
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    int slotId = rs.getInt("slot_id");
	                    LocalDate date = rs.getDate("date").toLocalDate();
	                    LocalTime slotTime = rs.getTime("slot_time").toLocalTime();
	                    int isBooked = rs.getInt("is_booked");

	                    TimeSlot timeSlot = new TimeSlot(slotId, date, slotTime,isBooked);
	                    timeSlots.add(timeSlot);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return timeSlots;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
