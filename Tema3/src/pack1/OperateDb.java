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

/**
 * Servlet implementation class OperateDb
 */
@WebServlet("/OperateDb")
public class OperateDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperateDb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static SessionFactory factory;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String status=	request.getParameter("Status");
		Integer intStatus=Integer.parseInt(status);
		
		Session session = factory.openSession();
		Transaction tx =null;
		PrintWriter out = response.getWriter();
		
		switch(intStatus)
		{
		case 0:	//Add
				String nr_inmatriculare=	request.getParameter("nr_inmatriculare");
				String anul=	request.getParameter("anul");
				Integer intAnul=Integer.parseInt(anul);
				
				String culoare=	request.getParameter("culoare");
				Integer intCuloare=Integer.parseInt(culoare);
				
				String nr_km=	request.getParameter("nr_km");
				Integer intNr_km=Integer.parseInt(nr_km);
				
				String marca=	request.getParameter("marca");
				
				Masina mas=new Masina(nr_inmatriculare, marca, intAnul, intCuloare, intNr_km);

				try
				{
					tx = session.beginTransaction();
					session.save(mas);
					
					tx.commit();
				}
				catch
				(HibernateException	e) 
				{
					if(tx!=	null) 
						tx.rollback();
					e.printStackTrace();
				}
				finally
				{
					session.close();
				}	
				
				break;
		case 1://Search
			String nr_inmatriculareSearch=	request.getParameter("nr_inmatriculare");
			try
			{
				tx=	session.beginTransaction();
				List<Masina>masinute=	session.createQuery("FROM masini").list();
				for(Masina a:masinute)
				{
						if(a.getNr_inmatriculare().equals(nr_inmatriculareSearch))
							{out.println(a.toString());}
					
				}
				tx.commit(); 
			}
			catch(HibernateException e)
			{
				if(tx !=null)
					tx.rollback();
				e.printStackTrace();
			}
			break;
			
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
