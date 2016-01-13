package pack1;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="masini")
class Masina {
	@Id
	@GeneratedValue 
	private int id;
	
	@Column (name="nr_inmatriculare")
	private String nr_inmatriculare;
	
	@Column (name="marca")
	private String marca;
	
	@Column (name="anul")
	private int anul;
	
	@Column (name="culoare")
	private int culoare;

	@Column (name="nr_km")
	private int nr_km;

	
	public Masina(){}
	public Masina( String nr_inmatriculare, String marca, int anul, int culoare, int nr_km)
	{
		this.nr_inmatriculare=nr_inmatriculare;
		this.marca=marca;
		this.anul=anul;
		this.culoare=culoare;
		this.nr_km=nr_km;
	}
	
	public int getId() 
	{
		return id;
	}
		
	public String getNr_inmatriculare() 
	{
		return nr_inmatriculare;
	}
	public void setNr_inmatriculare(String nr_inmatriculare) 
	{
	this.nr_inmatriculare= nr_inmatriculare;
	}
	
	public String getMarca() 
	{
		return marca;
	}
	public void setMarca(String marca) 
	{
	this.marca= marca;
	}

	public int getCuloare() 
	{
		return culoare;
	}
	public void setCuloare( int culoare) 
	{
	this.culoare= culoare;
	}
	
	public int getAnul() 
	{
		return anul;
	}
	public void setAnul( int anul) 
	{
	this.anul = anul;
	}
	
	public int getNr_km() 
	{
		return nr_km;
	}
	public void setNr_km( int nr_km) 
	{
	this.nr_km = nr_km;
	}
	
	
	@ Override
	public String toString() 
	{
		
	return id + ", " +nr_inmatriculare+ ", "+marca+ ", " +anul+", "+culoare +", "+nr_km;
	}

};