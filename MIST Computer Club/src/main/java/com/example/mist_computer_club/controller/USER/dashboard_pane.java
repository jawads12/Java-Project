package com.example.mist_computer_club.controller.USER;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

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
    private Rectangle rect1;

    @FXML
    private Rectangle rect2;

    @FXML
    void ctf_time() {
        if (Desktop.isDesktopSupported()) {
            new Thread(() -> {
                try {
                    Desktop.getDesktop().browse(URI.create("https://ctftime.org/ "));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }).start();
        }
    }
    @FXML
    BorderPane root;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        new Thread(() -> {


            File [] members = new File(universal.path).listFiles();
            assert members != null;
            member_count.setText(Integer.toString(members.length));

            File [] teams = new File(universal.path_team).listFiles();
            assert teams != null;
            team_count.setText(Integer.toString(teams.length));


            File [] announce = new File(universal.path_announces).listFiles();
            assert announce != null;
            announce_counts.setText(Integer.toString(announce.length));

            // Desktop.getDesktop().browse(URI.create("https://ctftime.org/ "));




        }).start();








    }
}
