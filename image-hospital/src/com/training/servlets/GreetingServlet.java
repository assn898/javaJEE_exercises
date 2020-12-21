package com.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entity.Doctor;

/**
 * Servlet implementation class GreetingServlet
 */
@WebServlet({ "/GreetingServlet", "/greet" })
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GreetingServlet() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Constructor called=============");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println(request.getClass().getName());
		System.out.println(response.getClass().getName());

		PrintWriter writer = response.getWriter();

		//		response.setContentType("text/html");
		//		
		//		writer.println("<h1 style='text-align:center;'>Our Specialists</h1>");

		request.setAttribute("heading", "Our Specialists");

		RequestDispatcher dispatcher = request.getRequestDispatcher("showDoctor.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		Doctor newDoctor = new Doctor();
		
		newDoctor.setDoctorName(request.getParameter("doctorName")); 
		newDoctor.setDoctorId(Integer.parseInt(request.getParameter("doctorId")));
		newDoctor.setMobileNumber(Long.parseLong((request.getParameter("mobileNumber"))));
		newDoctor.setSpecialization((request.getParameter("specialization")));
		newDoctor.setDateOfBirth(LocalDate.parse(request.getParameter("dateOfBirth")));
		
		
		
		
		
		request.setAttribute("doctorId", newDoctor.getDoctorId());
		request.setAttribute("doctorName", newDoctor);
		request.setAttribute("mobileNumber", newDoctor.getMobileNumber());
		request.setAttribute("specialization", newDoctor.getSpecialization());
		request.setAttribute("dateOfBirth", newDoctor.getDateOfBirth());

		RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		
		dispatcher.forward(request, response);
		
		
		System.out.println(newDoctor);
	}

}
