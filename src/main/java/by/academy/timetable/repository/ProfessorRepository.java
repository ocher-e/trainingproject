package by.academy.timetable.repository;

import by.academy.timetable.model.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
    public Professor findProfessorByLogin(String login);
}
