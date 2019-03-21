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
    @Size(min=3, max=10, message="{request.discipline.size}")
    private String discipline;
    
    @Column(name = "F_GROUP")
    @Min(value=1, message="{request.sudgroup.min}")
    @Max(value=2, message="{request.sudgroup.max}")
    private int studgroup;
    
    @Column(name = "F_PAIRS_IN_WEEK")
    @Min(value=1, message="{request.pairsinweek.min}")
    @Max(value=5, message="{request.pairsinweek.max}")
    private int pairsinweek;
    
    public Request() {
    }

    public Request(Professor requester, String discipline, int studgroup, int pairsinweek) {
        this.requester = requester;
        this.discipline = discipline;
        this.studgroup = studgroup;
        this.pairsinweek = pairsinweek;
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
    
    @Override
    public String toString() {
        return "Request{" + "requestId=" + requestId + ", discipline=" + discipline + ", studgroup=" + studgroup + ", pairsinweek=" + pairsinweek + '}';
    }
    
    
}

