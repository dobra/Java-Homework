package exemplu15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class main 
{
	public static void main(String []args) 
	{
		ApplicationContext context= new ClassPathXmlApplicationContext("Beans13.xml");
		//Figura f=(Figura)context.getBean("cerc");
		Figura f=(Figura)context.getBean("dreptunghi");
		f.aria();
	}
}
