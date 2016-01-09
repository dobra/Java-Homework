package Tema3;
import 	java.sql.ResultSet;
import	java.sql.SQLException;
import	org.springframework.jdbc.core.RowMapper;

public class MasinaMapper implements RowMapper<Masina> 
{
	public Masina mapRow(ResultSet rs,	int	rowNum) throws	SQLException 
	{	
		Masina masina = new Masina();
		masina.setId(rs.getInt(	"id"));
		masina.setNr_inmatriculare(rs.getString("nr_inmatriculare"));
		masina.setAnul(rs.getInt("anul"));
		masina.setCuloare(rs.getInt("culoare"));
		masina.setNr_km(rs.getInt("nr_km"));
		
		return	masina;
	}
}
