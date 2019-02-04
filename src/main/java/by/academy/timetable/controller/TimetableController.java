package by.academy.timetable.controller;

import by.academy.timetable.model.TimetableSystem;
import by.academy.timetable.model.User;
import by.academy.timetable.service.TimetableSystemService;
import by.academy.timetable.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TimetableController {
    
    @Autowired
    TimetableSystemService timetableService;
    
    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "home";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/login?logout";
    }    
    
    @RequestMapping(value = "/timetable", method = RequestMethod.GET)
    public String getTimetable(ModelMap model) {
        model.addAttribute("myTimetable", timetableService.findOne(1));
        return "timetable";
    }
    
    @RequestMapping(value = "/settimetable", method = RequestMethod.GET)
    public String newProperties(ModelMap model) {
        TimetableSystem timetable = new TimetableSystem();
        model.addAttribute("timetableData", timetable);
        return "settimetable";
    }

    @RequestMapping(value="/settimetable", method = RequestMethod.POST)
    public String addProperties(@Valid @ModelAttribute("timetableData") TimetableSystem timetable, BindingResult result, ModelMap model) {
        if(result.hasErrors()) {
            return "settimetable";
        }
        timetable.setTimetableId(1);
        timetableService.add(timetable);
        model.addAttribute("success", "Completed successfully."
                + " Count of rooms =" + timetable.getCountOfRooms() 
                + "; Pairs a day =" + timetable.getPairsInDay()
                + "; Workdays a week = " + timetable.getWorkDaysInWeek());
        return "successAction";
    }
    
}
