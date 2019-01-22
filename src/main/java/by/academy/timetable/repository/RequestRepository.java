package by.academy.timetable.repository;

import by.academy.timetable.model.Request;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Integer> {
    public List<Request> findByStudgroup(int studgroup);
    
    @Query("select sum(pairsinweek) from Request r where r.studgroup = ?1")
    public int getSumOfPairsForGroup(int studgroup);
}
