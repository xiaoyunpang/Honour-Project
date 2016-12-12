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
		// get competition year list
		List<Integer> cyearList = researchDAO.getCyearList();
		model.addObject("cyearList", cyearList);
		model.addObject("selectedCyear", "");
		// get lead name list
		List<String> dpartmentList = researchDAO.getDepartmentList();
		model.addObject("dpartmentList", departmentList);
		model.addObject("selectedDepartment", "");
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
				List<String> departmentList = researchDAO.getDepartmentList();
				model.addObject("departmentList", departmentList);
				if((departmentList.size()==0)||(!researchDAO.getCurrentDepartment().equals("")&&(!departmentList.get(0).equals("")))) departmentList.add(0, "");
				model.addObject("selectedDepartment", researchDAO.getCurrentDepartment());
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
	    List<Research> listResearches = researchDAO.next();
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
		model.addObject("departmentList", researchDAO.getPrevDepartment());
		model.addObject("selectedDepartment", researchDAO.getCurrentDepartment());
		// get province list
		model.addObject("provinceList", researchDAO.getPrevProvince());
		model.addObject("selectedProvince", researchDAO.getPrevProvince());
		// get institutions list
		model.addObject("institutionList", researchDAO.getPrevInstitution());
		model.addObject("selectedInstitution", researchDAO.getCurrentInstitution());
		// get result list
	    List<Research> listResearches = researchDAO.prev();
	    model.addObject("listResearches", listResearches);
	    model.addObject("pageNum", researchDAO.getPage());
	    model.setViewName("welcome");
	    return model;
	}
	
	@RequestMapping(value="/welcomeS", method = RequestMethod.POST)
	public ModelAndView titleSearchListResearches(@RequestParam("cyear") String inputCyear,
			@RequestParam("department") String inputDepartment,
			@RequestParam("province") String inputProvince,
			@RequestParam("institution") String inputinstitution,
			ModelAndView model){
		researchDAO.setPage(1);
	    researchDAO.update(inputCyear, inputDepartment, inputProvince, inputinstitution);
		// get competition year list
		List<Integer> cyearList = researchDAO.getCyearList();
		model.addObject("cyearList", cyearList);
		if((cyearList.size()==0)||(researchDAO.getCurrentCyear()!=-1)&&(cyearList.get(0)!=-1)) cyearList.add(0, -1);
		model.addObject("selectedCyear", (researchDAO.getCurrentCyear() == -1) ? "" : researchDAO.getCurrentCyear());
		// get lead name list
		List<String> departmentList = researchDAO.getDepartmentList();
		model.addObject("departmentList", departmentList);
		if((departmentList.size()==0)||(!researchDAO.getCurrentDepartment().equals("")&&(!departmentList.get(0).equals("")))) departmentList.add(0, "");
		model.addObject("selectedDepartment", researchDAO.getCurrentDepartment());
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

}
