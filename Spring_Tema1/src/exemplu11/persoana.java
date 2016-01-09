package exemplu11;

class Persoana 
{
	private String nume;
	private int varsta;
	public Persoana(){}
	public Persoana(String nume,int varsta) 
	{
		this.nume= nume;
		this.varsta= varsta;
	}
	@Override
	public String toString() {return nume+", "+varsta;}
}


class Angajat extends Persoana
{
	private int vechime;
	public Angajat(){}
	public Angajat(String nume, int varsta,int vechime) 
	{
		super(nume, varsta);
		this.vechime= vechime;
	}
	@Override
	public String toString() 
	{
		return  super.toString()+", "+vechime;
	}
}