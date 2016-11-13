package nsercServer;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class nsercAward {
	@Autowired
	private ResearchDAO researchDAO;
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public ModelAndView listResearches(ModelAndView model){
		System.out.println("Hey, mapping!!!!!!!!!!");
	    List<Research> listResearches = researchDAO.list();
	    System.out.println(listResearches.get(1).title);
	    model.addObject("listResearches", listResearches);
	    model.setViewName("welcome");
	    //System.out.println(model.);
	 
	    return model;
	}

}
