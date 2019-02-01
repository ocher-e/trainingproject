package by.academy.timetable.service;

import by.academy.timetable.model.TimetableSystem;
import by.academy.timetable.model.User;
import by.academy.timetable.repository.TimetableSystemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TimetableSystemService {
    @Autowired
    TimetableSystemRepository repository;
    
    @Transactional
    public void add(TimetableSystem t) {
        repository.save(t);
    }
    
    @Transactional(readOnly = true)
    public List<TimetableSystem> listAll() {
        return (List<TimetableSystem>) repository.findAll();
    }
    
    @Transactional(readOnly = true)
    public TimetableSystem findOne(Integer id) {
        return (TimetableSystem) repository.findOne(id);
    }
}
