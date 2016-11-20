package nsercServer;

import java.util.ArrayList;
import java.util.List;
import inm.iql.ResultSet;
import inm.object.instance.Instance;
import inm.client.InmTemplate;

public class ResearchDAOImpl implements ResearchDAO{
	private InmTemplate inm;
	
	public ResearchDAOImpl(InmTemplate dataSource) {
		inm = dataSource;
        //jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("Constructor");
    }
	
	@Override
	public List<Research> list() {
		String sql = "query Award $x construct $x[] top(21,10);";
		ResultSet res = inm.executeQuery(sql);
		List<Research> researchList = new ArrayList<Research>();
		System.out.println(res.getInstance(1).getSonValue("title"));
		System.out.println(res.valueSize());
		//while(res.next()) {
			for(int i=0;i<res.valueSize();i++) {
				Instance inst = res.getInstance(i);
				Research aResearch = new Research();
				aResearch.title = inst.getSonValue("title");
				aResearch.cYear = inst.getSonIntegerValue("competitionYear");
				aResearch.fYear = inst.getSonValue("fiscalYear");
				aResearch.name = inst.getSonValue("leadName");
				aResearch.institution = inst.getSonValue("institution");
				aResearch.department = inst.getSonValue("department");
				aResearch.province = inst.getSonValue("province");
				aResearch.amount = inst.getSonIntegerValue("amount");
				aResearch.installment = inst.getSonValue("installment");
				aResearch.program = inst.getSonValue("program");
				aResearch.committee = inst.getSonValue("committee");
				aResearch.subject = inst.getSonValue("subject");
				aResearch.AOA = inst.getSonValue("areaOfApplication");
				aResearch.coresearchers = inst.getSonValue("coresearchers");
				aResearch.partners = inst.getSonValue("partners");
				aResearch.summary = inst.getSonValue("summary");
				researchList.add(aResearch);
				//System.out.println("Hey, yo!!!!!!!");
			}
		//}
		//System.out.println("Hey, yo!!!!!!!");
		return researchList;
	}
	
	@Override
	public Research get(String title) {
		//String sql = "SELECT * FROM nserc.award WHERE title=" + title;
	    //return jdbcTemplate.query(sql, new ResultSetExtractor<Research>() {
	 
	    //    @Override
	    //    public Research extractData(ResultSet rs) throws SQLException,
	    //            DataAccessException {
	    //        if (rs.next()) {
	    //            Research contact = new Research(rs.getString("title"),
		//		rs.getInt("cYear"),
		//		rs.getString("fYear"),
		//		rs.getString("name"),
		//		rs.getString("institution"),
		//		rs.getString("department"),
		//		rs.getString("province"),
		//		rs.getInt("amount"),
		//		rs.getS//tring("installment"),
		//		rs.getString("program"),
		//		rs.getString("committee"),
		//		rs.getString("subject"),
		//		rs.getString("AOA"),
		//		rs.getString("coresearchers"),
		//		rs.getString("partners"),
		//		rs.getString("summary"));
	    //            return contact;
	    //        }
	 //
	    //        return null;
	    //    }
	 //
	    //});
	//}
	return null;
	}
}
