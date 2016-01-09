package exemplu13;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;;


public class main 
{

	public static void main(String[] args) 
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans11.xml");
		Dreptunghi d =(Dreptunghi)context.getBean("dreptunghi");
		d.aria();
	}

}
