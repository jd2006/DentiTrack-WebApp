package com.dentitrack.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dentitrack.util.DatabaseUtil;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
		
		//JDBC connection
		try {
			conn = DatabaseUtil.getConnection();
            st = conn.createStatement();
            String query = "SELECT * FROM users WHERE email = '" + email + "' AND password_hash = '" + password + "'";
            rs = st.executeQuery(query);
			
			if(rs.next()) {
				String userType = rs.getString("user_type");
				
				// Set user session
                HttpSession session = request.getSession();
                session.setAttribute("user", email);
                session.setAttribute("userType", userType);
				
				switch (userType) {
                case "dentist":
                case "clinical_staff":
                    response.sendRedirect("ClinicalUser/StaffDashboard.html");
                    break;
                case "patient":
                    response.sendRedirect("Patient/patientDashboard.html");
                    break;
                default:
                	out.print("<script>alert('Something went wrong. Contact the admin.');window.location='login.html';</script>");
                    break;
				}
				
			}
			else {
				out.print("<script>alert('Incorrect username or password');window.location='login.html';</script>");
			}
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
            out.print("<script>alert('Something went wrong. Contact the admin.');window.location='login.html';</script>");
		} finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                DatabaseUtil.closeConnection(conn);
            } catch (SQLException e) {
            	System.err.println("SQLException while closing resources: " + e.getMessage());
            }
        }
		
//		out.print("User Name : " + username);
//		out.print("Password : " + password);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
