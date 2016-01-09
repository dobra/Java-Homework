package exemplu1;

abstract class Figura {
	public abstract void aria ();
}

class Cerc extends Figura
{
	@Override
	public void aria() 
	{
		System.out.println("Aria cercului");
	}
}

class Dreptunghi extends Figura
{
	@Override
	public void aria() 
	{ 
		System.out.println("Aria dreptunghiului");
	}
}

class MainApp
{
	public static void main(String[]args)
	{
		Figura c=new Cerc();
		c.aria();
		Figura d=new Dreptunghi();
		d.aria();
	}
}