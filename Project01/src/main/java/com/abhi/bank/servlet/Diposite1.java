package com.abhi.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class Diposite1
 */
public class Diposite1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Diposite1() {
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
		int diposite= Integer.parseInt(request.getParameter("diposite"));
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
		  
          Transaction transaction = session.beginTransaction();
          Coustmer s1 = session.get(Coustmer.class,username);
          int balance= s1.getBal()+diposite;
         s1.setBal(balance);
 	     session.update(s1);
	      transaction.commit();
          
			
			
			
				/*RequestDispatcher rd = request.getRequestDispatcher("empsuccess.html");
				rd.forward(request, response);*/
				
	      RequestDispatcher rd = request.getRequestDispatcher("diposite.html");
			//rd.forward(request, response);
			//System.out.println("Invalid Crediential");
			
			PrintWriter out=response.getWriter();
			out.println("<html>"
				+ "<head><title>Your Money Is Diposited SuccessFully </title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>Your "+diposite+" is Added Successfully Current Account balance ="+balance+"</h1>"
				+ "</body>"
				+ "</html>");
			rd.include(request, response);
			
		
		session.close();
	}

}
