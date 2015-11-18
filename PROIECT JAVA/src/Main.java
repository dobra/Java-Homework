import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

	private static SessionFactory factory;
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
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

	
	public static void ProcessEvent(Optiuni opt)
	{
		switch(opt)
		{
		case ModifDateAngajat:
			
			
			break;
		case ModifDateCurs:break;
		case ShowEmployeesbyFirm:break;
		case OlderEmployees:break;
		case EmployeesWthDiploma:break;
		case NotUsed:break;
		}
	}
	
	public static void Println(String msg)
	{ System.out.println(msg);}
	public static void Print(String msg)
	{ System.out.print(msg);}
}
