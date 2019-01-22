package by.academy.timetable.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
                        .antMatchers("/show-prof/**").access("hasRole('ROLE_USER')")
			.antMatchers("/addrequest/**").access("hasRole('ROLE_USER')")
                        .antMatchers("/settimetable/**").access("hasRole('ROLE_ADMIN')")
                        .antMatchers("/addprofessor/**").access("hasRole('ROLE_ADMIN')")
                        .antMatchers("/show-gr-1/**").access("hasRole('ROLE_ADMIN')")
                        .antMatchers("/show-gr-2/**").access("hasRole('ROLE_ADMIN')")
                        .antMatchers("/successAction/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                        .antMatchers("/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.and().formLogin()
                        .and().exceptionHandling().accessDeniedPage("/denied");
	}
        
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
