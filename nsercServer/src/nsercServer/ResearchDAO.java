package nsercServer;
import java.util.List;
import nsercServer.Research;

public interface ResearchDAO {
	public List<Research> list();
	
	public Research get(String title);

}
