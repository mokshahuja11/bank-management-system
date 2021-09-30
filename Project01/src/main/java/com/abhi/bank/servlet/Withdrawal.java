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
 * Servlet implementation class Withdrawal
 */
public class Withdrawal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdrawal() {
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
		int flag=1;
		int with= Integer.parseInt(request.getParameter("with"));
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
		  int balance=0;
          Transaction transaction = session.beginTransaction();
          Coustmer s1 = session.get(Coustmer.class,username);
          if(with<=s1.getBal())
          {  
          balance= s1.getBal()-with;
         s1.setBal(balance);
 	     session.update(s1);
	      transaction.commit();
          }
          else
          {
        	  flag=0;
          }
          
			
			if(flag==1) {
			
				/*RequestDispatcher rd = request.getRequestDispatcher("empsuccess.html");
				rd.forward(request, response);*/
				
				 RequestDispatcher rd = request.getRequestDispatcher("withdrawal.html");
					//rd.forward(request, response);
					//System.out.println("Invalid Crediential");
					
					PrintWriter out=response.getWriter();
					out.println("<html>"
						+ "<head><title>Your Money Is Withdrawl SuccessFully </title>"
						+ "</head>"
						+ "<body>"
						+ "<h1>Your "+with+" is Withdrawal Successfully Current Account balance ="+balance+"</h1>"
						+ "</body>"
						+ "</html>");
					rd.include(request, response);
			}
			
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("withdrawal.html");
				//rd.forward(request, response);
				System.out.println("Invalid Crediential");
				
				PrintWriter out=response.getWriter();
				out.println("<html>"
					+ "<head><title>Invalid Withdrawal Ammount</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>Your Current Account balance ="+s1.getBal()+"</h1>"
					+ "</body>"
					+ "</html>");
				rd.include(request, response);
				System.out.println("Invalid Crediential");
			}
		
		session.close();
	}

}
