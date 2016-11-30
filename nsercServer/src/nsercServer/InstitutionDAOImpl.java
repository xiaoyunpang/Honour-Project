package nsercServer;

import java.util.ArrayList;
import java.util.List;

import inm.client.InmTemplate;
import inm.iql.ResultSet;
import inm.object.instance.Instance;

public class InstitutionDAOImpl implements InstitutionDAO{
	private InmTemplate inm;
	private int page;
	private int order;
	
	public InstitutionDAOImpl(InmTemplate dataSource) {
		page = 1;
		order = -1;
		inm = dataSource;
    }
	
	@Override
	public List<Institution> list() {
		String iql = "query Institution $x("+((page-1)*10+1)+", 10) construct $x[];";
		ResultSet res = inm.executeQuery(iql);
		List<Institution> institutionList = new ArrayList<Institution>();
			for(int i=0;i<res.valueSize();i++) {
				Instance inst = res.getInstance(i);
				Institution instn = new Institution();
				instn.name = inst.getSonValue("names");
				instn.number = inst.getSonIntegerValue("number");
				instn.amount = inst.getSonIntegerValue("amount");
				instn.avg = instn.amount/instn.number;
				institutionList.add(instn);
			}
		return institutionList;
	}
	
	@Override
	public List<Institution> orderList() {
		String iql;
		if(order == 0)
			iql = "query Institution $x/number:$y construct $x[] order by $y asc/number: $y;";
		else
			iql = "query Institution $x/number:$y construct $x[] order by $y desc/number: $y;";
		ResultSet res = inm.executeQuery(iql);
		List<Institution> institutionList = new ArrayList<Institution>();
			for(int i=(page-1)*10;i<Math.min(10+(page-1)*10, 3714);i++) {
				Instance inst = res.getInstance(i);
				Institution instn = new Institution();
				instn.name = inst.getSonValue("names");
				instn.number = inst.getSonIntegerValue("number");
				instn.amount = inst.getSonIntegerValue("amount");
				instn.avg = instn.amount/instn.number;
				institutionList.add(instn);
			}
		return institutionList;
	}
	
	@Override
	public List<Institution> reverseList() {
		order = (order+1)%2;
		return orderList();
	}
	
	@Override
	public List<Institution> prev() {
		page--;
		if (page < 1) 
			page = 1;
		if(order!=-1)
			return orderList();
		return list();
	}
	
	@Override
	public List<Institution> next() {
		page++;
		if (page > 371) 
			page = 371;
		if(order!=-1)
			return orderList();
		return list();
	}
	
	@Override
	public int getPage() { return this.page; }
	
	@Override
	public void resetPage(){ page = 1; order = -1;}
	
	@Override
	public void resetPageOnly(){ page = 1;}
}
