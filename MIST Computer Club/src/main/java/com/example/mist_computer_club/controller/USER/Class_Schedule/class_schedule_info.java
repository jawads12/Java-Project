package com.example.mist_computer_club.controller.USER.Class_Schedule;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class class_schedule_info implements Initializable {

    @FXML
    private AnchorPane anchor;

    @FXML
    private Circle first_circle;

    @FXML
    private Polyline left_arrow;

    @FXML
    private Polyline rightarrow;

    @FXML
    private Circle second_circle;

    @FXML
    private Circle third_circle;


    int num ;


    @FXML
    void rightarrow(MouseEvent event) throws IOException {
        if(num==1){
            //design - page 2
           first_circle.setFill(Color.web("#063663"));
            second_circle.setFill(Color.WHITE);
          third_circle.setFill(Color.web("#063663"));
            left_arrow.setFill(Color.CHARTREUSE);
            rightarrow.setFill(Color.CHARTREUSE);




            num=2;
            anchor.getChildren().add(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/USER/admin_panes/Class_Schedule/edit_page2.fxml"))));
            return;
        }
        if(num==2){

            //design - page 3
         first_circle.setFill(Color.web("#063663"));
         second_circle.setFill(Color.web("#063663"));
         third_circle.setFill(Color.WHITE);
         left_arrow.setFill(Color.CHARTREUSE);
         rightarrow.setFill(Color.web("#898989"));



            num=3;
            anchor.getChildren().add(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/USER/admin_panes/Class_Schedule/edit_page3.fxml"))));
            return;
        }



    }


    @FXML
    void left_arrow(MouseEvent event) throws IOException {
        if(num==3){
            first_circle.setFill(Color.web("#063663"));
            second_circle.setFill(Color.WHITE);
            third_circle.setFill(Color.web("#063663"));
            left_arrow.setFill(Color.CHARTREUSE);
            rightarrow.setFill(Color.CHARTREUSE);


            num=2;
            anchor.getChildren().add(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/USER/admin_panes/Class_Schedule/edit_page2.fxml"))));
            return;
        }
        if(num==2){
            first_circle.setFill(Color.WHITE);
          second_circle.setFill(Color.web("#063663"));
           third_circle.setFill(Color.web("#063663"));
           left_arrow.setFill(Color.web("#898989"));
            rightarrow.setFill(Color.CHARTREUSE);



            num=1;
            anchor.getChildren().add(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/USER/admin_panes/Class_Schedule/edit_page1.fxml"))));
            return;
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        first_circle.setFill(Color.WHITE);
        second_circle.setFill(Color.web("#063663"));
        third_circle.setFill(Color.web("#063663"));
        left_arrow.setFill(Color.web("#898989"));
        rightarrow.setFill(Color.CHARTREUSE);


        num=1;
        try {
            anchor.getChildren().add(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/USER/admin_panes/Class_Schedule/edit_page1.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}


















