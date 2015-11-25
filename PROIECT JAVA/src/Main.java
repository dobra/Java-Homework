import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import javax.persistence.Column;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {

	private static SessionFactory factory;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException, NumberFormatException, ParseException 
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

	
	public static void ProcessEvent(Optiuni opt) throws IOException, NumberFormatException, ParseException
	{
		int Choice=0;
		switch(opt)
		{
		case ModifDateAngajat:
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
		case ModifDateCurs:
			Println("--->1.Adauga Curs");
			Println("--->2.Cauta Curs");
			Println("--->3.Sterge Curs");
			Println("--->4.Actualizeaza Curs");
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
			case 1:	AddCurs();break;
			case 2:			
				int id_value;
			
				id_value=SearchCurs();
				if((-1) == id_value)
				{
					Println("Id couldn't be found!");
				}
			break;
			case 3:	RemoveCurs();break;
			case 4:	UpdateCurs();break;
			default:break;
			}

			break;
		
		case ShowEmployeesbyFirm:ShowEmployeesbyFirm();	break;
		case OlderEmployees:OlderEmployees(); break;
		case EmployeesWthDiploma:EmployeesWthDiploma();break;
		case NotUsed:break;
		}
	}

	public static void EmployeesWthDiploma() throws NumberFormatException, IOException, ParseException
	{
		Session session = factory.openSession();
		Transaction tx =null;
		try
		{
			tx=	session.beginTransaction();
			List<Angajat>angaja=	session.createQuery("FROM Angajat").list();
			for(Angajat a:angaja)
			{
				List<Curs>cursuri=	session.createQuery("FROM Curs").list();
				for(Curs c:cursuri)
				{
					if(Objects.equals(c.getanga(), a))
					{
						Println(a.toString());
						break;
					}
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
	
	
	public static void OlderEmployees() throws NumberFormatException, IOException, ParseException
	{
		Session session = factory.openSession();
		Transaction tx =null;
		String firm;
		Println("Introduceti data in formatul YYYY-MM-DD");
		firm = br.readLine();
		DateFormat format = new SimpleDateFormat("yyy-MM-dd");
		try
		{
			Date date = format.parse(firm);
			System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010
		}
		catch (java.text.ParseException e)
		{e.printStackTrace();}

		try
		{
			tx=	session.beginTransaction();
			List<Angajat>angaja=	session.createQuery("FROM Angajat").list();
			for(Angajat a:angaja)
			{
						try
						{
							Date date = format.parse(a.getdata_angajarii());
							System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010
						}
						catch (java.text.ParseException e)
						{e.printStackTrace();}

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
	
	public static void ShowEmployeesbyFirm() throws NumberFormatException, IOException
	{
		Session session = factory.openSession();
		Transaction tx =null;
		String firm;
		Println("Introduceti firma in functie de care doriti sa cautati");
		firm = br.readLine();

		try
		{
			tx=	session.beginTransaction();
			List<Angajat>angaja=	session.createQuery("FROM Angajat").list();
			for(Angajat a:angaja)
			{
					if(a.getFirma().equals(firm))
					{
						Println(a.toString());
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
	
	public static void UpdateCurs() throws NumberFormatException, IOException
	{
		Session session = factory.openSession();
		Transaction tx =null;
		int id_value;
		
		id_value=SearchCurs();
		if((-1) == id_value)
		{
			Println("Id couldn't be found!");
		}
		else
		{
			int id_angajat, id_curs,numar_ore, valoare;
			String denumire,anul,diploma_absolvire;

			Println("****Noua denumire:");
			denumire = br.readLine();
			Println("****Noul numar ore:");
			numar_ore = Integer.parseInt(br.readLine());
			Println("****Noua valoare:");
			valoare = Integer.parseInt(br.readLine());
			Println("****Noua diploma absolvire:");
			diploma_absolvire = br.readLine();
			Println("****Noul anul cu formatul YYYY-MM-DD:");
			anul = br.readLine();
	
	
			try
			{
				tx=	session.beginTransaction();
				List<Curs>cursuri=	session.createQuery("FROM Curs").list();
				for(Curs a:cursuri)
				{
						if(a.getid_curs() == id_value)
						{
							a.setdenumire(denumire);
							a.setnumar_ore(numar_ore);
							a.setvaloare(valoare);
							a.setdiploma_absolvire(diploma_absolvire);
							a.setanul(anul);
							session.update(a);
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

	public static void RemoveCurs() throws NumberFormatException, IOException
	{
		Session session = factory.openSession();
		Transaction tx =null;
		
		int id_curs;
		Println("****Cauta Curs cu id-ul:");
		id_curs = Integer.parseInt(br.readLine());
		
		try
		{
			tx=	session.beginTransaction();
			List<Curs>cursuri=	session.createQuery("FROM Curs").list();
			for(Curs a:cursuri)
			{
					if(a.getid_curs() == id_curs)
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
	
	public static int SearchCurs() throws NumberFormatException, IOException
	{
		Session session = factory.openSession();
		Transaction tx =null;
		
		int id_curs;
		Println("****Cauta Cursul cu id-ul:");
		id_curs = Integer.parseInt(br.readLine());
		
		try
		{
			tx=	session.beginTransaction();
			List<Curs>cursuri=	session.createQuery("FROM Curs").list();
			for(Curs a:cursuri)
			{
					if(a.getid_curs() == id_curs)
					{
						Println(a.toString());
						return a.getid_curs();
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
	
	public static void AddCurs() throws NumberFormatException, IOException
	{
		int id_angajat, id_curs,numar_ore, valoare;
		String denumire,anul,diploma_absolvire;

		Println("****Adauga id Angajat:");
		id_angajat = Integer.parseInt(br.readLine());
		Println("****Adauga id Curs:");
		id_curs = Integer.parseInt(br.readLine());

		Println("****Adauga denumire:");
		denumire = br.readLine();
		Println("****Adauga numar ore:");
		numar_ore = Integer.parseInt(br.readLine());
		Println("****Adauga valoare:");
		valoare = Integer.parseInt(br.readLine());
		Println("****Adauga diploma absolvire:");
		diploma_absolvire = br.readLine();
		Println("****Adauga anul cu formatul YYYY-MM-DD:");
		anul = br.readLine();


		Session session = factory.openSession();
		Transaction tx =null;
		try
		{
			tx=	session.beginTransaction();
			List<Angajat>angaja=	session.createQuery("FROM Angajat").list();
			for(Angajat a:angaja)
			{
					if(a.getId() == id_angajat)
					{
						Curs un_curs = new Curs(id_curs,denumire, numar_ore,valoare,diploma_absolvire,anul,a);
						session.save(un_curs);
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
	public static void Println(String msg)
	{ System.out.println(msg);}
	public static void Print(String msg)
	{ System.out.print(msg);}
}
