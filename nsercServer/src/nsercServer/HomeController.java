package nsercServer;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController {
	
	@Autowired
	private ResearchDAO researchDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listResearches(ModelAndView model) throws IOException{
		System.out.println("Hey, mapping!!!!!!!!!!");
	    List<Research> listResearches = researchDAO.list();
	    model.addObject("listResearches", listResearches);
	    model.setViewName("index");
	 
	    return model;
	}

}
