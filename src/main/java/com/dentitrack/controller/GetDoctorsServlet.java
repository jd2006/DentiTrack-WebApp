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
		String query = "SELECT d.dentist_Id, u.first_Name, u.last_Name, u.email, u.contact_No, u.is_Active, u.password_hash, u.user_type, d.speciality "
                + "FROM dentists d "
                + "JOIN users u ON d.dentist_id = u.user_Id";

		try (Connection conn = DatabaseUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int userId = rs.getInt("dentist_Id");
                String firstName = rs.getString("first_Name");
                String lastName = rs.getString("last_Name");
                String email = rs.getString("email");
                String contactNo = rs.getString("contact_No");
                int isActive = rs.getInt("is_Active");
                String password = rs.getString("password_hash");
                String userType = rs.getString("user_type");
                String specialty = rs.getString("speciality");
             

                Doctors doctor = new Doctors(userId, firstName, lastName, email, contactNo, isActive, password, userType, specialty);
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
