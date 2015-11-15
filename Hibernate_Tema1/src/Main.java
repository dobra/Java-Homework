import java.util.List; 
import java.util.Date; 
import java.util.Iterator; 
import org.hibernate.HibernateException; 
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
	private static SessionFactory factory; 
    private static Configuration configuration;
	public static void main(String[] args) 
	{
		try
		{
				configuration = new Configuration();
			    configuration.configure("./hibernate.cfg.xml");

			    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
			            configuration.getProperties()).build();
			    factory = configuration.buildSessionFactory(serviceRegistry);
			    
			    delete(10);
			    delete(20);
			    delete(30);
			    insert(10,"Maria", 20); 
			    insert(20,"Ioana", 19); 
			    insert(30,"Denisa", 14);
			    
		}
		catch(Throwable ex)
		{
			System.err.println("O aparut eroarea:"+ex);
		}
		update(20,66);

		afisare();

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
	
	private static void	afisare( )
	{ 
		Session session = factory.openSession(); 
		Transaction tx =null; 
		try
		{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Persoana");
			List<Persoana> persoane = query.list(); 
			for
			(Persoana p: persoane)
			{ 
				System.out.println(p); 
			} 
			tx.commit(); 
		}
		catch
		(HibernateException e) 
		{ 
			if(tx!=	null) tx.rollback(); 
			e.printStackTrace(); 
			e.printStackTrace(); 
		}
		finally
		{ 
			session.close(); 
		}
	}
	private static void	update(Integer id,int varsta )
	{ 
		Session session = factory.openSession(); 
		Transaction tx = null; 
		try
		{ 
			tx = session.beginTransaction(); 
			Persoana pers= (Persoana)session.get(Persoana.class, id); 
			pers.setVarsta( varsta ); 
			session.update(pers); 
			tx.commit(); 
		}
		catch
		(HibernateException e)
		{ 
			if(tx!=	null) 
				tx.rollback(); 
			e.printStackTrace(); 
		}
		finally
		{ 
			session.close(); 
		} 
	} 
	
	private static void	delete(Integer id)
	{ 
	Session session =factory.openSession(); 
	Transaction tx = null;
	try
	{ 
		tx = session.beginTransaction(); 
		Persoana pers= (Persoana)session.get(Persoana.class	, id); 
		session.delete(pers); 
		tx.commit(); 
	}
	catch
	(HibernateException e) 
	{ 
		if(tx!=	null) tx.rollback(); 
		e.printStackTrace(); 
	}
	finally
	{ 
		session.close(); 
	} 
	}
	
}
