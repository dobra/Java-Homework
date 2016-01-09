package exemplu16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class main 
{
	public static void main(String []args)
	{
		ApplicationContext context= new ClassPathXmlApplicationContext("Beans14.xml");
		Persoana p=(Persoana)context.getBean("pers");
		System.out.println(p);
	}
}