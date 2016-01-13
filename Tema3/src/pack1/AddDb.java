package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class AddDb
 */
@WebServlet("/AddDb")
public class AddDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static SessionFactory factory;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();		
		
		out.println("<form method ='POST' action='http://localhost:8080/Tema3/OperateDb'>");
		out.println("<p><input type='Hidden' name='Status' value ='0' ></p>");// 0 means Add
		
		out.println("<p>Nr_inmatriculare:<input type='text' name='nr_inmatriculare'></p>");
		out.println("<p>Anul:<input type='text' name='anul'></p>");
		out.println("<p>Culoare:<input type='text' name='culoare'></p>");
		out.println("<p>Nr_km:<input type='text' name='nr_km'></p>");
		out.println("<p>Marca:<input type='text' name='marca'></p>");
		
		out.println("<p><input type='submit' value ='Adauga' ></p>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		try
		{
			factory= new Configuration().configure().buildSessionFactory();
		}
		catch (Throwable ex) 
		{
			System.err.println("Failed to create sessionFactory object."+ ex);	
			throw new ExceptionInInitializerError(ex);
		}
		
		Session session = factory.openSession();
		Transaction tx =null;
		String firm;
		try
		{
			tx=	session.beginTransaction();
			List<Masina>masinute=	session.createQuery("FROM masini").list();
			for(Masina a:masinute)
			{

						out.println(a.toString());
				
			}
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx !=null)
				tx.rollback();
			e.printStackTrace();
		}
		
		out.println("<html><head><title></title><body>"	);
		out.println("<form method ='POST' action='http://localhost:8080/Tema3/OperateDb'>");
		out.println("<p><input type='Hidden' name='Status' value ='1' ></p>");// 1 means Search
		
		out.println("<p>Cauta Nr Inmatriculare:<input type='text' name='inmatriculare'></p>");
		out.println("<p><input type='submit' value ='Cauta' ></p>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
