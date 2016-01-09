package exemplu5;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;


class Dreptunghi
{
	private int lungime;
	private int latime;
	
	public void Aria()
	{
		System.out.println("Aria dreptunghiului: "+(lungime*latime));
	}
	public int getLungime(){return lungime;}
	public void setLungime(int lungime){this.lungime=lungime;}
	
	public int getLatime(){return latime;}
	public void setLatime(int latime){this.latime=latime;}
	
}

class MainApp
{
	public static void main(String[] args)
	{
		BeanFactory factory = new XmlBeanFactory (new FileSystemResource("Beans.xml"));
		Dreptunghi	 d = (Dreptunghi)factory.getBean("dreptunghi");
		d.Aria();
	}
}
