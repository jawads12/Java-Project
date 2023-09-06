package com.example.mist_computer_club.controller;


import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class warning implements Initializable {
    @FXML
    private Label warning_label;
    @FXML
    void okay(MouseEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //universal.warning_message = "warning";
        System.out.println(universal.warning_message);
        warning_label.setText(universal.warning_message);

    }
}
