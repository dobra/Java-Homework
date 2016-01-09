package Tema3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
	
public class main 
{	
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException 
	{ 
		String nr_inmat, marca;
		int anul, culoare,km;
		
		ApplicationContext context =new ClassPathXmlApplicationContext("BeansTema3.xml");
		OperatiiBd operatiiBD =(OperatiiBd)context.getBean("operatiiJDBC");
		
		int Choice=0;
		boolean loop_condition = true;
		
		while (loop_condition)
		{
			System.out.println("1.Adaugare Masina");
			System.out.println("2.Sterge Masina");
			System.out.println("3.Cautare Masina");
			System.out.println("4.Afisare Masini.");
			System.out.println("5.Cauta dupa marca");
			System.out.println("6.Masini sub 100.000km");
			System.out.println("Masini mai noi de 5 ani");
			System.out.print("Alege:");
			
			try{
	            Choice = Integer.parseInt(br.readLine());
	        }catch(NumberFormatException nfe){
	            System.err.println("Invalid Format!");
	        }
			 
			 switch(Choice)
			 {
			 case 1: 
				 	System.out.println("****Adauga nr de inmat al masinii:");
				 	nr_inmat = br.readLine();
				 	System.out.println("****Adauga anul Masinii:");
					anul = Integer.parseInt(br.readLine());
					System.out.println("****Adauga culoarea Masinii:");
					culoare = Integer.parseInt(br.readLine());
					System.out.println("****Adauga kilometrii Masinii:");
					km= Integer.parseInt(br.readLine());
				 	System.out.println("****Adauga marca masinii:");
				 	marca = br.readLine();

				 	operatiiBD.insert(nr_inmat,anul,culoare,km, marca);
				 break;
			 case 2:
				 	System.out.println("****Adauga nr de inmat al masinii:");
				 	nr_inmat = br.readLine();
				 	operatiiBD.delete(nr_inmat);
				 	
				 break;
			 case 3: 
				 	System.out.println("****Adauga nr de inmat al masinii:");
				 	nr_inmat = br.readLine();
				 	operatiiBD.getMasina(nr_inmat);
				 	
				 	break;
			 case 4: 
					List<Masina> lista_masini = operatiiBD.getListaMasini();
					for (Masina p : lista_masini) 
					{ 
						System.out.println(p);
					}
					break;
			 case 5:
				 	System.out.println("****Adauga marca:");
				 	marca = br.readLine();
					List<Masina> lista_masinimarca = operatiiBD.getListaMasiniMarca(marca);
					for (Masina p : lista_masinimarca) 
					{ 
						System.out.println(p);
					}
				 break;
			 case 6:
					List<Masina> lista_masinian = operatiiBD.getListaMasiniAn();
					for (Masina p : lista_masinian) 
					{ 
						System.out.println(p);
					}
					break;
			 default: loop_condition=false; break;
			 }
			 
		}
		
	}

		
}
