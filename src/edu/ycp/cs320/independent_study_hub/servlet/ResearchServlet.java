package edu.ycp.cs320.independent_study_hub.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Research Servlet: doGet");
		System.out.println("Request: " + req + " Response: " + resp);
		
		req.getRequestDispatcher("/_view/Research.jsp").forward(req, resp);
	}
	
	
}
