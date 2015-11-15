import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="persoane")
class Persoana {
	@Id
	@Column (name="id")
	private int id;
	
	@Column (name="nume")
	private String nume;
	
	@Column (name="varsta")
	private int varsta;
	
	@OneToMany(mappedBy="pers")
	@Cascade(CascadeType.ALL)
	private Set<Excursia> excursii;
	
	public Persoana(){}
	public Persoana( int id,String nume, int varsta)
	{
		this.id=id;
		this.nume=nume;
		this.varsta=varsta;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId( int id) 
	{
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
	
	public Set<Excursia> getExcursii() {return excursii;}
	public void	setExcursii(Set<Excursia>excursii) {this.excursii=excursii;	}
	
	// @ Override
	public String toString() 
	{
		
	return id + ", " +nume+ ", "+varsta;
	}

};