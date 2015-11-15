import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

	private static SessionFactory factory; 
    private static Configuration configuration;

    private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) 
	{

		System.out.println("AAAA");
		try
		{
			configuration = new Configuration().addResource("hibernate.cfg.xml");
            configuration.configure();

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
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
