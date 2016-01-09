package Tema2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exemplu7.Persoana;

public class main {

	public static void main(String[] args) 
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("BeansTema2.xml");
		Vehicul veh1=(Autoturism)context.getBean("auto");
		Vehicul veh2=(Motocicleta)context.getBean("moto");
		Vehicul veh3=(Tir)context.getBean("tir1");
		
		System.out.println(veh1.toString());
		System.out.println(veh2.toString());
		System.out.println(veh3.toString());
	//	System.out.println(veh4.toString());
	//	System.out.println(veh5.toString());
	//	
		
		
	}
}