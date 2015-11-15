public class Excursia 
{
	private int id;
	private int anul;
	private String destinatia;
	public Excursia(){}
	public Excursia(int id,int anul,String destinatia) 
	{
		this.id= id;
		this.anul= anul;
		this.destinatia= destinatia;
	}
	public int getId() 
	{
		return id;
	}
	public void	setId(	int	id) 
	{
		this.id	= id;
	}
	
	public int	getAnul() 
	{
		return	anul;
	}
	
	public void	setAnul(int	anul) 
	{
		this.anul = anul;
	}
	
	public String getDestinatia() 
	{
		return destinatia;
	}
	
	public void	setDestinatia(String destinatia) 
	{
		this.destinatia	= destinatia;
	}

	public	String toString() 
	{
		return id+", "+	anul+", "+destinatia;
	}
}