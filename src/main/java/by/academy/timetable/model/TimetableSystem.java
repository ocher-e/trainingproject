package by.academy.timetable.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name= "T_TIMETABLE", catalog = "university2")
public class TimetableSystem implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "F_TIMETABLE_ID", unique = true, nullable = false)
    private Integer timetableId;
    
    @OneToMany(mappedBy="timetable", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>(0);
    
    @OneToMany(mappedBy = "timetable")
    private Set<Request> requests = new LinkedHashSet<>(0);
    
    // однонаправленная ассоциация
    @OneToOne
    @JoinColumn(name="FK_USER_ID", nullable= true)
    private User currentUser;
    
    @Column(name = "F_COUNT_OF_ROOMS")
    @Min(2)
    @Max(5)
    private int countOfRooms;
    
    @Column(name = "F_PAIRS_IN_DAY")
    @Min(1)
    @Max(3)
    private int pairsInDay;

    public TimetableSystem() {
    }

    public TimetableSystem(User currentUser, int countOfRooms, int pairsInDay) {
        this.currentUser = currentUser;
        this.countOfRooms = countOfRooms;
        this.pairsInDay = pairsInDay;
    }

    public Integer getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(Integer timetableId) {
        this.timetableId = timetableId;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public int getCountOfRooms() {
        return countOfRooms;
    }

    public void setCountOfRooms(int countOfRooms) {
        this.countOfRooms = countOfRooms;
    }

    public int getPairsInDay() {
        return pairsInDay;
    }

    public void setPairsInDay(int pairsInDay) {
        this.pairsInDay = pairsInDay;
    }
    
    @Override
    public String toString() {
        return "TimetableSystem{" + "timetableId=" + timetableId + ", currentUser=" + currentUser + ", countOfRooms=" + countOfRooms + ", pairsInDay=" + pairsInDay + '}';
    }
    
}
