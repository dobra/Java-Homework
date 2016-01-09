package Tema2;

import javax.annotation.*;
import org.springframework.beans.factory.annotation.Required;

public class Tir extends Vehicul 
{
	private int incarcatura_max;
	
	public Tir(){}
	public Tir(int pret, int viteza_max, int incarcatura_max)
	{
		this.pret=pret;
		this.viteza_max=viteza_max;
		this.incarcatura_max=incarcatura_max;
	}
		
	public int getIncarcatura_max()
	{
		return incarcatura_max;
	}
	
	@Required
	public void setIncarcatura_max(int incarcatura_max)
	{
		this.incarcatura_max=incarcatura_max;
	}
	@Override
	public String toString()
	{
		return pret+ ", "+ viteza_max+ ", "+ incarcatura_max;
	}
}