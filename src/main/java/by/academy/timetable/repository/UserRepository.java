package by.academy.timetable.repository;

import by.academy.timetable.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    public User findUserByLoginAndPassword(String login, String password);
    public User findByName(String name);
    public User findUserByLogin(String login);
}
