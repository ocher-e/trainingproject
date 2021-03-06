package by.academy.timetable.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
        
    @Column(name = "F_COUNT_OF_ROOMS")
    @Min(value=2, message="{timetablesystem.countofrooms.min}")
    @Max(value=5, message="{timetablesystem.countofrooms.max}")
    private int countOfRooms;
    
    @Column(name = "F_PAIRS_IN_DAY")
    @Min(value=1, message="{timetablesystem.pairsinday.min}")
    @Max(value=3, message="{timetablesystem.pairsinday.max}")
    private int pairsInDay;
    
    @Column(name = "F_WORK_DAYS_IN_WEEK")
    @Min(value=1, message="{timetablesystem.workdaysinweek.min}")
    @Max(value=5, message="{timetablesystem.workdaysinweek.max}")
    private int workDaysInWeek;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "timetable")
    private Set<User> users = new HashSet<User>(0);

    public TimetableSystem() {
    }

    public TimetableSystem(int countOfRooms, int pairsInDay) {
        this.countOfRooms = countOfRooms;
        this.pairsInDay = pairsInDay;
    }

    public Integer getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(Integer timetableId) {
        this.timetableId = timetableId;
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

    public int getWorkDaysInWeek() {
        return workDaysInWeek;
    }

    public void setWorkDaysInWeek(int workDaysInWeek) {
        this.workDaysInWeek = workDaysInWeek;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "TimetableSystem{" + "timetableId=" + timetableId + ", countOfRooms=" + countOfRooms + ", pairsInDay=" + pairsInDay + ", workDaysInWeek=" + workDaysInWeek + '}';
    }
 
}
