package nsercServer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController {
	
	@Autowired
	private InstitutionDAO institutionDAO;
	
	@RequestMapping(value="/summary", method = RequestMethod.GET)
	public ModelAndView listSummary(ModelAndView model){
		institutionDAO.resetPage();
	    List<Institution> listResearches = institutionDAO.list();
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", institutionDAO.getPage());
	    model.setViewName("summary");
	    return model;
	}
	
	@RequestMapping(value="/summaryN", method = RequestMethod.GET)
	public ModelAndView nextListSummary(ModelAndView model){
	    List<Institution> listResearches = institutionDAO.next();
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", institutionDAO.getPage());
	    model.setViewName("summary");
	    return model;
	}
	
	@RequestMapping(value="/summaryP", method = RequestMethod.GET)
	public ModelAndView prevListSummary(ModelAndView model){
	    List<Institution> listResearches = institutionDAO.prev();
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", institutionDAO.getPage());
	    model.setViewName("summary");
	    return model;
	}
	
	@RequestMapping(value="/summaryO", method = RequestMethod.GET)
	public ModelAndView orderListSummary(ModelAndView model){
		institutionDAO.resetPageOnly();
	    List<Institution> listResearches = institutionDAO.reverseList();
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", institutionDAO.getPage());
	    model.setViewName("summary");
	    return model;
	}

}
