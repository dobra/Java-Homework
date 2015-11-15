import javax.persistence.*;

@Entity
@Table(name="excursii")
public class Excursia 
{
	@Column	(name="id_excursie")
	@Id   @GeneratedValue	
	private int id;
	
	@Column (name="anul")
	private int anul;
	
	@Column (name="destinatie")
	private String destinatie;
	
	@ManyToOne
	@JoinColumn	(name =	"id_persoana")  
	private	Persoana pers;

	public Excursia(){}
	public Excursia(int anul,String destinatia, Persoana pers) 
	{	super();
		this.anul= anul;
		this.destinatie= destinatie;
		this.pers = pers;
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
		return destinatie;
	}
	
	public void	setDestinatia(String destinatie) 
	{
		this.destinatie	= destinatie;
	}
	
	public 	Persoana getPers() {return pers	;}
	public void	setPers(Persoana pers) {this.pers=pers;}
	
	public	String toString() 
	{
		return id+", "+	anul+", "+destinatie;
	}
}