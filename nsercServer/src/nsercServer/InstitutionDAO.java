package nsercServer;

import java.util.List;
import nsercServer.Institution;


public interface InstitutionDAO {
	public List<Institution> list();
	public List<Institution> orderList();
	public List<Institution> reverseList();
	public List<Institution> next();
	public List<Institution> prev();
	
	public int getPage();
	public void resetPage();
	public void resetPageOnly();

}
