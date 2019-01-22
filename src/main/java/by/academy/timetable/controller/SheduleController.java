package by.academy.timetable.controller;

import by.academy.timetable.service.SheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SheduleController {
    @Autowired
    SheduleService sheduleService;

    
    @RequestMapping(value = "/show-gr-{numb}", method = RequestMethod.GET)
    public String sheduleForGroupd(@PathVariable int numb, ModelMap model) {
        model.addAttribute("grnum", numb);
        // fix it
        model.addAttribute("aud", numb);
        model.addAttribute("all", sheduleService.week4Group(numb));
        return "shedule";
    }
    
    
    @RequestMapping(value = "/show-prof", method = RequestMethod.GET)
    public String sheduleForProfessorInAllGroups(ModelMap model) {
        model.addAttribute("week4Group1", sheduleService.week4Group(1));
        model.addAttribute("week4Group2", sheduleService.week4Group(2));
        return "profShedule";
    }

}
