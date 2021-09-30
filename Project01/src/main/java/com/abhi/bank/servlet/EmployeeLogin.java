package com.abhi.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.Query;
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
import com.abhi.bank.model.Employee;

/**
 * Servlet implementation class EmployeeLogin
 */
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLogin() {
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
System.out.println("This is a Inbox servlet doget method");
		
		int username= Integer.parseInt(request.getParameter("uname"));
		String password = request.getParameter("psw");
		Session session = HibernetUtil01.getSessionFactory().openSession();
		  
          Transaction transaction = session.beginTransaction();
          Employee s1 = session.get(Employee.class,username);
	      transaction.commit();
	      
          if(s1!=null )
		{
			
        	  boolean a= password.equals(s1.getPass());
        	  if(a)
        	  { response.sendRedirect("employeeOperation.html");}
        	  else
        	  {
        		  RequestDispatcher rd = request.getRequestDispatcher("emp.html");
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
			
				/*RequestDispatcher rd = request.getRequestDispatcher("empsuccess.html");
				rd.forward(request, response);*/
			
        	  /*
				PrintWriter out=response.getWriter();
				out.println("<html>"
						+ "<head>"
						+ "    <title>Employee Page</title>"
						+ "</head>"
						+ "<body>"
						+ ""
						+ "    <div>"
						+ "            <h1>Employee Login Successfully</h1>"
						+ "            <Table>"
						+ "                <tr>"
						+ "                    <td><a href=\"coustdetails.html\"><button>View Coustmer Details</button></a></td>"
						+ "                </tr>"
						+ "                <tr>"
						+ "                    <td><a href=\"viewlog.html\"><button>Vie Log</button></a></td>"
						+ "                </tr>"
						+ "                <tr>"
						+ "                    <td><a href=\"Add Coustmer.html\"><button>Add Coustmer</button></a></td>"
						+ "                </tr>"
						+ "                <tr>"
						+ "                    <td><a href=\"index.html\"><button>logout</button></a></td>"
						+ "                </tr>"
						+ "            </Table>"
						+ "    </div>"
						+ ""
						+ "</body>"
						+ ""
						+ "</html>");*/
			
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("emp.html");
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
