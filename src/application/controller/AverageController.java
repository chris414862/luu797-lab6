package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.Calculate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AverageController {
	//Class variables
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label warningLabel;

    @FXML
    private TextField valuesTextField;

    @FXML
    private TextField answerTextField;

    @FXML
    private Button resultButton;

    @FXML
    private Button homeButton;

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
    void handleResultButton(ActionEvent event) {
    	warningLabel.setVisible(false);
    	String input = valuesTextField.getText();
    	ArrayList<Double> numbers = new ArrayList<Double>();
    	try {
    		numbers = Calculate.convertStringToDoubles(input);
    		answerTextField.setText(String.valueOf(Calculate.average(numbers)));
    	}
    	catch(Exception e) {
    		warningLabel.setVisible(true);
    	}
    }

    /**
     * 
     */
    @FXML
    void initialize() {
        assert warningLabel != null : "fx:id=\"warningLabel\" was not injected: check your FXML file 'Average.fxml'.";
        assert valuesTextField != null : "fx:id=\"valuesTextField\" was not injected: check your FXML file 'Average.fxml'.";
        assert answerTextField != null : "fx:id=\"answerTextField\" was not injected: check your FXML file 'Average.fxml'.";
        assert resultButton != null : "fx:id=\"resultButton\" was not injected: check your FXML file 'Average.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'Average.fxml'.";

    }
}
