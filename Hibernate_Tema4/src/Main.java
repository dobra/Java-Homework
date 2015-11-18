import org.hibernate.*;
import org.hibernate.cfg.Configuration;



public class Main 
{
	public static void main(String[] args) 
	{
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Marca m1= new Marca("IS","AIA",1);
		Marca m2= new Marca("CTI","C",1);
		Marca m3= new Marca("IET","ST",1);
		Student s1=	new	Student(m1,"Popescu");
		Student s2=	new	Student(m2,"Ionescu");
		Student s3=	new	Student(m3,"Georgescu");
		session.save(s1);
		session.save(s2);
		session.save(s3);
		tx.commit();
		session.close();
	}
}