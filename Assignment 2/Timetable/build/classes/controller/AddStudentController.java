
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
 * @author 13543778
 */
public class AddStudentController extends Controller<University> {
    
    public final University getUniversity() { return model; }
    
    @FXML private TextField stuNumberTf;
    @FXML private TextField stuNameTf;
    @FXML private ToggleGroup attendanceTg;
    @FXML private CheckBox scholarshipCb;
    @FXML private Button addBtn;
    @FXML private Text errorText;
    
    private String getNumber() { return stuNumberTf.getText(); }
    private void setNumber(String number) { stuNumberTf.setText(number); }
    
    private String getName() { return stuNameTf.getText(); }
    private void setName(String name) { stuNameTf.setText(name); }
    
    private String getAttendance() { 
        String abbrevation = attendanceTg.getSelectedToggle().getUserData().toString();
        
        if(abbrevation.equals("ft")) {
            return abbrevation = "Full Time";
        } else {
            return abbrevation = "Part Time";
        }
    }
    private void setAttendance(String attendance) { attendanceTg.setUserData(attendance); 
    }
    
    private boolean getScholarship() { return scholarshipCb.isSelected(); }
    private void setScholarship(boolean scholarship) { scholarshipCb.setSelected(scholarship); }
    
    @FXML private void initialize() {
            stuNumberTf.textProperty().addListener((o, oldText, newText) -> enableButton());
            stuNameTf.textProperty().addListener((o, oldText, newText) -> enableButton());
            attendanceTg.selectedToggleProperty().addListener((o, old, now) -> enableButton());
    }
    
    private void enableButton() {
       addBtn.setDisable(!isNumberValid() || !isNameValid() || !isAttendanceValid());
    }
    
    private boolean isNumberValid() {
        return getNumber().length() >= 1;
    }
    
    private boolean isNameValid() {
        return getName().length() >= 1;
    }
   
    private boolean isAttendanceValid() {
        return attendanceTg.getSelectedToggle() != null;
    }

    @FXML private void handleCancel() {
        stage.close();
    }
    
    @FXML private void handleAdd() throws Exception {
        try {
            getUniversity().addStudent(getNumber(), getName(), getAttendance(), getScholarship());
            stage.close();
        } catch (Exception e){
            errorText.setText(e.getMessage()); 
        }
    }
}
