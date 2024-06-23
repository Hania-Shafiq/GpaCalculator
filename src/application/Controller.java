package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller {
    @FXML private TextField numSubjectsTextField;
    @FXML private GridPane marksGridPane;
    @FXML private Label resultLabel;

    private TextField[] scoreTextFields;
    private int numSubjects;

    @FXML
    private void enterMarks(ActionEvent event) {
        try {
            numSubjects = Integer.parseInt(numSubjectsTextField.getText());
            marksGridPane.getChildren().clear();
            scoreTextFields = new TextField[numSubjects];

            for (int i = 0; i < numSubjects; i++) {
                Label label = new Label("Subject " + (i + 1) + " Marks:");
                TextField textField = new TextField();
                marksGridPane.add(label, 0, i);
                marksGridPane.add(textField, 1, i);
                scoreTextFields[i] = textField;
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Error: Please enter a valid number of subjects.");
        }
    }

    @FXML
    private void calculateGPA(ActionEvent event) {
        try {
            double totalGradePoints = 0.0;
            for (int i = 0; i < numSubjects; i++) {
                double score = Double.parseDouble(scoreTextFields[i].getText());
                totalGradePoints += convertScoreToGradePoint(score);
            }

            double gpa = totalGradePoints / numSubjects;
            resultLabel.setText(String.format("Calculated GPA: %.2f", gpa));
        } catch (NumberFormatException e) {
            resultLabel.setText("Error: Please enter valid marks.");
        }
    }

    private double convertScoreToGradePoint(double score) {
        if (score >= 90) return 4.0;
        else if (score >= 85) return 4.0;
        else if (score >= 80) return 3.8;
        else if (score >= 75) return 3.4;
        else if (score >= 71) return 3.0;
        else if (score >= 68) return 2.8;
        else if (score >= 64) return 2.4;
        else if (score >= 61) return 2.0;
        else if (score >= 57) return 1.8;
        else if (score >= 53) return 1.4;
        else if (score >= 50) return 1.0;
        else return 0.0;
    }
}
