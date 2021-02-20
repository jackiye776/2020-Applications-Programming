import java.util.*;

// Checks availability of a activity --> returns to Student

public class Subject {
    
    private String number;
    private String name;
    private LinkedList<Activity> activities = new LinkedList<Activity>();
    	
    public Subject(String number, String name) {
    	this.number = number;
    	this.name = name;
    }
    
    public void addActivity(String group, int number, String day, int start, int duration, String room, int capacity) {
    	activities.add(new Activity(this, group, number, day, start, duration, room, capacity));
    }
    
    // -- LIST ACTIVITY --> CHECK AVAILABILITY && IF EXISTS --> RETURN ACTIVITY 
    public Activity selectActivity() {
    	System.out.println("Select an activity");
    	for (Activity activity : activities) {
    		System.out.println(activity);
    	}
    
    	String code = readActivity();
    	String [] codes = code.split(":"); // Split user's code
    	String chosenGroup = codes[0].trim(); // Get first item in array (GROUP)
    
    	if (codes.length == 1) {
    		Activity autoEnrol = activity(chosenGroup);
    		LinkedList<Activity> selectedList = hasGroup(activities, chosenGroup);
    		if (autoEnrol != null) {
    		for (Activity activity : selectedList) {
    			if (activity.canEnrol() != false) {
    				return activity;
    			}
    		}
    			System.out.println("No available seats");
    			return null;
    		}
    		else {
    			System.out.println("No such activity");
    			return null;
    		}
    	}
    	else if (codes.length == 2) {
    		int chosenActivity = Integer.parseInt(codes[1].trim()); // Get second item in array (ACTIVITY)
    		Activity activity = activity(chosenGroup, chosenActivity);
    		if (activity != null) {
    			if (activity.canEnrol() != false){
    				return activity;
    			}
    			else {
    				System.out.println("No available seats");
    				return null;
    			}
    		}
    		else {
    			System.out.println("No such activity");
    			return null;
    		}
    	}
    	System.out.println("No such activity");
    	return null;
    }
    
    // -- FOR ACTIVITY.TOSTRING() & GETSUBJECT()
    public String getSubjectNumber() {
    	return this.number;
    }
    
    // -- Used in UNIVERSITY 
    public boolean hasSubjectNumber(String number) {
    	return number.equals(this.number);
    }
    
    private String readActivity() {
    	System.out.print("Activity code (group:activity): ");
    	return In.nextLine();
    }
    
    // -- FIND ALL MATCHES --> FOR AUTOENROLL 
    private LinkedList<Activity> hasGroup(LinkedList<Activity> activities, String code){
    	LinkedList<Activity> groupList = new LinkedList<Activity>();
    	for (Activity activity : activities) {
    		if (activity.getGroup().contains(code)) {
    			groupList.add(activity);
    		}
    	}
    	return groupList;
    }
    
    // -- LOOK UP --> ACTIVITY (GROUP ONLY)
    private Activity activity(String group) {
    	for (Activity activity : activities) {
    		if (activity.hasActivity(group)) {
    			return activity;
    		}
    	}
    	return null;
    }
    
    // -- LOOK UP --> ACTIVITY (GROUP & NUMBER)
    private Activity activity(String group, int number) {
    	for (Activity activity : activities) {
    		if (activity.hasActivity(group, number)) {
    			return activity;
    		}
    	}
    	return null;
    }
    
    @Override
    public String toString() {
    	return number + " " + name;
    }
}