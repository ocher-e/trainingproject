package by.academy.timetable.controller;

import by.academy.timetable.model.User;
import by.academy.timetable.service.RequestService;
import by.academy.timetable.service.TimetableSystemService;
import by.academy.timetable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    
    @Autowired
    TimetableSystemService timetableService;
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String allUsers(ModelMap model) {
            model.addAttribute("userList", userService.listAll());
            return "users";
    }
    
    @RequestMapping(value="/deleteUser-{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id) { 
        userService.deleteUser(id);
        return "redirect:/users";
    }
}