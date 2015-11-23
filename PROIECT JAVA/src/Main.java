import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.Column;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {

	private static SessionFactory factory;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		
		/*					Part needed for Hybrid*****************************************/
		try
		{
			factory= new Configuration().configure().buildSessionFactory();
		}
		catch (Throwable ex) 
		{
			System.err.println("Failed to create sessionFactory object."+ ex);	
			throw new ExceptionInInitializerError(ex);
		}
		/*					Part needed for Hybrid*****************************************/
		
				Optiuni opt;
		int Choice=0;
		boolean loop_condition = true;
		
		while (loop_condition)
		{
			Println("1.Modifica Datele Angajatului");
			Println("2.Modifica Datele Cursului");
			Println("3.Afiseaza Angajatii firmei");
			Println("4.Angajatii cu vechime mai mare de o valoare.");
			Println("5.Angajatii care au urmat un curs specificat");
			Println("0.EXIT");
			Println("");
			Print("Alege:");
			
			try{
	            Choice = Integer.parseInt(br.readLine());
	        }catch(NumberFormatException nfe){
	            System.err.println("Invalid Format!");
	        }
			 
			 switch(Choice)
			 {
			 case 1: opt = Optiuni.ModifDateAngajat; break;
			 case 2: opt = Optiuni.ModifDateCurs; break;
			 case 3: opt = Optiuni.ShowEmployeesbyFirm; break;
			 case 4: opt = Optiuni.OlderEmployees; break;
			 case 5: opt = Optiuni.EmployeesWthDiploma; break;
			 default: opt = Optiuni.NotUsed; loop_condition=false; break;
			 }
			 
			 ProcessEvent(opt);
		}
		
	}

	
	public static void ProcessEvent(Optiuni opt) throws IOException
	{
		
		switch(opt)
		{
		case ModifDateAngajat:
			int Choice=0;
			Println("--->1.Adauga Angajat");
			Println("--->2.Cauta Angajat");
			Println("--->3.Sterge Angajat");
			Println("--->4.Actualizeaza Angajat");
			Println("--->Orice altceva este ignorat");
			Println("");
			Print("Alege:");
			
			try{
	            Choice = Integer.parseInt(br.readLine());
	        }catch(NumberFormatException nfe){
	            System.err.println("Invalid Format!");
	        }
			
			switch(Choice)
			{
			case 1:	AddEmployee();break;
			case 2:			
				int id_value;
			
				id_value=SearchEmployee();
				if((-1) == id_value)
				{
					Println("Id couldn't be found!");
				}
			break;
			case 3:	RemoveEmployee();break;
			case 4:	UpdateEmployee();break;
			default:break;
			}

			break;
		case ModifDateCurs:break;
		case ShowEmployeesbyFirm:break;
		case OlderEmployees:break;
		case EmployeesWthDiploma:break;
		case NotUsed:break;
		}
	}
	
	
	public static void UpdateEmployee() throws NumberFormatException, IOException
	{
		Session session = factory.openSession();
		Transaction tx =null;
		int id_value;
		
		id_value=SearchEmployee();
		if((-1) == id_value)
		{
			Println("Id couldn't be found!");
		}
		else
		{
		
			String nume;
			String firma;
			String functia;
			String data_angajarii;
			
			Println("****Modifica nume Angajat:");
			nume = br.readLine();
			Println("****Modifica firma Angajat:");
			firma = br.readLine();
			Println("****Modifica functia Angajatului:");
			functia = br.readLine();		
			Println("****Modifica data angajarii(format YYYY-MM-DD):");
			data_angajarii = br.readLine();
	
			try
			{
				tx=	session.beginTransaction();
				List<Angajat>angaja=	session.createQuery("FROM Angajat").list();
				for(Angajat a:angaja)
				{
						if(a.getId() == id_value)
						{
							a.setNume(nume);
							a.setFirma(firma);
							a.setFunctia(functia);
							a.setdata_angajarii(data_angajarii);
							session.update(a);
							break;
						}				
				}
				tx.commit();
			}
			catch(HibernateException e)
			{
				if(tx !=null)
					tx.rollback();
				e.printStackTrace();
			}
		}
	}

	public static void RemoveEmployee() throws NumberFormatException, IOException
	{
		Session session = factory.openSession();
		Transaction tx =null;
		
		int id;
		Println("****Cauta Angajat cu id-ul:");
		id = Integer.parseInt(br.readLine());
		
		try
		{
			tx=	session.beginTransaction();
			List<Angajat>angaja=	session.createQuery("FROM Angajat").list();
			for(Angajat a:angaja)
			{
					if(a.getId() == id)
					{
						session.delete(a);
						break;
					}				
			}
			tx.commit();
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

	
	public static int SearchEmployee() throws NumberFormatException, IOException
	{
		Session session = factory.openSession();
		Transaction tx =null;
		
		int id;
		Println("****Cauta Angajat cu id-ul:");
		id = Integer.parseInt(br.readLine());
		
		try
		{
			tx=	session.beginTransaction();
			List<Angajat>angaja=	session.createQuery("FROM Angajat").list();
			for(Angajat a:angaja)
			{
					if(a.getId() == id)
					{
						Println(a.toString());
						return a.getId();
					}				
			}
			tx.commit();
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
		return -1;
	}
	
	public static void AddEmployee() throws NumberFormatException, IOException
	{
		int id;
		String nume;
		String firma;
		String functia;
		String data_angajarii;
		
		Println("****Adauga id Angajat:");
		id = Integer.parseInt(br.readLine());
		Println("****Adauga nume Angajat:");
		nume = br.readLine();
		Println("****Adauga firma Angajat:");
		firma = br.readLine();
		Println("****Adauga functia Angajatului:");
		functia = br.readLine();		
		Println("****Adauga data angajarii(format YYYY-MM-DD):");
		data_angajarii = br.readLine();

		Angajat angaj = new Angajat(id,nume,firma,functia,data_angajarii);
		
		Session session = factory.openSession();
		Transaction tx =null;
		try
		{
			tx = session.beginTransaction();
			session.save(angaj);
			
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
	public static void Println(String msg)
	{ System.out.println(msg);}
	public static void Print(String msg)
	{ System.out.print(msg);}
}
