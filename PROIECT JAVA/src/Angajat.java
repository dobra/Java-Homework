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
	
	@Column (name="data_angajarii")
	private String data_angajarii;
	
	@OneToMany(mappedBy="anga")
	@Cascade(CascadeType.ALL)
	private Set<Curs> cursuri;
	
	public Angajat(){}
	public Angajat( int id,String nume, String firma, String functia, String data_angajarii)
	{
		this.id=id;
		this.nume=nume;
		this.firma=firma;
		this.functia=functia;
		this.data_angajarii=data_angajarii;
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
	
	public String getdata_angajarii() 
	{
		return data_angajarii;
	}
	public void setdata_angajarii(String data_angajarii) 
	{
	this.data_angajarii= data_angajarii;
	}
	
	
	public Set<Curs> getCursuri() {return cursuri;}
	public void	setCursuri(Set<Curs>excursii) {this.cursuri=cursuri;	}
	
	// @ Override
	public String toString() 
	{
		
	return id + ", " +nume+ ", "+firma;
	}

};