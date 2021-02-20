package model;

import java.util.*;
import javafx.collections.*;

public class Subject {
    private final int number;
    private final String name;
    private ObservableList<Activity> activities = FXCollections.observableArrayList();
    
    public Subject(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public final int getNumber() {
        return number;
    }
    
    public final ObservableList<Activity> getActivities() {
        return activities;
    }
    
    
    public void addActivity(String group, int number, String day, int start, int duration, String room, int capacity) {
        activities.add(new Activity(this, group, number, day, start, duration, room, capacity));
    }

    public boolean matches(int number) {
        return this.number == number;
    }

    @Override
    public String toString() {
        return number + " " + name;
    }
}
