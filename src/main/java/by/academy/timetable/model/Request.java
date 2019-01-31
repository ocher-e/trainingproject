package by.academy.timetable.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="T_REQUEST", catalog = "university2")
public class Request implements Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "F_REQUEST_ID", unique = true, nullable = false)
    private Integer requestId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "F_USER_ID", nullable = false)
    private Professor requester;
    
    @Column(name = "F_DISCIPLINE")
    @Size(min=3, max=10, message="The discipline name must be between 3 and 10 characters long.")
    private String discipline;
    
    @Column(name = "F_GROUP")
    @Min(1)
    @Max(2)
    private int studgroup;
    
    @Column(name = "F_PAIRS_IN_WEEK")
    @Min(1)
    @Max(3)
    private int pairsinweek;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "F_TIMETABLE_ID", nullable = false)
    private TimetableSystem timetable;

    public Request() {
    }

    public Request(Professor requester, String discipline, int studgroup, int pairsinweek, TimetableSystem timetable) {
        this.requester = requester;
        this.discipline = discipline;
        this.studgroup = studgroup;
        this.pairsinweek = pairsinweek;
        this.timetable = timetable;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Professor getRequester() {
        return requester;
    }

    public void setRequester(Professor requester) {
        this.requester = requester;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public int getStudgroup() {
        return studgroup;
    }

    public void setStudgroup(int studgroup) {
        this.studgroup = studgroup;
    }

    public int getPairsinweek() {
        return pairsinweek;
    }

    public void setPairsinweek(int pairsinweek) {
        this.pairsinweek = pairsinweek;
    }

    public TimetableSystem getTimetable() {
        return timetable;
    }

    public void setTimetable(TimetableSystem timetable) {
        this.timetable = timetable;
    }
    
    @Override
    public String toString() {
        return "Request{" + "requestId=" + requestId + ", discipline=" + discipline + ", studgroup=" + studgroup + ", pairsinweek=" + pairsinweek + '}';
    }
    
    
}

