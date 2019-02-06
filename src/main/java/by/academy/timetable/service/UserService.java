package by.academy.timetable.service;

import by.academy.timetable.model.User;
import by.academy.timetable.repository.UserRepository;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    
    @Transactional
    public void add(User u) {
        repository.save(u);
    }
    
    @Transactional
    public void addAll(Collection<User> users) {
        for(User u: users) {
            repository.save(u);
        }
    }
    
    @Transactional(readOnly = true)
    public List<User> listAll() {
        return (List<User>)repository.findAll();
    }
    
    @Transactional(readOnly = true)
    public User findUserByLoginAndPassword(String login, String password) {
        return repository.findUserByLoginAndPassword(login, password);
    }
    
    @Transactional(readOnly = true)
    public User findOne(Integer id) {
        return repository.findOne(id);
    }
    
    @Transactional(readOnly = true)
    public User findByName(String name) {
        return repository.findByName(name);
    }
    
    @Transactional(readOnly = true)
    public User findUserByLogin(String login) {
        return repository.findUserByLogin(login);
    }
    
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN') and #user.login != principal.username")
    public void delete(User user) {
        repository.delete(user);
    }
}
