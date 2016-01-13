package pack1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		
		String User=request.getParameter("nr1");
		String Pass=request.getParameter("nr2");
		
		if((User.equals("dobra")) && (Pass.equals("dobra")))
		{
			response.sendRedirect("http://localhost:8080/Tema3/ReadDb");
		}
		else
		{
			if((User.equals("dobra_admin")) && (Pass.equals("dobra")))
			{
				response.sendRedirect("http://localhost:8080/Tema3/AddDb");
			}
			else
			{
			PrintWriter out = response.getWriter();
			out.println("Password or Username are not right");
			}
		}
			
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
