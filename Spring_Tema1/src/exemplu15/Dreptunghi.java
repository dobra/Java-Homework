package exemplu15;

class Dreptunghi implements Figura
{
	private int lungime;
	private int latime;
	public Dreptunghi(int lungime,int latime) 
	{ 
		this.lungime= lungime;
		this.latime= latime;
	}
	
	public void aria() 
	{
		System.out.println("Aria dreptunghiului: "+(lungime*latime));
	}
}