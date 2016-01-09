package exemplu16;

import org.springframework.beans.factory.annotation.Required;

class Persoana 
{
	private String nume;
	private int varsta;
	public Persoana(){}
	public String getNume() 
	{
		return nume;
	}
	
	@Required 
	public void setNume(String nume) 
	{
		this.nume= nume;
	}
	public int getVarsta() 
	{
		return varsta;
	}
	@Required
	public void setVarsta(int varsta) 
	{
		this.varsta= varsta;
	}
@Override
public
String toString() {
return
nume
+ 
", "
+ 
varsta
;
}
}