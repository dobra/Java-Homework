import javax.persistence.*;
@Entity
@Table (name="student")
public class Student 
{
	@EmbeddedId
	private Marca marca;
	
	@Column(name="nume")
	private String nume;
	
	public Student(){}
	public Student(Marca marca, String nume) 
	{ 
		this.marca= marca;
		this.nume= nume;
	}
}