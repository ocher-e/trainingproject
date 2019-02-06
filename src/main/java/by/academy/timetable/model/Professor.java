
package by.academy.timetable.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="T_PROFESSOR", catalog = "university2")
@PrimaryKeyJoinColumn(name = "F_USER_ID")
public class Professor extends User implements Serializable {

    public Professor() {
    }

    public Professor(String name, String login, String password, TimetableSystem timetable) {
        super(name, login, password, timetable);
    }
  
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "requester")
    private Set<Request> requests = new HashSet<Request>(0);

    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }

    @Override
    public String toString() {
        return "Professor{" + this.getUserId() + " " + this.getName() + " " + this.getLogin()
                + " " + this.getPassword() + '}';
    }
    
}
