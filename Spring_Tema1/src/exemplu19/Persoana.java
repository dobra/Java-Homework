package exemplu19;

import javax.annotation.*;
	
class Persoana 
{
	private String nume;
	
	@Resource (name="job1")
	private Job job;
	
	public Persoana(){}
	public String getNume() 
	{
		return nume;
	}
	public void setNume(String nume) 
	{
		this.nume= nume;
	}
	public Job getJob() 
	{
		return job;
	}
	public void setJob(Job job) 
	{
		this.job= job;
	}
	public String toString() 
	{
		return nume+", "+job;
	}
	@PostConstruct
	public void init()
	{
		System.out.println("init()");
	}
	@PreDestroy
	public void destroy()
	{
		System.out.println("destroy()");
	}
}