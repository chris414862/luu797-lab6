package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Class to handle events from Main.fxml
 * 
 * @author chris414862
 * UTSA Application Programming CS3443 Fall 2018
 */
public class MainController {



    @FXML
    private Button courseGradeButton;

    @FXML
    private Button averageButton;

    @FXML
    void handleAverage(ActionEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Average.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		}
		catch(Exception e) {
			System.out.println("loader did't work");
			e.printStackTrace();
			System.exit(1);
		}
    }

    @FXML
    void handleGrade(ActionEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Grade.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		}
		catch(Exception e) {
			System.out.println("loader did't work");
			e.printStackTrace();
			System.exit(1);
		}
    }

    @FXML
    void initialize() {
        assert courseGradeButton != null : "fx:id=\"courseGradeButton\" was not injected: check your FXML file 'Main.fxml'.";
        assert averageButton != null : "fx:id=\"averageButton\" was not injected: check your FXML file 'Main.fxml'.";

    }
}
