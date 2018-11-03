package application.controller;

import application.model.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Class to handle events from Grade.fxml
 * 
 * @author chris414862
 * UTSA Application Programming CS3443 Fall 2018
 */
public class GradeController {
	//Class variables
	private HashMap<TextField, Slider> gradesAndWeights;
	
    @FXML
    private Slider midtermSlider;
    
    @FXML
    private Slider labsSlider;

    @FXML
    private Slider finalSlider;
    
    @FXML
    private Slider quizzesSlider;
    
    @FXML
    private Slider teamSlider;

    @FXML
    private TextField teamTextField;

    @FXML
    private TextField labsTextField;

    @FXML
    private TextField quizzesTextField;

    @FXML
    private TextField finalTextField;

    @FXML
    private TextField midtermTextField;

    @FXML
    private Button resultButton;
    
    @FXML
    private Button homeButton;
    
    @FXML
    private Label warningLabel;
    
    @FXML
    private TextField letterAnswerTextField;

    @FXML
    private TextField numAnswerTextField;

    /**
     * 
     * @param event
     */
    @FXML
    void handleHomeButton(ActionEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		}
		catch(Exception e) {
			System.out.println("loader did't work");
			e.printStackTrace();
			System.exit(1);
		}
    }

    /**
     * 
     * @param event
     */
    @FXML
    void handleCalculateButton(ActionEvent event) {
    	if(Calculate.equalsOneHundred(gradesAndWeights)) {
    		try {
    			warningLabel.setVisible(false);
    		double grade = Calculate.calcWeightedAvg(gradesAndWeights);
    		String str = String.format("%.02f", grade);
    		System.out.println(str);
    		numAnswerTextField.setText(str);
    		String letterGrade = Calculate.calcLetterGrade(grade);
    		letterAnswerTextField.setText(letterGrade);
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    			System.exit(1);
    		}
    	} 	
    	else {
    		warningLabel.setVisible(true);
    	}
    }

    /**
     * 
     */
    @FXML
    void initialize() {
        assert midtermSlider != null : "fx:id=\"midtermSlider\" was not injected: check your FXML file 'Grade.fxml'.";
        assert teamTextField != null : "fx:id=\"teamTextField\" was not injected: check your FXML file 'Grade.fxml'.";
        assert labsSlider != null : "fx:id=\"labsSlider\" was not injected: check your FXML file 'Grade.fxml'.";
        assert finalSlider != null : "fx:id=\"finalSlider\" was not injected: check your FXML file 'Grade.fxml'.";
        assert numAnswerTextField != null : "fx:id=\"numAnswerTextField\" was not injected: check your FXML file 'Grade.fxml'.";
        assert quizzesSlider != null : "fx:id=\"quizzesSlider\" was not injected: check your FXML file 'Grade.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'Grade.fxml'.";
        assert labsTextField != null : "fx:id=\"labsTextField\" was not injected: check your FXML file 'Grade.fxml'.";
        assert quizzesTextField != null : "fx:id=\"quizzesTextField\" was not injected: check your FXML file 'Grade.fxml'.";
        assert letterAnswerTextField != null : "fx:id=\"letterAnswerTextField\" was not injected: check your FXML file 'Grade.fxml'.";
        assert warningLabel != null : "fx:id=\"warningLabel\" was not injected: check your FXML file 'Grade.fxml'.";
        assert midtermTextField != null : "fx:id=\"midtermTextField\" was not injected: check your FXML file 'Grade.fxml'.";
        assert teamSlider != null : "fx:id=\"teamSlider\" was not injected: check your FXML file 'Grade.fxml'.";
        assert resultButton != null : "fx:id=\"resultButton\" was not injected: check your FXML file 'Grade.fxml'.";
        assert finalTextField != null : "fx:id=\"finalTextField\" was not injected: check your FXML file 'Grade.fxml'.";
        gradesAndWeights = new HashMap<TextField, Slider>();
        gradesAndWeights.put(labsTextField,labsSlider);
        gradesAndWeights.put(quizzesTextField, quizzesSlider);
        gradesAndWeights.put(finalTextField,finalSlider);
        gradesAndWeights.put(midtermTextField,midtermSlider);
        gradesAndWeights.put(teamTextField, teamSlider);
    }
}
