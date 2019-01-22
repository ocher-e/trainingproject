package by.academy.timetable.controller;

import by.academy.timetable.model.Professor;
import by.academy.timetable.service.ProfessorService;
import by.academy.timetable.service.TimetableSystemService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfessorController {
    
    @Autowired
    ProfessorService professorService;
    
    @Autowired
    TimetableSystemService timetableService;

    @RequestMapping(value = "/professors", method = RequestMethod.GET)
    public String allProfessors(ModelMap model) {
        model.addAttribute("professorList", professorService.listAll());
        return "professors";
    }
    
    @RequestMapping(value = "/addprofessor", method = RequestMethod.GET)
    public String newProfessor(ModelMap model) {
        Professor professor = new Professor();
        model.addAttribute("newProfessor", professor);
        return "addprof";
    }

    @RequestMapping(value="/addprofessor", method = RequestMethod.POST)
    public String addProfessor(@Valid @ModelAttribute("newProfessor") Professor professor, BindingResult result, ModelMap model) {
        
        if (result.hasErrors()) {
			return "addprof";
		}
        
        professor.setTimetable(timetableService.findOne(1));
        professorService.add(professor);
        model.addAttribute("success", professor.getName()
                        + " entering completed successfully");
        return "successAction";
    }
}
