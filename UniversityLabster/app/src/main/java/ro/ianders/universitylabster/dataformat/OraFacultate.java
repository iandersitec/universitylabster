package ro.ianders.universitylabster.dataformat;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by paul.iusztin on 09.12.2017.
 */

public abstract class OraFacultate {

    protected String name;
    protected ArrayList<Schedule> schedules;

    public OraFacultate(String name) {
        this.name = name;
        schedules = new ArrayList<>();
    }


    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    public void addSchedule(Date date, String endTime, String startTime) {
        schedules.add(new Schedule(date, endTime, startTime));
    }

    public class Schedule {
        private Date date;
        private String endTime;
        private String startTime;

        public Schedule(Date date, String endTime, String startTime) {
            this.date = date;
            this.endTime = endTime;
            this.startTime = startTime;
        }

        public Date getDate() {
            return date;
        }

        public String getEndTime() {
            return endTime;
        }

        public String getStartTime() {
            return startTime;
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }
}
