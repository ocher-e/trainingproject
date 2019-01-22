package by.academy.timetable.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="T_ADMIN", catalog = "university2")
@PrimaryKeyJoinColumn(name = "F_USER_ID")
public class Admin extends User implements Serializable {

    public Admin() {
    }
    
    public Admin(String name, String login, String password, TimetableSystem timetable) {
        super(name, login, password, timetable);
    }

    @Override
    public String toString() {
        return "Admin{" + this.getUserId() + " " + this.getName() + " " + this.getLogin()
                + " " + this.getPassword() + '}';
    }
    
}
