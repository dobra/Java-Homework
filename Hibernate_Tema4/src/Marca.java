import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class Marca implements Serializable
{
	@Column (name="cod_domeniu")
	private String cod_domeniu;
	
	@Column (name="cod_specializare")
	private String cod_specializare;
	
	@Column (name="id")
	private int id;
	
	public Marca(String cod_domeniu, String cod_specializare, int id) 
	{
		this.cod_domeniu= cod_domeniu;
		this.cod_specializare= cod_specializare;
		this.id= id;
	}
}