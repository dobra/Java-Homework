import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {

	private static SessionFactory factory; 
    private static Configuration configuration;

    private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) 
	{
		Connection conn = null;
		System.out.println("AAAA");
		Statement stmt = null;
		ResultSet rs = null;
		/*try {
			
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaTest?" +
		                                   "user=root&password=dobrarules1");
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM persoane");
		    while (rs.next()) {
	            String name = rs.getString("nume");
	            int id = rs.getInt("id");
	            int varsta = rs.getInt("varsta");
	            System.out.println(id + "\t" + name +
	                               "\t" + varsta);
	        }
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}*/
		
			try
		{
				configuration = new Configuration();
			    configuration.configure("./hibernate.cfg.xml");

			    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
			            configuration.getProperties()).build();
			    factory = configuration.buildSessionFactory(serviceRegistry);
			insert(2,"Gigi", 15);
		}
		catch(Throwable ex)
		{
			System.err.println("O aparut eroarea:"+ex);
		}
	}

	
	private static void insert(int id, String nume, int varsta	)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Persoana pers =  new Persoana(id, nume, varsta);
			session.save(pers);
			tx.commit();
		}
		catch(HibernateException ex)
		{
			if(tx != null) tx.rollback();
			ex.printStackTrace();
		}finally{session.close();}
	}
}
