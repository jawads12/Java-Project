package com.example.mist_computer_club.controller;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DASHBOARD implements Initializable {

    @FXML
    private Label dept;

    @FXML
    private Label name;

    @FXML
    private Label roll;


    @FXML
    private Circle circle;

    @FXML
    private ImageView imageview;

    @FXML
    private Label lbl_completed;

    @FXML
    private Label lbl_pending;

    @FXML
    private VBox pnl_scroll;

    @FXML
    void handleButtonAction(MouseEvent event) {

    }
    @FXML
    private AnchorPane pane_middle;


    @FXML
    void noti(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(DASHBOARD.class.getResource("/notifications_pane.fxml"));
        Parent pane = loader.load();
        //pane.setPrefSize(300, 300);
        pane_middle.getChildren().add(pane);

      //  rootPane.getChildren().addAll(pane1,pane2);




    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // imageview.setClip(circle);
       // circle.setStroke(Color.RED);
        Image ima = new Image(universal.current_path+"image.jpg", false);
        System.out.println(universal.current_path+"image.jpg");
        //E:/Java/Projects/MIST Computer CLub/MIST Computer Club/src/main/resources/database/accounts/member/a@gmail.com/image.jpg
        //E:/Java/Projects/MIST Computer CLub/MIST Computer Club/src/main/resources/database/accounts/Teams/403_Forbiddden/a@gmail.com/image.jpg
        circle.setFill(new ImagePattern(ima));
        //circle.setEffect(new DropShadow(+25d));
        name.setText(universal.current_acc_name);
        System.out.println(universal.current_acc_name);
        roll.setText(universal.Current_acc_roll);
        dept.setText(universal.Current_acc_dept);

    }
}
