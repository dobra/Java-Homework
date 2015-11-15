import java.util.List;
import java.util.Set;
import java.util.Date;
import java.util.HashSet;
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
			    

		}
		catch(Throwable ex)
		{
			System.err.println("O aparut eroarea:"+ex);
		}
		
		stergere(100); 
		Set<Excursia> set1 = new HashSet<Excursia>();
		set1.add(new Excursia(1,2000,"Budapesta"));
		set1.add(new Excursia(2,2002,"Viena"));
		set1.add(new Excursia(3,2004,"Berlin"));
		
		adaugare(new Persoana(100,"Ionel",20,set1));
		
		Set<Excursia> set2 = new HashSet<Excursia>();
		set2.add(new Excursia(4,2000,"Barca"));
		set2.add(new Excursia(5,2002,"Londra"));
		
		adaugare(new Persoana(200,"Dani",22,set2));
		
		afisare	(); 
		actualizare(100, 5000); 
		stergere(200); 

	}
		
	public static void adaugare(Persoana p)
	{
		Session session =factory.openSession();
		Transaction tx =null;
		try
		{
			tx = session.beginTransaction();
			session.save(p);
			tx.commit();
		}
		catch(HibernateException e) 
		{
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}
		finally
		{ 
			session.close();
		} 
	
	}
	public static void afisare( )
	{ 
		Session session =factory.openSession();
		Transaction tx =null;
		try
		{
			tx = session.beginTransaction(); 
			List<Persoana> persoane = session.createQuery("FROM Persoana").list();
			for(Persoana p:persoane)
			{
				System.out.println(p);
				Set<Excursia> excursii = p.getExcursii();
				for	(Excursia e:excursii)
				{
					System.out.println("-"+e);
				}
			} 
		tx.commit(); 
		}
		catch(HibernateException e) 
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
	public static void	actualizare(int	id,	int	varsta )
	{ 
		Session session =factory.openSession();
		Transaction tx =null; 
		try
		{ 
			tx = session.beginTransaction();
			Persoana p = (Persoana)session.get(Persoana.class, id);
			p.setVarsta(varsta); 
			p.setVarsta(varsta); 
			session.update(p); 
			tx.commit(); 
		}
		catch
		(HibernateException e) 
		{
			if(tx!= null) 
				tx.rollback(); 
			e.printStackTrace(); 
		}
		finally
		{ 
			session.close(); 
		} 
	}
	
	public static void stergere(int id)
	{ 
		Session session =factory.openSession();
		Transaction tx =null;
		try
		{ 
			tx = session.beginTransaction(); 
			Persoana p = (Persoana)session.get(Persoana.class, id);
			session.delete(p);
			tx.commit(); 
		}
		catch(HibernateException e) 
		{
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally
		{ 
			session.close(); 
		} 
	} 
} 