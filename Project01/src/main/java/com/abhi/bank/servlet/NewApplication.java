package com.abhi.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abhi.bank.hibernate.HibernetUtil01;
import com.abhi.bank.model.Coustmer;


/**
 * Servlet implementation class NewApplication
 */
public class NewApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewApplication() {
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
	
	    Coustmer a = new Coustmer();
		a.setName(request.getParameter("name"));
		a.setMobno(request.getParameter("mobno"));
		a.setEmail(request.getParameter("email"));
		a.setAdhar(request.getParameter("adhar"));
		a.setPan(request.getParameter("pan"));
		a.setPass(request.getParameter("pass"));
		a.setBal(Integer.parseInt(request.getParameter("bal")));
		
		Session session = HibernetUtil01.getSessionFactory().openSession();
		      Transaction tx = session.beginTransaction();
		 	    session.save(a);
		 	     tx.commit();
		 	    PrintWriter out=response.getWriter();
				out.println("<html>"
					+ "<head><title>Your Application Successfully Submited</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>Your Application Successfully Submited</h1>"
					+"<a href=\"index.html\"><button>Home Page</button></a>"
					+ "</body>"
					+ "</html>");
				
				session.close();
				
	}

}
