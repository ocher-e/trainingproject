package by.academy.timetable.service;

import by.academy.timetable.configuration.SpringJPAConfig;
import by.academy.timetable.model.Admin;
import by.academy.timetable.model.Professor;
import by.academy.timetable.model.User;
import by.academy.timetable.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        User user = userRepository.findUserByLogin(username);
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringJPAConfig.class);
//        UserService userService = context.getBean(UserService.class);
//        User user = userService.fingByLogin(username);
        
        
        if(user != null) {
            if(user instanceof Admin) grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            if(user instanceof Professor) grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);
        }
        
        throw new UsernameNotFoundException("User not found");
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
