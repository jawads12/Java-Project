package com.example.mist_computer_club.controller.USER.contacts;

import com.example.mist_computer_club.contacts_user;
import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class contacts implements Initializable {

    @FXML
    private Label dept;

    @FXML
    private Label id;

    @FXML
    private HBox itemC;

    @FXML
    private Label level;

    @FXML
    private Label name;

    @FXML
    private Label phn;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        contacts_user item = new contacts_user(universal.current_acc_name, universal.Current_acc_roll, universal.Current_acc_dept, universal.Current_acc_phone);
        name.setText(item.name);
        id.setText(item.Id);
        dept.setText(item.dept);
        phn.setText(item.phone);
        level.setText(universal.Current_level);

    }

}
