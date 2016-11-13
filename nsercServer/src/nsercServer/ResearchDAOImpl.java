package nsercServer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class ResearchDAOImpl implements ResearchDAO{
	private JdbcTemplate jdbcTemplate;
	
	public ResearchDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("Constructor");
    }
	
	@Override
	public List<Research> list() {
		String sql = "SELECT * FROM nserc.award";
		List<Research> researchList = jdbcTemplate.query(sql, new RowMapper<Research>() {
			@Override
			public Research mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Research aResearch = new Research();
	            
	    		aResearch.title = rs.getString("title");
				aResearch.cYear = rs.getInt("cYear");
				aResearch.fYear = rs.getInt("fYear");
				aResearch.name = rs.getString("name");
				aResearch.institution = rs.getString("institution");
				aResearch.department = rs.getString("department");
				aResearch.province = rs.getString("province");
				aResearch.amount = rs.getInt("amount");
				aResearch.installment = rs.getString("installment");
				aResearch.program = rs.getString("program");
				aResearch.committee = rs.getString("committee");
				aResearch.subject = rs.getString("subject");
				aResearch.AOA = rs.getString("AOA");
				aResearch.coresearchers = rs.getString("coresearchers");
				aResearch.partners = rs.getString("partners");
				aResearch.summary = rs.getString("summary");
				
	            return aResearch;
	        }
		});
		System.out.println(researchList.size());
		System.out.println("Hey, yo!!!!!!!");
		return researchList;
	}
	
	@Override
	public Research get(String title) {
		String sql = "SELECT * FROM nserc.award WHERE title=" + title;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Research>() {
	 
	        @Override
	        public Research extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Research contact = new Research(rs.getString("title"),
				rs.getInt("cYear"),
				rs.getInt("fYear"),
				rs.getString("name"),
				rs.getString("institution"),
				rs.getString("department"),
				rs.getString("province"),
				rs.getInt("amount"),
				rs.getString("installment"),
				rs.getString("program"),
				rs.getString("committee"),
				rs.getString("subject"),
				rs.getString("AOA"),
				rs.getString("coresearchers"),
				rs.getString("partners"),
				rs.getString("summary"));
	                return contact;
	            }
	 
	            return null;
	        }
	 
	    });
	}
	
}
