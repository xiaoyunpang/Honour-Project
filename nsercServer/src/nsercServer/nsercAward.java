package nsercServer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class nsercAward {
	@Autowired
	private ResearchDAO researchDAO;
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public ModelAndView listResearches(ModelAndView model){
		researchDAO.resetPage();
	    List<Research> listResearches = researchDAO.list();
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", researchDAO.getPage());
	    model.setViewName("welcome");
	    return model;
	}
	
	@RequestMapping(value="/welcomeN", method = RequestMethod.GET)
	public ModelAndView nextListResearches(ModelAndView model){
	    List<Research> listResearches = researchDAO.next(0);
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", researchDAO.getPage());
	    model.setViewName("welcome");
	    return model;
	}
	
	@RequestMapping(value="/welcomeP", method = RequestMethod.GET)
	public ModelAndView previousListResearches(ModelAndView model){
	    List<Research> listResearches = researchDAO.prev(0);
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", researchDAO.getPage());
	    model.setViewName("welcome");
	    return model;
	}
	
	@RequestMapping(value="/welcomeS", method = RequestMethod.POST)
	public ModelAndView titleSearchListResearches(@RequestParam("title") String title,ModelAndView model){
		researchDAO.resetPage();
	    List<Research> listResearches = researchDAO.titleSearchList(title);
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", researchDAO.getPage());
	    model.setViewName("welcome");
	    return model;
	}
	
	@RequestMapping("/about")
	public ModelAndView about(ModelAndView model){
		model.setViewName("about");
	    return model;
	}
	
	@RequestMapping(value="/year", method = RequestMethod.GET)
	public ModelAndView yearListResearches(ModelAndView model){
		researchDAO.resetPage();
	    List<Research> listResearches = researchDAO.yearList();
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", researchDAO.getPage());
	    model.setViewName("year");
	    return model;
	}
	
	@RequestMapping(value="/yearP", method = RequestMethod.GET)
	public ModelAndView yearPrevListResearches(ModelAndView model){
	    List<Research> listResearches = researchDAO.prev(1);
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", researchDAO.getPage());
	    model.setViewName("year");
	    return model;
	}
	
	@RequestMapping(value="/yearN", method = RequestMethod.GET)
	public ModelAndView yearNextListResearches(ModelAndView model){
	    List<Research> listResearches = researchDAO.next(1);
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", researchDAO.getPage());
	    model.setViewName("year");
	    return model;
	}
	
	@RequestMapping(value="/yearS", method = RequestMethod.POST)
	public ModelAndView yearSearchListResearches(@RequestParam("cyear") String cyear,ModelAndView model){
		int year = -1;
		try{
			year = Integer.parseInt(cyear);
		}
		catch (Exception e){}
		researchDAO.resetPage();
	    List<Research> listResearches = researchDAO.yearSearchList(year);
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", researchDAO.getPage());
	    model.setViewName("year");
	    return model;
	}
	
	@RequestMapping(value="/institution", method = RequestMethod.GET)
	public ModelAndView institutionListResearches(ModelAndView model){
		researchDAO.resetPage();
	    List<Research> listResearches = researchDAO.list();
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", researchDAO.getPage());
	    model.setViewName("institution");
	    return model;
	}
	
	@RequestMapping(value="/institutionN", method = RequestMethod.GET)
	public ModelAndView nextInstitutionListResearches(ModelAndView model){
	    List<Research> listResearches = researchDAO.next(0);
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", researchDAO.getPage());
	    model.setViewName("institution");
	    return model;
	}
	
	@RequestMapping(value="/institutionP", method = RequestMethod.GET)
	public ModelAndView previousInstitutionListResearches(ModelAndView model){
	    List<Research> listResearches = researchDAO.prev(0);
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", researchDAO.getPage());
	    model.setViewName("institution");
	    return model;
	}

}
