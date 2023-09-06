package com.example.mist_computer_club.controller.panes;

import com.example.mist_computer_club.contacts_user;
import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class feed_items implements Initializable {

    @FXML
    private Label class_name;

    @FXML
    private Label feed;

    @FXML
    private HBox itemC;

    @FXML
    private Label name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //contacts_user item = new contacts_user(universal.current_acc_name, universal.Current_acc_roll, universal.Current_acc_dept, universal.Current_acc_phone);
        System.out.println(universal.class_name);
        class_name.setText(universal.class_name);
        name.setText(universal.current_acc_name);
        feed.setText(universal.current_feed);

    }
}
