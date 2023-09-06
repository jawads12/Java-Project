package com.example.mist_computer_club.controller.USER.announcements;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class details implements Initializable {

    @FXML
    private Label annc_name;

    @FXML
    private Label annc_name1;

    @FXML
    private Label annc_name2;

    @FXML
    private TextField date;

    @FXML
    private TextField month;

    @FXML
    private TextField year;

    @FXML
    void OK_anc(MouseEvent event) {
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        annc_name.setText(universal.a);
        annc_name1.setText(universal.b);
        annc_name2.setText(universal.c);

    }
}
