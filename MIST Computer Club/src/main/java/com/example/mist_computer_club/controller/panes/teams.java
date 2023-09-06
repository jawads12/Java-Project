package com.example.mist_computer_club.controller.panes;

import com.example.mist_computer_club.contacts_user;
import com.example.mist_computer_club.team_user;
import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class teams implements Initializable {

    @FXML
    private Label email1;

    @FXML
    private Label email2;

    @FXML
    private Label email3;

    @FXML
    private Label email4;

    @FXML
    private Label team_name;

    @FXML
    private Circle im1;

    @FXML
    private Circle im2;

    @FXML
    private Circle im3;

    @FXML
    private Circle im4;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        team_user item = new team_user(universal.Current_email,universal.Current_pic, universal.team_ame);
        email1.setText(item.email[0]);
        email2.setText(item.email[1]);
        email3.setText(item.email[2]);
        email4.setText(item.email[3]);

        team_name.setText(item.team);
       // System.out.println("workssss");
      //  System.out.println(item.pic[0]);

     //   Image ima1 = new Image(item.pic[0], false);
       // im1.setFill(new ImagePattern(ima1));

        Image ima = new Image(item.pic[0], false);
        im1.setFill(new ImagePattern(ima));
        //System.out.println();

        Image ima2 = new Image(item.pic[1], false);
        im2.setFill(new ImagePattern(ima2));

        Image ima3 = new Image(item.pic[2], false);
        im3.setFill(new ImagePattern(ima3));

        Image ima4 = new Image(item.pic[3], false);
        im4.setFill(new ImagePattern(ima4));



    }
}
