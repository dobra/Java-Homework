package exemplu15;

class Cerc implements Figura
{
	private double raza;
	
	@Override
	public void aria() 
	{
		System.out.println("Aria cercului: "+Math.PI*raza*raza);
	}
	public double getRaza() 
	{
		return raza;
	}
	public void setRaza(double raza) 
	{
		this.raza= raza;
	}
}