package exemplu13;

class Dreptunghi 
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