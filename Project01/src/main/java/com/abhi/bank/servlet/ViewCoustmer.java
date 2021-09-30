package com.abhi.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.abhi.bank.hibernate.HibernetUtil01;
import com.abhi.bank.model.Coustmer;


/**
 * Servlet implementation class ViewCoustmer
 */
public class ViewCoustmer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCoustmer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		Session session = HibernetUtil01.getSessionFactory().openSession();
		List<Coustmer> results=session.createQuery("from Coustmer", Coustmer.class).list();
	   /*  for(Coustmer s: results)
	     {
	    	System.out.println(s);
	     }*/
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
					+ "  <h2>Online Bank Coustmer</h2>"
					+ "  <table class=\"table\">"
					+ "    <thead>"
					+ "      <tr>"
					+ "        <th>Id</th>"
					+ "        <th>Name</th>"
					+ "        <th>Mobile No</th>"
					+ "        <th>Email</th>"
					+ "        <th>Balance</th>"
					+ "        <th>Adhar Card</th>"
					+ "        <th>PanCard</th>"
					+ "      </tr>"
					+ "    </thead>"
					+ "    <tbody>");
			
			for(Coustmer s: results)
		     {
			out.println( "      <tr class=\"success\">"
					+ "        <td>"+s.getCoustid()+"</td>"
					+ "        <td>"+s.getName()+"</td>"
					+ "        <td>"+s.getMobno()+"</td>"
					+ "        <td>"+s.getEmail()+"</td>"
					+ "        <td>"+s.getBal()+"</td>"
					+ "        <td>"+s.getAdhar()+"</td>"
					+ "        <td>"+s.getPan()+"</td>"
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
