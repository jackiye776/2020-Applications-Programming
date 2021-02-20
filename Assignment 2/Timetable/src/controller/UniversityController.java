
package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import model.*;
import au.edu.uts.ap.javafx.*;
/**
 *
 * @author Jackie L.
 */
public class UniversityController extends Controller<University> {
    
    @FXML private ListView<Student> studentsLv;
    @FXML private Button deleteStudentBtn;
    @FXML private Button loginStudentBtn;
    
    @FXML private void initialize() {
        studentsLv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSelect, newSelect) -> deleteStudentBtn.setDisable(newSelect == null)
            );
        studentsLv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSelect, newSelect) -> loginStudentBtn.setDisable(newSelect == null)
            );
	}
    
    public final University getUniversity() {
        return model;
    }
    
    public Student getSelectedStudent() {
        return studentsLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void handleAddStudent(ActionEvent event) throws Exception {
        ViewLoader.showStage(getUniversity(), "/view/add_student.fxml", "Add Student", new Stage());
    }
    
    @FXML private void handleLoginStudent(ActionEvent event) throws Exception {
        ViewLoader.showStage(getSelectedStudent(), "/view/student.fxml", "Student", new Stage());
    }
    
    @FXML private void handleDeleteStudent(ActionEvent event) throws Exception {
        Student student = getSelectedStudent();
        
        for(Activity activity : student.getActivities()) {
            activity.withdraw();
        }
        getUniversity().remove(student);
    }
}
