package by.academy.timetable.controller;

import by.academy.timetable.model.Professor;
import by.academy.timetable.service.ProfessorService;
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

    @Autowired
    ProfessorService professorService;
    
    @RequestMapping(value = "/show-gr-{numb}", method = RequestMethod.GET)
    public String sheduleForGroup(@PathVariable int numb, ModelMap model) {
        if(sheduleService.week4Group(numb) == null) {
            model.addAttribute("sheduleIsNotFormed", true);
        } else {
            model.addAttribute("sheduleIsNotFormed", false);
            model.addAttribute("grnum", numb);
            // fix it
            model.addAttribute("aud", numb);
            model.addAttribute("all", sheduleService.week4Group(numb));
        }
        return "groupShedule";
    }
    
    
    @RequestMapping(value = "/show-prof/{profLogin}", method = RequestMethod.GET)
    public String sheduleForProfessorInAllGroups(@PathVariable String profLogin, ModelMap model) {
        Professor currentProfessor = professorService.findProfessorByLogin(profLogin);
        if(sheduleService.week4Group(1)== null) {
            model.addAttribute("shedule1IsNotFormed", true);
        } else {
            model.addAttribute("shedule1IsNotFormed", false);
            model.addAttribute("week4Group1", sheduleService.week4Group(1));
            model.addAttribute("professorIsInThisShedule1", sheduleService.included(sheduleService.week4Group(1), currentProfessor));
        }
        
        if(sheduleService.week4Group(2)== null) {
            model.addAttribute("shedule2IsNotFormed", true);
        } else {
            model.addAttribute("shedule2IsNotFormed", false);
            model.addAttribute("week4Group2", sheduleService.week4Group(2));
            model.addAttribute("professorIsInThisShedule2", sheduleService.included(sheduleService.week4Group(2), currentProfessor));
        }
        return "profShedule";
    }

    
}
