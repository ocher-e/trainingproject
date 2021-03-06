package by.academy.timetable.service;

import by.academy.timetable.exception.ArgumentIsGreaterThanItShouldBe;
import by.academy.timetable.model.Request;
import by.academy.timetable.model.TimetableSystem;
import by.academy.timetable.repository.RequestRepository;
import by.academy.timetable.repository.TimetableSystemRepository;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestService {
    @Autowired
    RequestRepository repository;
    
    @Autowired
    TimetableSystemRepository timetableRepository;
    
    @Transactional
    @PreAuthorize("hasRole('ROLE_USER') and #r.requester.login == principal.username")
    public void add(Request r) throws ArgumentIsGreaterThanItShouldBe {
        TimetableSystem t = timetableRepository.findOne(1);
        int maxPossiblePairsQuantity = t.getWorkDaysInWeek()*t.getPairsInDay();
        int unreservedPairsForGroup = maxPossiblePairsQuantity - getSumOfPairsForGroup(r.getStudgroup());
        if(unreservedPairsForGroup < r.getPairsinweek()) {
            throw new ArgumentIsGreaterThanItShouldBe();
        }
        repository.save(r);
    }
    
    @Transactional
    public void addAll(Collection<Request> requests) {
        for(Request r: requests) {
            repository.save(r);
        }
    }
    
    @Transactional(readOnly = true)
    public List<Request> listAll() {
        return (List<Request>) repository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Request findOne(Integer id) {
        return repository.findOne(id);
    }
    
    @Transactional(readOnly = true)
    public List<Request> findByStudgroup(int studgroup) {
        return repository.findByStudgroup(studgroup);
    }
    
    @Transactional(readOnly = true)
    public int getSumOfPairsForGroup(int studgroup) {
        return repository.getSumOfPairsForGroup(studgroup);
    }
    
    @Transactional
    @PreAuthorize("hasRole('ROLE_USER') and #request.requester.login == principal.username")
    public void deleteRequest(Request request) {
        repository.delete(request);
    }
}
