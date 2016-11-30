package nsercServer;
import java.util.List;
import nsercServer.Research;

public interface ResearchDAO {
	public List<Research> list();
	public List<Research> titleSearchList(String title);
	public List<Research> next(int ind);
	public List<Research> prev(int ind);
	public List<Research> yearList();
	public List<Research> yearSearchList(int year);
	
	
	public int getPage();
	public void resetPage();

}
