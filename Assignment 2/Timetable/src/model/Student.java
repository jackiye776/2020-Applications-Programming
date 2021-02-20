package model;

import java.util.*;
import javafx.collections.*;

public class Student {
    private University university;
    private final String number;
    private final String name;
    private final String attendance;
    private final boolean scholarship;
    private ObservableList<Activity> activities = FXCollections.observableArrayList();

    public Student(University university, String number, String name, String attendance, boolean scholarship) {
        this.university = university;
        this.number = number;
        this.name = name;
        this.attendance = attendance;
        this.scholarship = scholarship;
    }
    
    // Added FINAL to these get statements 
    public final University getUniversity() { return university; }
    public final String getNumber() { return number; }
    public final String getName() { return name; }
    public final String getAttendance() { return attendance; }
    public final boolean getScholarship() { return scholarship; }
    public final ObservableList<Activity> getActivities() { return activities; }
    
    public boolean isEnrolledIn(Activity activity) {
        return activities.contains(activity);
    }

    public boolean matches(String number) {
        return this.number.equals(number);
    }

    public void enrol(Activity activity) {
        // You should first check if the student is already enrolled
        // in an existing activity with the same subject and group.
        // If so, the student should be withdrawn from that activity first.
        // See Lecture 5 for hints.
        activities.add(activity);
        activity.enrol();
    }

    public void withdraw(Activity activity) {
        activities.remove(activity);
        activity.withdraw();
    }

    // This lookup function should be useful to check if a student is
    // already enrolled in an activity.
    private Activity activity(int subjectNumber, String group) {
        for (Activity activity : activities)
            if (activity.matches(subjectNumber, group))
                return activity;
        return null;
    }

    @Override
    public String toString() {
        return number + " - " + name;
    }
}
