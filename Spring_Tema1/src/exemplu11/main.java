package exemplu11;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;;


public class main 
{

	public static void main(String[] args) 
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans9.xml");
		Persoana p=(Angajat)context.getBean("angajat");
		System.out.println(p);
	}

}
