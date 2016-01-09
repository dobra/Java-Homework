package exemplu4;

abstract class Figura
{
	public abstract void aria();
}

class Aria
{
	private Figura f;
	public void setFigura(Figura f)
	{
		this.f = f;
	}
	public 	void calculeaza_aria()
	{
		this.f.aria();
	}
}


class Cerc extends Figura
{
	@Override
	public void aria()
	{
		System.out.println("Se calculeaza aria Cercului");
	}
}

class Dreptungi extends Figura
{
	@Override
	public void aria()
	{
		System.out.println("Se calculeaza aria Dreptungiului");
	}
}


class MainApp
{
	public static void main(String[] args)
	{
		Aria a=new Aria();
		a.setFigura(new Cerc());
		a.calculeaza_aria();
	}
}