package com.abhi.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.abhi.bank.hibernate.HibernetUtil01;
import com.abhi.bank.model.Coustmer;
import com.abhi.bank.model.Employee;

/**
 * Servlet implementation class ViewEmployee
 */
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Session session = HibernetUtil01.getSessionFactory().openSession();
		List<Employee> results=session.createQuery("from Employee", Employee.class).list();
	   /*  for(Coustmer s: results)
	     {
	    	System.out.println(s);
	     }*/
		 PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE html>"
					+ "<html lang=\"en\">"
					+ "<head>"
					+ "  <title>Employee Details</title>"
					+ "  <meta charset=\"utf-8\">"
					+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
					+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">"
					+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>"
					+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>"
					+ "</head>"
					+ "<body>"
					+ ""
					+ "<div class=\"container\">"
					+ "  <h2>Online Bank Employee</h2>"
					+ "  <table class=\"table\">"
					+ "    <thead>"
					+ "      <tr>"
					+ "        <th>Id</th>"
					+ "        <th>Name</th>"
					+ "        <th>Email</th>"
					+ "      </tr>"
					+ "    </thead>"
					+ "    <tbody>");
			
			for(Employee s: results)
		     {
			out.println( "      <tr class=\"danger\">"
					+ "        <td>"+s.getEmpid()+"</td>"
					+ "        <td>"+s.getName()+"</td>"
					+ "        <td>"+s.getEmail()+"</td>"
					+ "      </tr>");
		     }	
					out.println( "    </tbody>"
					+ "  </table>"
					+ "</div>"
					+ "<a href=\"employeeOperation.html\">Back </a>"
					+ "</body>"
					+ "</html>"
					+ "");
	     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
