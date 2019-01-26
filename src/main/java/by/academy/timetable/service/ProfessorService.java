package by.academy.timetable.service;

import by.academy.timetable.model.Professor;
import by.academy.timetable.repository.ProfessorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfessorService {
    
    @Autowired
    ProfessorRepository repository;
    
    @Transactional
    public void add(Professor p) {
        repository.save(p);
    }
    
    @Transactional(readOnly = true)
    public List<Professor> listAll() {
        return (List<Professor>) repository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Professor findOne(Integer id) {
        return repository.findOne(id);
    }
    
    @Transactional(readOnly = true)
    public Professor findProfessorByLogin(String login) {
        return repository.findProfessorByLogin(login);
    }
}
