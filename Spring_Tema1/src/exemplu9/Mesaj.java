package exemplu9;
public class Mesaj 
{
	private	String mesaj;
	public String getMesaj() 
	{
		return mesaj;
	}
	public void setMesaj(String mesaj) 
	{
		this.mesaj= mesaj;
	}
	@Override public String toString() 
	{
		return mesaj;
	}
}
