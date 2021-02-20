
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jackie Lim
 */
public class Calculator extends Application {
    public static void main(String[] args) { launch(args); }

    private Label firstNumberLbl;
    private TextField firstNumberTf;
    private Label secondNumberLbl;
    private TextField secondNumberTf;
    private Label operationLbl;
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;
    private Label resultLbl;
    private TextField resultTf;

    @Override
    public void start(Stage stage) throws Exception {
        // 1. create the leaf nodes
        firstNumberLbl = new Label("First number:");
        firstNumberTf = new TextField();
        secondNumberLbl = new Label("Second number:");
        secondNumberTf = new TextField();
        operationLbl = new Label("Operation:");
        addBtn = new Button("+");
        subBtn = new Button("-");
        mulBtn = new Button("*");
        divBtn = new Button("/");
        resultLbl = new Label("Result:");
        resultTf = new TextField();
        
        // Set the event handlers
        // -- Inner class
        addBtn.setOnAction(new AddHandler());
        // -- Anonymous inner class
        subBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                setResult(getFirstNumber() - getSecondNumber());
            }
        });
        // -- Lambda expression
        mulBtn.setOnAction(event -> setResult(getFirstNumber() * getSecondNumber()));
        
        divBtn.setOnAction(event -> setResult(getFirstNumber() / getSecondNumber()));
        
        // 2. create the branch node
        VBox box = new VBox(10);
        /*
        box.getChildren().add(firstNumberLbl);
        box.getChildren().add(firstNumberTf);
        box.getChildren().add(secondNumberLbl);
        box.getChildren().add(secondNumberTf);
        box.getChildren().add(operationLbl);
        box.getChildren().add(addBtn);
        box.getChildren().add(subBtn);
        box.getChildren().add(mulBtn);
        box.getChildren().add(divBtn);
        box.getChildren().add(resultLbl);
        box.getChildren().add(resultTf);
        */
        
        GridPane grid = new GridPane();
        
        
        // column / row
        grid.add(firstNumberLbl, 0, 0);
        grid.add(firstNumberTf, 1, 0);
        grid.add(secondNumberLbl, 0, 1);
        grid.add(secondNumberTf, 1, 1);
        grid.add(operationLbl, 0, 2);
        grid.add(addBtn, 1, 2);
        grid.add(subBtn, 2, 2); 
        grid.add(mulBtn, 3, 2);
        grid.add(divBtn, 4, 2);
        grid.add(resultLbl, 0, 3);
        grid.add(resultTf, 1, 3);
        
        
        // 3. set the scene, show the stage
        stage.setScene(new Scene(grid));
        stage.setTitle("Calculator");
        stage.show();
    }
  
    public int getFirstNumber() {
        return Integer.parseInt(firstNumberTf.getText());
    }
    public int getSecondNumber() {
         return Integer.parseInt(secondNumberTf.getText());
    }
    public void setResult(int value) {
        resultTf.setText(String.valueOf(value));
    }
    
    // Inner class for addBtn
    private class AddHandler implements EventHandler<ActionEvent> {
		@Override public void handle(ActionEvent event) {
                    setResult(getFirstNumber() + getSecondNumber());
                }
    }
}
