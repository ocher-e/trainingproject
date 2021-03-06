package by.academy.timetable.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class ControllerUtil {
    public static String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
                userName = ((UserDetails)principal).getUsername();
        } else {
                userName = principal.toString();
        }
        return userName;
    }
}
