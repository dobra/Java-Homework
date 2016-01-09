package Tema3;

public class Masina 
{
	private int id;
	private String nr_inmatriculare;
	private int anul;
	private int culoare;
	private int nr_km;
	
	public void setId(int id)	{this.id=id;}
	public int getId()			{return this.id;}
	
	public void setAnul(int anul)	{this.anul=anul;}
	public int getAnul()		{return this.anul;}
	
	public void setCuloare(int culoare)	{this.culoare=id;}
	public int getCuloare()				{return this.culoare;}
	
	public void setNr_km(int nr_km)	{this.nr_km=nr_km;}
	public int getNr_km()			{return this.nr_km;}
	
	public void setNr_inmatriculare(String nr_inmatriculare) {this.nr_inmatriculare=nr_inmatriculare;}
	public String getNr_inmatriculare() 					 {return this.nr_inmatriculare;}
	
	@Override
	public String toString()
	{
		return id+", "+nr_inmatriculare+", "+anul+", "+culoare+", "+nr_km;
	}
	
}
