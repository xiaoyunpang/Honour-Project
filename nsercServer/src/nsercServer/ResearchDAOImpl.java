package nsercServer;

import java.util.ArrayList;
import java.util.List;

import inm.iql.ResultSet;
import inm.object.instance.Instance;
import inm.client.InmTemplate;

public class ResearchDAOImpl implements ResearchDAO{
	private InmTemplate inm;
	private int page;
	private int currentPageSize;
	
	private int cYear;
	private String leadname;
	private String province;
	private String institution;
	public int statusCyear, statusLeadname, statusProvince, statusInstitution;
	
	private List<Integer> prevCyear;
	private List<String> prevLeadname;
	private List<String> prevProvince;
	private List<String> prevInstitution;
	
	public ResearchDAOImpl(InmTemplate dataSource) {
		page = 1;
		currentPageSize = 0;
		
		cYear = -1;
		leadname = "";
		province = "";
		institution = "";
		statusCyear = statusLeadname = statusProvince = statusInstitution = 0;
		prevCyear = new ArrayList<Integer>();
		prevLeadname = new ArrayList<String>();
		prevProvince = new ArrayList<String>();
		prevInstitution = new ArrayList<String>();
		inm = dataSource;
    }
	
	@Override
	public List<Research> list() {
		String c="",n="",p="",in = "", fi = "";
		if(this.cYear!=-1) { c = "$x/competitionYear:$c="+cYear+","; }
		if(!leadname.equals("")) { n = "$x/department:$n=\""+leadname+"\","; }
		if(!province.equals("")) { p = "$x/province:$p=\""+province+"\","; }
		if(!institution.equals("")) { in = "$x/institution:$i=\""+institution+"\","; }	
		String iql = "query Award $x("+((page-1)*10+1)+",10) construct $x[];";
		if(!((c+n+p+in).equals(""))) {
			fi = (c+n+p+in).substring(0, (c+n+p+in).length()-1);
			iql = "query Award "+fi+" construct $x[] top("+((page-1)*10+1)+",10);";
		}
		ResultSet res = inm.executeQuery(iql);
		List<Research> researchList = new ArrayList<Research>();
		if(res.variableSize()>0&&res.valueSize()>0) {
			currentPageSize = res.valueSize();
			for(int i=0;i<res.valueSize();i++) {
				Instance inst = res.getInstance(i);
				Research aResearch = new Research();
				aResearch.setTitle(inst.getSonValue("title"));
				aResearch.setcYear(inst.getSonIntegerValue("competitionYear"));
				aResearch.setfYear(inst.getSonValue("fiscalYear"));
				aResearch.setName(inst.getSonValue("leadName"));
				aResearch.setInstitution(inst.getSonValue("institution"));
				aResearch.setDepartment(inst.getSonValue("department"));
				aResearch.setProvince(inst.getSonValue("province"));
				aResearch.setamount(inst.getSonIntegerValue("amount"));
				aResearch.setInstallment(inst.getSonValue("installment"));
				aResearch.setProgram(inst.getSonValue("program"));
				aResearch.setCommittee(inst.getSonValue("committee"));
				aResearch.setSubject(inst.getSonValue("subject"));
				aResearch.setAOA(inst.getSonValue("areaOfApplication"));
				aResearch.setCoresearchers(inst.getSonValue("coresearchers"));
				aResearch.setPartners(inst.getSonValue("partners"));
				aResearch.setSummary(inst.getSonValue("summary"));
				researchList.add(aResearch);
			}
		}
		return researchList;
	}
	
	@Override
	public List<Research> next() {
		if(this.currentPageSize != 10)
			return list();
		page++;
		if (page > 50578)
			page = 50578;
		return list();
	}
	
	@Override
	public List<Research> prev() {
		page--;
		if (page < 1) 
			page = 1;
		return list();
	}
	
	@Override
	public int getPage(){
		if(page < 1)
			return 1;
		return page;
		}
	
	@Override
	public int getCurrentCyear(){ return this.cYear; }
	@Override
	public String getCurrentLname(){ return this.leadname; }
	@Override
	public String getCurrentProvince(){ return this.province; }
	@Override
	public String getCurrentInstitution(){ return this.institution; }
	
	@Override
	public List<Integer> getPrevCyear(){ return this.prevCyear; }
	@Override
	public List<String> getPrevLname(){ return this.prevLeadname; }
	@Override
	public List<String> getPrevProvince(){ return this.prevProvince; }
	@Override
	public List<String> getPrevInstitution(){ return this.prevInstitution; }
	
	@Override
	public void setPage(int p){ page = p;}
	@Override
	public void resetPage(){ page = 1; currentPageSize = 0; cYear = -1;
	leadname = "";
	province = "";
	institution = "";
	statusCyear = statusLeadname = statusProvince = statusInstitution = 0;
	prevCyear.clear();
	prevLeadname.clear();
	prevProvince.clear();
	prevInstitution.clear();}
	
	@Override
	public void update(String inputCyear, String inputLname,
			String inputProvince, String inputinstitution) {
		int year;
		if(inputCyear.equals("")) year = -1; else year = Integer.parseInt(inputCyear);
		if(cYear == year) this.statusCyear = 0; else { cYear = year; this.statusCyear = 1; }
		if(leadname.equals(inputLname)) this.statusLeadname = 0; else { leadname = inputLname; this.statusLeadname = 1; }
		if(province.equals(inputProvince)) this.statusProvince = 0; else { province = inputProvince; this.statusProvince = 1; }
		if(institution.equals(inputinstitution)) this.statusInstitution = 0; else { institution = inputinstitution; this.statusInstitution = 1; }
	}
	
	@Override
	public List<Integer> getCyearList() {
		String iql = "query Cyear $x/competitionYear: $y construct $y order by $y asc;";
		List<Integer> cyearList = new ArrayList<Integer>();
		if(this.statusCyear == 1)
			return this.prevCyear;
		if((statusCyear==0&&statusInstitution==0&&statusLeadname==0&&statusProvince==0)&&
				(cYear!=-1||(!leadname.equals(""))||(!province.equals(""))||(!institution.equals(""))))
			return this.prevCyear;
		ResultSet res;
		if(statusInstitution==1||statusLeadname==1||statusProvince==1) {
			String n="",p="",in = "";
			if(!leadname.equals("")) { n = "$x/leadName:$n=\""+leadname+"\","; }
			if(!province.equals("")) { p = "$x/province:$p=\""+province+"\","; }
			if(!institution.equals("")) { in = "$x/institution:$i=\""+institution+"\","; }	
			if(!((n+p+in).equals(""))) 
				iql = "query Cyear "+n+p+in+" $x/competitionYear:$c construct $c order by $c asc;";
			res = inm.executeQuery(iql);
			if(res.variableSize()>0&&res.valueSize()>0) {
				for(int i=0;i<res.valueSize();i++) {
					cyearList.add(res.getInteger(i));
				}
			}
			this.prevCyear = cyearList;
			return cyearList;
		}
		res = inm.executeQuery(iql);
		if(res.variableSize()>0&&res.valueSize()>0) {
			for(int i=0;i<res.valueSize();i++) {
				cyearList.add(res.getInteger(i));
			}
		}
		this.prevCyear = cyearList;
		return cyearList;
	}
	
	@Override
	public List<String> getLnameList() {
		String iql = "query Leadname $x/leadName: $y construct $y order by $y asc;";
		List<String> lnameList = new ArrayList<String>();
		if(this.statusLeadname == 1)
			return prevLeadname;
		if((statusCyear==0&&statusInstitution==0&&statusLeadname==0&&statusProvince==0)&&
				(cYear!=-1||(!leadname.equals(""))||(!province.equals(""))||(!institution.equals(""))))
			return prevLeadname;
		ResultSet res;
		if(statusInstitution==1||statusCyear==1||statusProvince==1) {
			String c="",p="",in = "";
			if(cYear!=-1) { c = "$x/competitionYear:$c="+cYear+","; }
			if(!province.equals("")) { p = "$x/province:$p=\""+province+"\","; }
			if(!institution.equals("")) { in = "$x/institution:$i=\""+institution+"\","; }	
			if(!((c+p+in).equals(""))) 
				iql = "query Leadname "+c+p+in+" $x/leadName:$n construct $n order by $n asc;";
			res = inm.executeQuery(iql);
			if(res.variableSize()>0&&res.valueSize()>0) {
				for(int i=0;i<res.valueSize();i++) {
					lnameList.add(res.getString(i));
				}
			}
			this.prevLeadname = lnameList;
			return lnameList;
		}
		res = inm.executeQuery(iql);
		if(res.variableSize()>0&&res.valueSize()>0) {
			for(int i=0;i<res.valueSize();i++) {
				lnameList.add(res.getString(i));
			}
		}
		this.prevLeadname = lnameList;
		return lnameList;
	}
	
	@Override
	public List<String> getProvinceList() {
		String iql = "query Province $x/province: $y construct $y order by $y asc;";
		List<String> provinceList = new ArrayList<String>();
		if(this.statusProvince == 1)
			return this.prevProvince;
		if((statusCyear==0&&statusInstitution==0&&statusLeadname==0&&statusProvince==0)&&
				(cYear!=-1||(!leadname.equals(""))||(!province.equals(""))||(!institution.equals(""))))
			return prevProvince;
		ResultSet res;
		if(statusInstitution==1||statusCyear==1||statusLeadname==1) {
			String c="",n="",in = "";
			if(cYear!=-1) { c = "$x/competitionYear:$c="+cYear+","; }
			if(!leadname.equals("")) { n = "$x/leadName:$n=\""+leadname+"\","; }
			if(!institution.equals("")) { in = "$x/institution:$i=\""+institution+"\","; }	
			if(!((c+n+in).equals(""))) 
				iql = "query Province "+c+n+in+" $x/province:$p construct $p order by $p asc;";
			res = inm.executeQuery(iql);
			if(res.variableSize()>0&&res.valueSize()>0) {
				for(int i=0;i<res.valueSize();i++) {
					provinceList.add(res.getString(i));
				}
			}
			this.prevProvince = provinceList;
			return provinceList;
		}
		res = inm.executeQuery(iql);
		if(res.variableSize()>0&&res.valueSize()>0) {
			for(int i=0;i<res.valueSize();i++) {
				provinceList.add(res.getString(i));
			}
		}
		this.prevProvince = provinceList;
		return provinceList;
	}
	
	@Override
	public List<String> getInstitutionList() {
		String iql = "query Institution $x/institution: $y construct $y order by $y asc;";
		List<String> institutionList = new ArrayList<String>();
		if(this.statusInstitution == 1)
			return this.prevInstitution;
		if((statusCyear==0&&statusInstitution==0&&statusLeadname==0&&statusProvince==0)&&
				(cYear!=-1||(!leadname.equals(""))||(!province.equals(""))||(!institution.equals(""))))
			return prevInstitution;
		ResultSet res;
		if(statusProvince==1||statusCyear==1||statusLeadname==1) {
			String c="",n="",p = "";
			if(cYear!=-1) { c = "$x/competitionYear:$c="+cYear+","; }
			if(!leadname.equals("")) { n = "$x/leadName:$n=\""+leadname+"\","; }
			if(!province.equals("")) { p = "$x/province:$p=\""+province+"\","; }	
			if(!((c+n+p).equals(""))) 
				iql = "query Institution "+c+n+p+" $x/institution:$i construct $i order by $i asc;";
			res = inm.executeQuery(iql);
			if(res.variableSize()>0&&res.valueSize()>0) {
				for(int i=0;i<res.valueSize();i++) {
					institutionList.add(res.getString(i));
				}
			}
			this.prevInstitution = institutionList;
			return institutionList;
		}
		res = inm.executeQuery(iql);
		if(res.variableSize()>0&&res.valueSize()>0) {
			for(int i=0;i<res.valueSize();i++) {
				institutionList.add(res.getString(i));
			}
		}
		this.prevInstitution = institutionList;
		return institutionList;
	}
	
}
