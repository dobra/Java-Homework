import java.util.Set;

class Persoana {
	private int id;
	private String nume;
	private int varsta;
	private Set excursii;
	
	public Persoana(){}
	public Persoana( int id,String nume, int varsta, Set excursii)
	{
		this.id=id;
		this.nume=nume;
		this.varsta=varsta;
		this.excursii = excursii;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId( int id) 
	{
	this.id = id;
	this.id = id;
	}
	
	
	public String getNume() 
	{
		return nume;
	}
	
	public void setNume(String nume) 
	{
	this.nume= nume;
	}
	
	public int getVarsta() 
	{
		return varsta;
	}
	
	public void setVarsta(int varsta) 
	{
	this.varsta= varsta;
	}
	public	Set getExcursii() 
	{
	return excursii;
	}
	public void	setExcursii(Set excursii) 
	{
	this.excursii= excursii;
	}
	
	// @ Override
	public String toString() 
	{
		
	return id + ", " +nume+ ", "+varsta;
	}

};