package com.abhi.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.abhi.bank.hibernate.HibernetUtil01;
import com.abhi.bank.model.Coustmer;
import com.abhi.bank.model.Employee;

/**
 * Servlet implementation class CoustmerLogin
 */
public class CoustmerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoustmerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int username= Integer.parseInt(request.getParameter("uname"));
		String password = request.getParameter("psw");
		Session session = HibernetUtil01.getSessionFactory().openSession();
		  
          Transaction transaction = session.beginTransaction();
          Coustmer s1 = session.get(Coustmer.class,username);
	      transaction.commit();
	     
          if(s1!=null)
		{
        	  boolean a= password.equals(s1.getPass());
        	  if(a)
        	  {
			HttpSession s = request.getSession();
			s.setAttribute("id",username);
			
        	  response.sendRedirect("CoustOperation.html");
        	  }
				/*RequestDispatcher rd = request.getRequestDispatcher("empsuccess.html");
				rd.forward(request, response);*/
				
			/*	PrintWriter out=response.getWriter();
				out.println("<html>"
						+ "<head>"
						+ "    <title>Coustmer Page</title>"
						+ "</head>"
						+ "<body>"
						+ ""
						+ "    <div>"
						+ "            <h1>Coustmer Login Successfully</h1>"
						+ "            <Table>"
						+ "                <tr>"
						+ "                    <td><a href=\"Details\"><button>View Details</button></a></td>"
						+ "                </tr>"
						+ "                <tr>"
						+ "                    <td><a href=\"transfer.html\"><button>Transfer</button></a></td>"
						+ "                </tr>"
						+ "                <tr>"
						+ "                    <td><a href=\"withdrawal.html\"><button>Withdrawal</button></a></td>"
						+ "                </tr>"
						+ "                <tr>"
						+ "                    <td><a href=\"diposite.html\"><button>Diposite</button></a></td>"
						+ "                </tr>"
						+ "                <tr>"
						+ "                    <td><a href=\"logout\"><button>logout</button></a></td>"
						+ "                </tr>"
						+ "            </Table>"
						+ "    </div>"
						+ ""
						+ "</body>"
						+ ""
						+ "</html>");*/
        	  else
        	  {
        		  RequestDispatcher rd = request.getRequestDispatcher("coust.html");
      			//rd.forward(request, response);
      			System.out.println("Invalid Crediential");
      			
      			PrintWriter out=response.getWriter();
      			out.println("<html>"
      				+ "<head><title>Invalid Username and Password</title>"
      				+ "</head>"
      				+ "<body>"
      				+ "<h1>Invalid Username and Password</h1>"
      				+ "</body>"
      				+ "</html>");
      			rd.include(request, response);
      			System.out.println("Invalid Crediential");
        	  }
			
		}
		else 
		{
			RequestDispatcher rd = request.getRequestDispatcher("coust.html");
			//rd.forward(request, response);
			System.out.println("Invalid Crediential");
			
			PrintWriter out=response.getWriter();
			out.println("<html>"
				+ "<head><title>Invalid Username and Password</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>Invalid Username and Password</h1>"
				+ "</body>"
				+ "</html>");
			rd.include(request, response);
			System.out.println("Invalid Crediential");
		}
		
		session.close();
	}
}
