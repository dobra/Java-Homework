package exemplu19;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class main 
{
	public static void main(String []args) 
	{ 
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("Beans17.xml");
		Persoana p=(Persoana)context.getBean("pers");
		System.out.println(p);
		context.registerShutdownHook();
	}
}