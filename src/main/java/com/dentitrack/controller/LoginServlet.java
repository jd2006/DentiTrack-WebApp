package com.dentitrack.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
		
		//JDBC connection
		try {
			conn = DatabaseUtil.getConnection();
            st = conn.createStatement();
            String query = "SELECT * FROM userids WHERE user_name = '" + username + "' AND password = '" + password + "'";
            rs = st.executeQuery(query);
			
			if(rs.next()) {
				out.print("Valid");
			}
			else {
				out.print("Not Valid");
			}
		} catch (SQLException e) {
			out.print("Error SQLException");
			e.printStackTrace();
		} finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                DatabaseUtil.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
//		out.print("User Name : " + username);
//		out.print("Password : " + password);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
