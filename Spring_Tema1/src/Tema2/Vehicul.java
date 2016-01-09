package Tema2;

import org.springframework.beans.factory.annotation.Autowired;

public class Vehicul {


	protected int pret;
	protected int viteza_max;
	public int getPret()
	{
		return pret;
	}
	
	@Autowired(required=false)
	public void setPret(int pret)
	{
		this.pret=pret;
	}
	
	public int getViteza_max()
	{
		return viteza_max;
	}
	public void setViteza_max(int viteza_max)
	{
		this.viteza_max=viteza_max;
	}
	

	public String toString()
	{
		return pret+ ", "+ viteza_max;
	}
}