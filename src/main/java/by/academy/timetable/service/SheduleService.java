package by.academy.timetable.service;

import by.academy.timetable.model.Request;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SheduleService {
    @Autowired
    RequestService requestService;
    
    @Autowired
    TimetableSystemService timetableService;
    
    private ArrayList<Request> preparePairsContainer(int groupNumber) {
        // контейнер запросов группы (содержит все запросы для данной группы)
        ArrayList<Request> requestsOfGroup = new ArrayList<>(requestService.findByStudgroup(groupNumber));
        
        // контейнер пар группы (содержит все пары данной группы). Этот контейнер больше контейнера запросов группы.
        ArrayList<Request> pairsOfGroup = new ArrayList<>(0); 

        for(int i = 0; i < requestsOfGroup.size(); i++) {
            // получаем количество пар для текущего запроса
            int q = requestsOfGroup.get(i).getPairsinweek();
            for(int j = 0; j < q; j++) {
                Request r = requestsOfGroup.get(i);
                // добавляем текущую дисциплину q раз
                pairsOfGroup.add(r);
            }
        }
        return pairsOfGroup;
    }
    
    public ArrayList<List<Request>> week4Group(int groupNumber) {
        int workDaysInWeek = 5;
        int pairsInDay = timetableService.findOne(1).getPairsInDay();
        // контейнер для расписания
        ArrayList<List<Request>> shedule = new ArrayList<>(pairsInDay);
        for(int i = 0; i < pairsInDay; i++) {
            shedule.add(new ArrayList<Request>(workDaysInWeek));
        }
        
        // список пар группы, которые будут добавлены в расписание
        ArrayList<Request> pairsContainer = preparePairsContainer(groupNumber);
        // наполняем расписание
        for(int j = 0; j < pairsInDay; j++) {
            System.out.println(" week= " + j);
            for(int i = 0; i < workDaysInWeek; i++) {
                System.out.println(" day= " + i);
                Request curPair = pairsContainer.remove(0);
                // получаем ссылку на неделю и добавляем реквест с парой i раз
                System.out.println(" size of pairsContainer= " + pairsContainer.size());
                shedule.get(j).add(curPair);
            }
        }
        return shedule;
    }
    
    
    
}
