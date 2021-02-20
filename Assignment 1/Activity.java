import java.text.*;

// Checks if activity has capacity --> returns to SUBJECT
// increment OR decrement "enrolled"

public class Activity {
    
    private Subject subject;
    private String group; 
    private int number;
    private String day;
    private int start;
    private int duration;
    private String room;
    private int capacity;
    private int enrolled = 0; // Always starts at 0 when initialising 
    
    public Activity(Subject subject, String group, int number, String day, int start, int duration, String room, int capacity) {
        this.subject = subject;
        this.group = group;
        this.number = number;
        this.day = day;
        this.room = room;
        this.start = start;
        this.duration = duration;
        this.capacity = capacity;
    }
    
    // MATCH GROUP ONLY --> SUBJECT
    public boolean hasActivity(String group) {
        return group.equals(this.group);
    }

    // MATCH GROUP + NUMBER --> SUBJECT
    public boolean hasActivity(String group, int number) {
        return group.equals(this.group) && number == this.number;
    }
    
    // MATCH SUBJECT NUMBER + GROUP --> STUDENT
    public boolean hasActivity(String subjectNum, String actGroup) {
        return subjectNum.equals(subject.getSubjectNumber()) && actGroup.equals(this.group);
    }

    public String getGroup() {
        return this.group;
    }

    public String getSubject() {
        return subject.getSubjectNumber();
    }

    public boolean canEnrol() {
        return enrolled < capacity;
    }

    public void enrol(){
        enrolled++;
    }

    public void withdraw(){
        enrolled--;
    }

    @Override
    public String toString() {
        return subject.getSubjectNumber() + " " + group + " " + number + " " + day + " " + room + " " + dateFormatted(start) + "00 " + duration + "hrs " + enrolled + "/" + capacity;
    }
    
    private String dateFormatted(int start) {
        return new DecimalFormat("##:00").format(start);
    }
}