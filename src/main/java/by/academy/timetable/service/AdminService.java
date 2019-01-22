package by.academy.timetable.service;

import by.academy.timetable.model.Admin;
import by.academy.timetable.repository.AdminRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {
    @Autowired
    AdminRepository repository;
    
    @Transactional
    public void add(Admin a) {
        repository.save(a);
    }
    
    @Transactional(readOnly = true)
    public List<Admin> listAll() {
        return (List<Admin>) repository.findAll();
    }
}
