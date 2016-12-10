package nsercServer;
import java.util.List;
import nsercServer.Research;

public interface ResearchDAO {
	public List<Research> list();
	public List<Research> next();
	public List<Research> prev();
	
	public List<Integer> getCyearList();
	public List<String> getLnameList();
	public List<String> getProvinceList();
	public List<String> getInstitutionList();
	
	public void update(String inputCyear, String inputLname,
			String inputProvince, String inputinstitution);
	
	
	public int getPage();
	public void resetPage();
	public void setPage(int p);
	public int getCurrentCyear();
	public String getCurrentLname();
	public String getCurrentProvince();
	public String getCurrentInstitution();
	
	public List<Integer> getPrevCyear();
	public List<String> getPrevLname();
	public List<String> getPrevProvince();
	public List<String> getPrevInstitution();

}
