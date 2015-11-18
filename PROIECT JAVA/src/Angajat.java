import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="angajati")
class Angajat {
	@Id
	@Column (name="id")
	private int id;
	
	@Column (name="nume")
	private String nume;
	
	@Column (name="firma")
	private String firma;
	
	@Column (name="functia")
	private String functia;
	
	@OneToMany(mappedBy="anga")
	@Cascade(CascadeType.ALL)
	private Set<Curs> cursuri;
	
	public Angajat(){}
	public Angajat( int id,String nume, String firma)
	{
		this.id=id;
		this.nume=nume;
		this.firma=firma;
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
	
	public String getFirma() 
	{
		return firma;
	}
	public void setFirma(String firma) 
	{
	this.firma= firma;
	}

	public String getFunctia() 
	{
		return functia;
	}
	public void setFunctia(String functia) 
	{
	this.functia= functia;
	}
	
	
	public Set<Curs> getCursuri() {return cursuri;}
	public void	setCursuri(Set<Curs>excursii) {this.cursuri=cursuri;	}
	
	// @ Override
	public String toString() 
	{
		
	return id + ", " +nume+ ", "+firma;
	}

};