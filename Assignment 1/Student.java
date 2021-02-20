import java.util.*;

// view my activities
// enrol
// withdraw
public class Student {
    
    private String number;
    private String name;
    private LinkedList<Activity> activities = new LinkedList<Activity>();
    
    public Student(String number, String name ) {
        this.number = number; 
        this.name = name; 
    } 
    
    public String readNumber() {
        System.out.println("Number: ");
        return In.nextLine();
    }
    
    // -- Match function --> for UNIVERISTY
    public boolean hasStudentNumber(String number) {
        return number.equals(this.number);
    }
    
    public void use(University university) {
        char choice;
        while ((choice = readChoice()) != 'x') {
            switch(choice) {
                case 'v' : view(); break;
                case 'e' : enrol(university); break;
                case 'w' : withdraw(); break;
                default : help(); break;
            }
        }
    }
    
    private char readChoice() {
        System.out.print("Choice (v/e/w/x): ");
        return In.nextChar();
    }
    
    private void view() {
        for (Activity activity : activities)
            System.out.println(activity);
    }
    
    private void enrol(University university) {
        Subject subject = university.selectSubject();
        if (subject != null){
            Activity activity = subject.selectActivity();
            if (activity != null) {
                if (activities.size() >= 1) {
                    for(Activity enrolled : activities) {
                        if (enrolled.hasActivity(activity.getSubject(), activity.getGroup())) {
                            activities.remove(enrolled);
                            enrolled.withdraw();
                            break;
                        }
                    }
                    activities.add(activity);
                    activity.enrol();
                }
            else {
                activities.add(activity);
                activity.enrol();
            }
            }
        }
    }

    private void withdraw() {
        String code = readCode();
        String [] codes = code.split(":");
        if (codes.length == 2){ // prevents termination
            Activity activity = activity(codes[0], codes[1]);
            if (activity != null) {
                activities.remove(activity);
                activity.withdraw();
            }
            else {
                System.out.println("Not enrolled in activity");
            }
        }
        else {
                System.out.println("Not enrolled in activity");
        }
    }
    
    public void withdrawAll() {
        LinkedList<Activity> studentActivity = studentActivity(activities);
        activities.removeAll(studentActivity);
    }

    // -- FIND ALL MATCHES --> FOR REMOVING ALL ACTIVITES (USED BY UNIVERSITY)
    private LinkedList<Activity> studentActivity(LinkedList<Activity> activities){
        LinkedList<Activity> matches = new LinkedList<Activity>();
        for (Activity activity : activities) {
            activity.withdraw();
            matches.add(activity);
        }
        return matches;
    }

    // -- Look up --> STUDENT
    private Activity activity(String subjectNumber, String group) {
        for (Activity activity : activities) {
            if (activity.hasActivity(subjectNumber, group)) {
                return activity;
            }           
        }
        return null;
    }
    
    private String readCode() {
        System.out.print("Activity code (subject:group): ");
        return In.nextLine();
    }
    
    private void help() {
        System.out.println("Student menu options");
        System.out.println("v = view my activities");
        System.out.println("e = enrol in an activity");
        System.out.println("w = withdraw from an activity");
        System.out.println("x = exit");
    }
    
    @Override
    public String toString() {
        return number + " " + name;
    }
    
}
