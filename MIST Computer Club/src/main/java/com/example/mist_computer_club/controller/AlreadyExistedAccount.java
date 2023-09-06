package com.example.mist_computer_club.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AlreadyExistedAccount {

    @FXML
    void okay(MouseEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.close();
    }

}
