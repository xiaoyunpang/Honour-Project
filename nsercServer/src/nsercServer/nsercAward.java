package nsercServer;
import java.util.ArrayList;
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
		// get competition year list
		List<Integer> cyearList = researchDAO.getCyearList();
		model.addObject("cyearList", cyearList);
		model.addObject("selectedCyear", "");
		// get lead name list
		List<String> lnameList = researchDAO.getLnameList();
		model.addObject("lnameList", lnameList);
		model.addObject("selectedLname", "");
		// get province list
		List<String> provinceList = researchDAO.getProvinceList();
		model.addObject("provinceList", provinceList);
		model.addObject("selectedProvince", "");
		// get institutions list
		List<String> institutionList = researchDAO.getInstitutionList();
		model.addObject("institutionList", institutionList);
		model.addObject("selectedInstitution", "");
		// get result list
	    List<Research> listResearches = researchDAO.list();
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", researchDAO.getPage());
	    model.setViewName("welcome");
	    return model;
	}
	
	@RequestMapping(value="/welcomeN", method = RequestMethod.GET)
	public ModelAndView nextListResearches(ModelAndView model){
		// get competition year list
				List<Integer> cyearList = researchDAO.getCyearList();
				model.addObject("cyearList", cyearList);
				if((cyearList.size()==0)||(researchDAO.getCurrentCyear()!=-1)&&(cyearList.get(0)!=-1)) cyearList.add(0, -1);
				model.addObject("selectedCyear", (researchDAO.getCurrentCyear() == -1) ? "" : researchDAO.getCurrentCyear());
				// get lead name list
				List<String> lnameList = researchDAO.getLnameList();
				model.addObject("lnameList", lnameList);
				if((lnameList.size()==0)||(!researchDAO.getCurrentLname().equals("")&&(!lnameList.get(0).equals("")))) lnameList.add(0, "");
				model.addObject("selectedLname", researchDAO.getCurrentLname());
				// get province list
				List<String> provinceList = researchDAO.getProvinceList();
				model.addObject("provinceList", provinceList);
				if((provinceList.size()==0)||(!researchDAO.getCurrentProvince().equals("")&&(!provinceList.get(0).equals("")))) provinceList.add(0, "");
				model.addObject("selectedProvince", researchDAO.getCurrentProvince());
				// get institutions list
				List<String> institutionList = researchDAO.getInstitutionList();
				model.addObject("institutionList", institutionList);
				if((institutionList.size()==0)||(!researchDAO.getCurrentInstitution().equals("")&&(!institutionList.get(0).equals("")))) institutionList.add(0, "");
				model.addObject("selectedInstitution", researchDAO.getCurrentInstitution());
				// get result list
	    List<Research> listResearches = researchDAO.next(0);
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", researchDAO.getPage());
	    model.setViewName("welcome");
	    return model;
	}
	
	@RequestMapping(value="/welcomeP", method = RequestMethod.GET)
	public ModelAndView previousListResearches(ModelAndView model){
		// get competition year list
		model.addObject("cyearList", researchDAO.getPrevCyear());
		model.addObject("selectedCyear", researchDAO.getCurrentCyear());
		// get lead name list
		model.addObject("lnameList", researchDAO.getPrevLname());
		model.addObject("selectedLname", researchDAO.getCurrentLname());
		// get province list
		model.addObject("provinceList", researchDAO.getPrevProvince());
		model.addObject("selectedProvince", researchDAO.getPrevProvince());
		// get institutions list
		model.addObject("institutionList", researchDAO.getPrevInstitution());
		model.addObject("selectedInstitution", researchDAO.getCurrentInstitution());
		// get result list
	    List<Research> listResearches = researchDAO.prev(0);
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", researchDAO.getPage());
	    model.setViewName("welcome");
	    return model;
	}
	
	@RequestMapping(value="/welcomeS", method = RequestMethod.POST)
	public ModelAndView titleSearchListResearches(@RequestParam("cyear") String inputCyear,
			@RequestParam("lname") String inputLname,
			@RequestParam("province") String inputProvince,
			@RequestParam("institution") String inputinstitution,
			ModelAndView model){
		researchDAO.setPage(1);
	    researchDAO.update(inputCyear, inputLname, inputProvince, inputinstitution);
		// get competition year list
		List<Integer> cyearList = researchDAO.getCyearList();
		model.addObject("cyearList", cyearList);
		if((cyearList.size()==0)||(researchDAO.getCurrentCyear()!=-1)&&(cyearList.get(0)!=-1)) cyearList.add(0, -1);
		model.addObject("selectedCyear", (researchDAO.getCurrentCyear() == -1) ? "" : researchDAO.getCurrentCyear());
		// get lead name list
		List<String> lnameList = researchDAO.getLnameList();
		model.addObject("lnameList", lnameList);
		if((lnameList.size()==0)||(!researchDAO.getCurrentLname().equals("")&&(!lnameList.get(0).equals("")))) lnameList.add(0, "");
		model.addObject("selectedLname", researchDAO.getCurrentLname());
		// get province list
		List<String> provinceList = researchDAO.getProvinceList();
		model.addObject("provinceList", provinceList);
		if((provinceList.size()==0)||(!researchDAO.getCurrentProvince().equals("")&&(!provinceList.get(0).equals("")))) provinceList.add(0, "");
		model.addObject("selectedProvince", researchDAO.getCurrentProvince());
		// get institutions list
		List<String> institutionList = researchDAO.getInstitutionList();
		model.addObject("institutionList", institutionList);
		if((institutionList.size()==0)||(!researchDAO.getCurrentInstitution().equals("")&&(!institutionList.get(0).equals("")))) institutionList.add(0, "");
		model.addObject("selectedInstitution", researchDAO.getCurrentInstitution());
		// get result list
		List<Research> listResearches = researchDAO.list();
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
