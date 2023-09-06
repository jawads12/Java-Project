package com.example.mist_computer_club.controller.panes;


import com.example.mist_computer_club.universal;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.scene.shape.*;

public class dashboard_pane implements Initializable {

    @FXML
    private Label member_count;

    @FXML
    private Label team_count;

    @FXML
    private Label announce_counts;

    @FXML
    private Label feedcount;
    @FXML
    private HBox hbxx;

    @FXML
    private AnchorPane anch;


    @FXML
    private Label hour;
    @FXML
    private Label min;
    @FXML
    private Label second;

    @FXML
    private Label ctf_nam;

    @FXML
    void ctf_time() {
        if (Desktop.isDesktopSupported()) {
            new Thread(() -> {
                try {
                    Desktop.getDesktop().browse( new URI("https://ctftime.org/") );
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
    @FXML
    BorderPane root;

    @FXML
    private Rectangle rect1;

    @FXML
    private Rectangle rect2;


    @FXML
    private Label text_hack;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {




     //   hour.setText();
      //  min.setText(String.valueOf(LocalDateTime.now().getMinute()));
       // second.setText(String.valueOf(LocalDateTime.now().getSecond()));

        new Thread(() -> {


            AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    hour.setText(String.valueOf(LocalDateTime.now().getHour()));
                    min.setText(String.valueOf(LocalDateTime.now().getMinute()));
                    second.setText(String.valueOf(LocalDateTime.now().getSecond()));
                }
            };
            timer.start();




            File [] members = new File(universal.path).listFiles();
            assert members != null;
            member_count.setText(Integer.toString(members.length));

            File [] teams = new File(universal.path_team).listFiles();
            assert teams != null;
            team_count.setText(Integer.toString(teams.length));


            File [] announce = new File(universal.path_announces).listFiles();
            assert announce != null;
            announce_counts.setText(Integer.toString(announce.length));




            RotateTransition rotate = new RotateTransition();

            rotate.setCycleCount(TranslateTransition.INDEFINITE);
            rotate.setDuration(Duration.millis(3000));
            rotate.setInterpolator(Interpolator.EASE_BOTH);
            rotate.setByAngle(360);
            rotate.setAxis(Rotate.Z_AXIS);

            rotate.setAutoReverse(true); rotate.setNode(rect1);
            rotate.play();


            RotateTransition rotate1 = new RotateTransition();
            rotate1.setCycleCount(TranslateTransition.INDEFINITE);
            rotate1.setDuration(Duration.millis(5000));

            rotate1.setInterpolator(Interpolator.EASE_BOTH);
            rotate1.setByAngle(360);
            rotate1.setAxis(Rotate.Y_AXIS);

            rotate1.setAutoReverse(true); rotate1.setNode(rect2);
          //  rotate1.play();




            // Desktop.getDesktop().browse(URI.create("https://ctftime.org/ "));
        }).start();








    }
}
