package nsercServer;
import java.util.List;
import nsercServer.Research;

public interface ResearchDAO {
	public List<Research> list();
	public List<Research> next();
	public List<Research> prev();
	
	public List<Integer> getCyearList();
	public List<String> getDepartmentList();
	public List<String> getProvinceList();
	public List<String> getInstitutionList();
	
	public void update(String inputCyear, String inputDepartment,
			String inputProvince, String inputinstitution);
	
	
	public int getPage();
	public void resetPage();
	public void setPage(int p);
	public int getCurrentCyear();
	public String getCurrentDepartment();
	public String getCurrentProvince();
	public String getCurrentInstitution();
	
	public List<Integer> getPrevCyear();
	public List<String> getPrevDepartment();
	public List<String> getPrevProvince();
	public List<String> getPrevInstitution();

}
