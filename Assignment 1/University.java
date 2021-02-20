import java.util.*;

// - add student
// - remove student
// - view students
// - login
public class University {
    
    public static void main(String[] args) {
        University university = new University();
        university.use();
    }
    
    private LinkedList<Subject> subjects = new LinkedList<Subject>();
    private LinkedList<Student> students = new LinkedList<Student>();
    
    public University() {
        Subject ap = new Subject("48024", "Applications Programming");
        ap.addActivity("Lec1", 1, "Wed", 18, 1, "CB11.00.405", 200);
        ap.addActivity("Cmp1", 1, "Wed", 19, 2, "CB11.B1.403", 2);
        ap.addActivity("Cmp1", 2, "Wed", 19, 2, "CB11.B1.401", 2);
        ap.addActivity("Cmp1", 3, "Wed", 19, 2, "CB11.B1.402", 2);
        subjects.add(ap);
        Subject wsd = new Subject("31284", "Web Services Development");
        wsd.addActivity("Lec1", 1, "Tue", 16, 1, "CB02.03.002", 160);
        wsd.addActivity("Cmp1", 1, "Tue", 9, 2, "CB11.B1.102", 30);
        wsd.addActivity("Cmp1", 2, "Tue", 9, 2, "CB11.B1.103", 30);
        wsd.addActivity("Cmp1", 3, "Tue", 14, 2, "CB11.B1.102", 30);
        wsd.addActivity("Cmp1", 4, "Tue", 14, 2, "CB11.B1.103", 30);
        subjects.add(wsd);
        
    } 
    
    public void use() {
        char choice;
        while ((choice = readChoice()) != 'x') {
            switch(choice) {
                case 'a' : addStudent(); break;
                case 'r' : removeStudent(); break;
                case 'v' : viewAllStudent(); break;
                case 'l' : loginStudent(); break;
                default: help(); break;
            }
        }
        System.out.println("Done");
    }
    
    private char readChoice() {
        System.out.print("Choice (a/r/v/l/x): ");
        return In.nextChar();
    }
    
    private void addStudent() {
        String number = readStudentNumber();
        Student existingStudent = student(number);
        if (existingStudent == null) {
            String name = readStudentName();
            students.add(new Student(number, name));
        } else {
            System.out.println("Student number already exists");
        }
    }

    private void removeStudent() { 
        Student student = student(readStudentNumber());
        if (student != null) {
            student.withdrawAll();
            students.remove(student);
        }
        else {
            System.out.println("No such student");
        }
    }
    
    private void viewAllStudent() {
        for (Student student : students)
            System.out.println(student);
    }
    
    
    private void loginStudent(University this) {
        Student student = student(readStudentNumber());
        if (student != null)
            student.use(this);
        else
            System.out.println("No such student");
    }
    
    private String readStudentNumber() {
        System.out.print("Number: ");
        return In.nextLine();
    }
    
    private String readStudentName() {
        System.out.print("Name: ");
        return In.nextLine();
    }

    // -- SELECTING SUBJECT --
    public Subject selectSubject() {
        System.out.println("Select a subject");
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
        Subject subject = subject(readSubjectNumber());
        if (subject != null){
            return subject;
        }
        else {
            System.out.println("No such subject");
            return null;
        }
        
    }
    
    // -- Look up --> STUDENT
    private Student student(String number) {
        for (Student student : students) {
            if (student.hasStudentNumber(number)) {
                return student;
            }           
        }
        return null;
    }
    
    // -- Look up --> SUBJECT
    private Subject subject(String number) {
        for (Subject subject : subjects) {
            if (subject.hasSubjectNumber(number)) {
                return subject;
            }
        }
        return null;
    }
    
    private String readSubjectNumber() {
        System.out.print("Subject number: ");
        return In.nextLine();
    }
    
    private void help() {
        System.out.println("University menu options");
        System.out.println("a = add a student");
        System.out.println("r = remove a student");
        System.out.println("v = view all students");
        System.out.println("l = login");
        System.out.println("x = exit");
    }

}   