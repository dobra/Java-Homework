import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cursuri")
public class Curs {
	@Id
	@Column(name = "id_curs")
	private int id_curs;

	@Column(name = "denumire")
	private String denumire;

	@Column(name = "numar_ore")
	private int numar_ore;

	@Column(name = "valoare")
	private int valoare;

	@Column(name = "diploma_absolvire")
	private String diploma_absolvire;

	@Column(name = "anul")
	private String anul;

	@ManyToOne
	@JoinColumn(name = "id_angajat")
	private Angajat anga;

	public Curs() {
	}

	public Curs(int id_angaj, int id_curs, String denumire, int nr_ore, int valoare, String diploma_absolvire,
			String anul) {
		super();
		this.id_curs = id_curs;
		this.denumire = denumire;
		this.numar_ore = numar_ore;
		this.valoare = valoare;
		this.diploma_absolvire = diploma_absolvire;
		this.anul = anul;
	}


	public int getid_curs() {
		return id_curs;
	}

	public void setid_curs(int id_curs) {
		this.id_curs = id_curs;
	}

	public String getdenumire() {
		return denumire;
	}

	public void setdenumire(String denumire) {
		this.denumire = denumire;
	}

	public int getnumar_ore() {
		return numar_ore;
	}

	public void setnumar_ore(int numar_ore) {
		this.numar_ore = numar_ore;
	}

	public int getvaloare() {
		return valoare;
	}

	public void setvaloare(int valoare) {
		this.valoare = valoare;
	}

	public Angajat getanga() {
		return anga;
	}

	public void setanga(Angajat anga) {
		this.anga = anga;
	}

	public String toString() {
		return anga.getId() + ", " + id_curs + ", " + denumire + ", " + denumire + ", " + diploma_absolvire + ", "
				+ numar_ore;
	}
}