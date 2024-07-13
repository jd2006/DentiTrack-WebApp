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
import java.util.ArrayList;
import java.util.List;

import com.dentitrack.model.Doctors;
import com.dentitrack.util.DatabaseUtil;
import com.google.gson.Gson;  // to convert Java Objects into their JSON representation.

public class GetDoctorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public GetDoctorsServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		List<Doctors> doctors = getDoctorsFromDatabase();

		try (PrintWriter out = response.getWriter()) {
			Gson gson = new Gson();
			String json = gson.toJson(doctors);
			out.print(json);
		}
	}


	private List<Doctors> getDoctorsFromDatabase() {
		List<Doctors> doctors = new ArrayList<>();
		String query = "SELECT d.doctorId, u.userId, u.firstName, u.lastName, u.email, u.contactNo, u.isActive, u.username, u.password, u.userType, d.specialty, d.licenseNumber "
                + "FROM doctors d "
                + "JOIN users u ON d.userId = u.userId";

		try (Connection conn = DatabaseUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int userId = rs.getInt("userId");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String contactNo = rs.getString("contactNo");
                int isActive = rs.getInt("isActive");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String userType = rs.getString("userType");
                String specialty = rs.getString("specialty");
                String licenseNumber = rs.getString("licenseNumber");

                Doctors doctor = new Doctors(userId, firstName, lastName, email, contactNo, isActive, username, password, userType, specialty, licenseNumber);
                doctors.add(doctor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctors;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
