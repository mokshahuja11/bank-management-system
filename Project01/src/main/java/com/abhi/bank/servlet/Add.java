package com.abhi.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abhi.bank.hibernate.HibernetUtil01;
import com.abhi.bank.model.Coustmer;
import com.abhi.bank.model.Employee;

/**
 * Servlet implementation class Add
 */
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Employee e = new Employee();
			e.setName(request.getParameter("name"));
			e.setEmail(request.getParameter("email"));
			e.setPass(request.getParameter("pass"));
			Session session = HibernetUtil01.getSessionFactory().openSession();
			      Transaction tx = session.beginTransaction();
			 	    session.save(e);
			 	     tx.commit();
			 	     
			 	    RequestDispatcher rd = request.getRequestDispatcher("add.html");
					//rd.forward(request, response);
					//System.out.println("Invalid Crediential");
					
					PrintWriter out=response.getWriter();
					out.println("<html>"
						+ "<head><title>New Employee Added SuccessFully </title>"
						+ "</head>"
						+ "<body>"
						+ "<h1>New Employee Added Successfully </h1>"
						+ "</body>"
						+ "</html>");
					rd.include(request, response);
	}

}
