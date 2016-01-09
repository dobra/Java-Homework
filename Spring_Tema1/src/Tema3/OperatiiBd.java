package Tema3;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
class OperatiiBd 
{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource= dataSource;
		this.jdbcTemplateObject= new JdbcTemplate(dataSource);
	}
	
	public void insert(String nr_inmatriculare,int anul,int culoare,int nr_km, String marca) 
	{
		String SQL = "insert into masini (nr_inmatriculare, anul, culoare, nr_km, marca) values (?, ?, ?, ?, ?)";
		jdbcTemplateObject.update( SQL, nr_inmatriculare,anul,culoare,nr_km, marca);
	}
	public void update(int id,String nr_inmatriculare,int anul,int culoare,int nr_km, String marca)
	{
		String SQL = "update masini set nr_inmatriculare = ?, anul = ?, culoare = ?, nr_km = ?, marca = ? where id = ?";
		jdbcTemplateObject.update(SQL, nr_inmatriculare,anul,culoare,nr_km, id, marca);
	}
	public void delete(String nr_inmatriculare)
	{
		String SQL = "delete from masini where nr_inmatriculare = ?";
		jdbcTemplateObject.update(SQL, nr_inmatriculare);
	}

	public	void getMasina(String nr_inmatriculare) 
	{
		String SQL ="select * from masini where nr_inmatriculare = ?";
		Masina mas = jdbcTemplateObject.queryForObject(SQL,	new	Object[]{nr_inmatriculare},new MasinaMapper());
		mas.toString();
	}
	public	List<Masina> getListaMasini() 
	{
		String SQL ="select * from masini";
		List <Masina> pers =	jdbcTemplateObject.query(SQL,new	MasinaMapper());
		return	pers;
	}
	
	public	List<Masina> getListaMasiniMarca(String marca) 
	{
		String SQL ="select * from masini where marca = ?";
		List <Masina> pers =	jdbcTemplateObject.query(SQL,new Object[]{marca},new	MasinaMapper());
		return	pers;
	}
		public	List<Masina> getListaMasiniAn() 
	{
		String SQL ="select * from masini where anul > 2010";
		List <Masina> pers =	jdbcTemplateObject.query(SQL,new	MasinaMapper());
		return	pers;
	}
}