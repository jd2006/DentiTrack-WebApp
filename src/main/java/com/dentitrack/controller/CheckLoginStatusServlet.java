package com.dentitrack.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.google.gson.JsonObject;


public class CheckLoginStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckLoginStatusServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		HttpSession session = request.getSession(false);
		JsonObject jsonResponse = new JsonObject();

		if (session != null && session.getAttribute("user") != null) {
			jsonResponse.addProperty("loggedIn", true);
			jsonResponse.addProperty("user", (String) session.getAttribute("user"));
			jsonResponse.addProperty("userType", (String) session.getAttribute("userType"));
		} else {
			jsonResponse.addProperty("loggedIn", false);
		}

		response.getWriter().write(jsonResponse.toString());

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
