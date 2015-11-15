import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	private static SessionFactory factory;
	public static void main(String[] args) 
	{
		try
		{
			factory= new Configuration().configure().buildSessionFactory();
		}
		catch (Throwable ex) 
		{
			System.err.println("Failed to create sessionFactory object."+ ex);	
			throw new ExceptionInInitializerError(ex);
		}
		Persoana p1 = new Persoana(111, "Ionel" ,20);
		Set<Excursia>set1=new HashSet<Excursia>();
		set1.add(new Excursia(2000,"1Budapesta",p1));
		set1.add(new Excursia(2002,"1Viena",p1));
		set1.add(new Excursia(2004,"1Berlin",p1));
	
		adaugare(p1);
		Persoana p2 = new Persoana(222, "Dani" ,22);
		Set<Excursia> set2 =new HashSet<Excursia>();
		set2.add(new Excursia(2000,"1Londra",p2));
		set2.add(new Excursia(2002,"1Barcelona",p2));
		p2.setExcursii(set2);
		adaugare(p2); 
		afisare();
		System.out.println("----");
		actualizare("Ionel", 21);
		stergere("Ionel");
		afisare();
	}
	public static void	adaugare(Persoana	p	)
	{
		Session	session	=	factory	.openSession();
		Transaction	tx	=	null;
		try
		{
			tx	=	session.beginTransaction();
			session.save(p);
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
	}
	public static void	afisare( )
	{
		Session session	=factory.openSession();
		Transaction	tx=null;
		try
		{
			tx=	session.beginTransaction();
			List<Persoana>persoane=	session.createQuery("FROM Persoana").list();
			for(Persoana p	:persoane)
			{
				System.out.println(p);
				Set<Excursia> excursii=p.getExcursii();
				for(Excursia e :excursii)
				{
					System.out.println("-"+e);
				}
			}
			tx.commit();
		}	
		catch (HibernateException	e)
		{	
			if(	tx!=null) 
				tx.rollback();
			e.printStackTrace();
		}
		finally	{session.close();}
	}
	
	public static void	actualizare(String	nume,int varsta)
	{
		Session	session=factory.openSession();
		Transaction	tx=	null;
		try
			{
				tx=	session.beginTransaction();
				List<Persoana>persoane=	session.createQuery("FROM Persoana").list();
				for(Persoana p:persoane)
				{
					if(	p.getNume().equalsIgnoreCase(nume))
					{
						if(p.getNume().equalsIgnoreCase(nume))
						{
							p.setVarsta(varsta);
							session.update(p);
							break;
						}
					}
				tx.commit();
				}
			}
		catch(HibernateException e)
		{
			if(tx !=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally
		{
		session.close();
		}
	}
	
	public static void stergere(String nume)
	{
	Session session=factory.openSession();
	Transaction tx =null;
	try
		{
			tx= session.beginTransaction();
			List<Persoana> persoane=session.createQuery("FROM Persoana").list();
			for(Persoana p:persoane)
			{
				if(p.getNume().equalsIgnoreCase(nume))
				{
					session.delete(p);
					break;
				}
			}
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
}