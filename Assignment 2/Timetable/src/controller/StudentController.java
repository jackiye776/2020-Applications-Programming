
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
public class StudentController extends Controller<Student> {
    public final Student getStudent() { return model; }
    
    @FXML private TableView<Activity> activitiesTv;
    @FXML private TableView<Activity> subjectsTv;
    
    @FXML private ComboBox<Subject> subjectCmb;
    @FXML private Button withdrawBtn;
    @FXML private Button enrolBtn;
    @FXML private Text scholarshipID;
     
    @FXML private void initialize() {
        
        activitiesTv.setItems(getStudent().getActivities());
        
        subjectCmb.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldSelect, newSelect) -> {
                subjectsTv.setItems(newSelect.getActivities());
            }
        );

        subjectsTv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldSelect, newSelect) -> enableEnrol()
            //enrolBtn.setDisable(newSelect == null)
        );
        
        activitiesTv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldSelect, newSelect) -> withdrawBtn.setDisable(newSelect == null)
        );
       
        if(getStudent().getScholarship() == true) {
            scholarshipID.setText("Yes");
        } else
            scholarshipID.setText("No");
    }
    
    // First table
    private Activity getSelectedActivity() { 
        return activitiesTv.getSelectionModel().getSelectedItem(); 
    }
    
    // Second Table
    private Activity getSelectedSubject() {
        return subjectsTv.getSelectionModel().getSelectedItem();
    }
    
    private void enableEnrol() {
        if (getStudent().getActivities().size() < 1) {
            enrolBtn.setDisable(!ifAvailable());  
        } else {
            enrolBtn.setDisable(!ifAvailable() || ifEnrolled()); 
        }
    }
    
    // Check if class is not full
    //- Can be returned in one line of code
    private boolean ifAvailable() { 
        Activity activity = getSelectedSubject();
        return (activity.canEnrol());
    }
    
    // Check if user is already enrolled
    //- Can be returned in one line of code
    private boolean ifEnrolled() {
        /*Activity activity = getSelectedSubject();
        return (getStudent().isEnrolledIn(activity));*/
        return (getStudent().isEnrolledIn(getSelectedSubject()));
    }
        
    @FXML private void handleEnrol(ActionEvent event) {
        Activity activity = getSelectedSubject();
        
        for(Activity act : getStudent().getActivities()) {
            if(activity.matches(act.getSubjectNumber(), act.getGroup())){
                getStudent().withdraw(act);
                break;
            } 
        }
        getStudent().enrol(activity);
        enrolBtn.setDisable(true);
    }
    
    
    @FXML private void handleWithdraw(ActionEvent event) {
        // Do not need to store the activity in a 'storage' --> can just use it
        /*Activity activity = getSelectedActivity();
        getStudent().withdraw(activity);*/
        getStudent().withdraw(getSelectedActivity());
        enrolBtn.setDisable(true);
    }
    
    @FXML private void handleLogout(ActionEvent event) {
        stage.close();
    }
}
