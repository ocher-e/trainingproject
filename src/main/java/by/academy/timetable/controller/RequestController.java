package by.academy.timetable.controller;

import by.academy.timetable.model.Professor;
import by.academy.timetable.model.Request;
import by.academy.timetable.service.ProfessorService;
import by.academy.timetable.service.RequestService;
import by.academy.timetable.service.SheduleService;
import by.academy.timetable.service.TimetableSystemService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestController {
    @Autowired
    RequestService requestService;
    
    @Autowired
    TimetableSystemService timetableService;
    
    @Autowired
    ProfessorService professorService;
    
    @Autowired
    SheduleService sheduleService;

    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public String allRequests(ModelMap model) {
        model.addAttribute("requestList", requestService.listAll());
        return "requests";
    }
    
    @RequestMapping(value = "/addrequest", method = RequestMethod.GET)
    public String newRequest(ModelMap model) {
        Request request = new Request();
        model.addAttribute("newRequest", request);
        return "addrequest";
    }

    @RequestMapping(value="/addrequest", method = RequestMethod.POST)
    public String addRequest(@Valid @ModelAttribute("newRequest") Request request, BindingResult result, ModelMap model) { 
        if (result.hasErrors()) {
            return "addrequest";
	}
        String currentProfLogin = ControllerUtil.getPrincipal();
        Professor currentProf = professorService.findProfessorByLogin(currentProfLogin);
        request.setRequester(currentProf);
        requestService.add(request);
        model.addAttribute("success", "Entering request for " + request.getDiscipline()
                        + " completed successfully");
        return "successAction";
    }
    
    @RequestMapping(value = "/delete-request-{requestId}", method = RequestMethod.GET)
    public String delRequest(@PathVariable int requestId, ModelMap model) {
        requestService.deleteRequest(requestService.findOne(requestId));
        return "redirect:/requests";
    }
    
    @RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
            return "noCredentials";
	}
}
