package nsercServer;

import java.util.ArrayList;
import java.util.List;
import inm.iql.ResultSet;
import inm.object.instance.Instance;
import inm.client.InmTemplate;

public class ResearchDAOImpl implements ResearchDAO{
	private InmTemplate inm;
	private int page;
	private int Cyear;
	
	public ResearchDAOImpl(InmTemplate dataSource) {
		page = 1;
		Cyear = -1;
		inm = dataSource;
    }
	
	@Override
	public List<Research> list() {
		String sql = "query Award $x("+((page-1)*10+1)+", 10) construct $x[];";
		ResultSet res = inm.executeQuery(sql);
		List<Research> researchList = new ArrayList<Research>();
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
			}
		return researchList;
	}
	
	@Override
	public List<Research> yearList() {
		String sql = "query Award $x("+((page-1)*10+1)+", 10) construct $x[];";
		ResultSet res = inm.executeQuery(sql);
		List<Research> researchList = new ArrayList<Research>();
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
			}
		return researchList;
	}
	
	@Override
	public List<Research> yearSearchList(int year) {
		Cyear = year;
		String sql = "query Award $x/competitionYear:$y="+year+" construct $x[] top("+((page-1)*10+1)+",10);";
		ResultSet res = inm.executeQuery(sql);
		List<Research> researchList = new ArrayList<Research>();
		if(res.hasNext()){
			if(res.valueSize()<10)
				page--;
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
				}
		}
		return researchList;
	}
	
	@Override
	public List<Research> next(int ind) {
		page++;
		if (page > 50578)
			page = 50578;
		if(ind == 1){
			if(Cyear > -1)
				return yearSearchList(Cyear);
			return yearList();
		}
		return list();
	}
	
	@Override
	public List<Research> prev(int ind) {
		page--;
		if (page < 1) 
			page = 1;
		if(ind == 1) {
			if(Cyear > -1)
				return yearSearchList(Cyear);
			return yearList();
		}
		return list();
	}
	
	@Override
	public int getPage(){ return page; }
	
	@Override
	public void resetPage(){ page = 1; Cyear = -1;}
	
}
