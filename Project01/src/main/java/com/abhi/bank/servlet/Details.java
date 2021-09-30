package com.abhi.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abhi.bank.hibernate.HibernetUtil01;
import com.abhi.bank.model.Coustmer;

/**
 * Servlet implementation class Details
 */
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();
		if(s.getAttribute("id")==null)
		{
			PrintWriter out=response.getWriter();
			out.println("<html>"
					+ "<head>"
					+ "    <title>Employee Page</title>"
					+ "</head>"
					+ "<body>"
					+ ""
					+ "    <div>"
					+ "            <h1>Session Expire ... Plz login Again</h1>"
					+ "             <a href=\"index.html\"><button>Home Page</button></a>"
					+ "    </div>"
					+ ""
					+ "</body>"
					+ ""
					+ "</html>");
		}
		int username=(int)s.getAttribute("id");
		Session session = HibernetUtil01.getSessionFactory().openSession();
		Coustmer s1 = session.get(Coustmer.class,username);
        
        PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>"
				+ "<html lang=\"en\">"
				+ "<head>"
				+ "  <title>Bootstrap Example</title>"
				+ "  <meta charset=\"utf-8\">"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
				+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">"
				+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>"
				+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>"
				+ "</head>"
				+ "<body>"
				+ ""
				+ "<div class=\"container\">"
				+ "  <h2>Your Details</h2>"
				+ "  <table class=\"table\">"
				+ "    <tbody>"
				+ "      <tr>"
				+ "        <td>Account No</td>"
				+ "        <td>"+s1.getCoustid()+"</td>"
				+ "      </tr>      "
				+ "      <tr class=\"success\">"
				+ "        <td>Name</td>"
				+ "        <td>"+s1.getName()+"</td>"
				+ "      </tr>"
				+ "      <tr class=\"danger\">"
				+ "        <td>Balance</td>"
				+ "        <td>"+s1.getBal()+"</td>"
				+ "      </tr>"
				+ "      <tr class=\"info\">"
				+ "        <td>Email</td>"
				+ "        <td>"+s1.getEmail()+"</td>"
				+ "      </tr>"
				+ "      <tr class=\"warning\">"
				+ "        <td>Mobile No</td>"
				+ "        <td>"+s1.getMobno()+"</td>"
				+ "      </tr>"
				+ "      <tr class=\"active\">"
				+ "        <td>Adhar</td>"
				+ "        <td>"+s1.getAdhar()+"</td>"
				+ "      </tr>"
				+ "    </tbody>"
				+ "  </table>"
				+ "</div>"
				+ "<a href=\"CoustOperation.html\">Back </a>"
				+ "</body>"
				+ "</html>"
				+ "");
     
       
	     
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
