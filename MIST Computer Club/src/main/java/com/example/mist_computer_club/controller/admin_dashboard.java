package com.example.mist_computer_club.controller;

import com.example.mist_computer_club.controller.panes.ctf;
import com.example.mist_computer_club.universal;
import com.jfoenix.controls.JFXButton;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class admin_dashboard implements Initializable {
    @FXML
    private AnchorPane pane;

    @FXML
    private ImageView img;



    @FXML
    void manage_team(MouseEvent event) {

        System.out.println("working");
        FXMLLoader loader = new FXMLLoader(admin_dashboard.class.getResource("/admin_panes/pane_manage_team.fxml"));
        Parent lagabo;
        try {
            lagabo = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pane.getChildren().add(lagabo);




    }


    @FXML
    void open_contact(MouseEvent event) {

        System.out.println("working");
        FXMLLoader loader = new FXMLLoader(admin_dashboard.class.getResource("/admin_panes/pane_contact_info.fxml"));
        Parent lagabo;
        try {
            lagabo = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pane.getChildren().add(lagabo);

    }


    @FXML
    void opem_dash(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(admin_dashboard.class.getResource("/admin_panes/pane_dashboard.fxml"));
        Parent lagabo;
        try {
            lagabo = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pane.getChildren().add(lagabo);

    }


    @FXML
    void logout(MouseEvent e) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to exit?");

        if(alert.showAndWait().get()== ButtonType.OK){
            ((Stage)((Node)e.getSource()).getScene().getWindow()).close();


        }



        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LOGIN_final.fxml"));
        Parent pane = loader.load();
        Scene scene = new Scene(pane);

        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);

        final double[] x = new double[1];
        final double[] y = new double[1];
        pane.setOnMousePressed(even -> {
            x[0] = even.getSceneX();
            y[0] = even.getSceneY();
        });
        pane.setOnMouseDragged(even -> {

            stage.setX(even.getScreenX() - x[0]);
            stage.setY(even.getScreenY() - y[0]);

        });


        stage.show();
    }


    @FXML
    void ctf() throws IOException {

        FXMLLoader loaderMainWindow = new FXMLLoader(getClass().getResource("/admin_panes/CTF_pane.fxml"));
        Pane pan = loaderMainWindow.load();
        pane.getChildren().add(pan);


       // mainWindowController


      //  loaderMainWindow.getController();



    }


    //   public admin_dash_controller getMainWindowController() { return mainWindowController;}


    @FXML
    void schedule(MouseEvent event) throws IOException {
        pane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(admin_dashboard.class.getResource("/admin_panes/Class_Schedule/class_schedule_main.fxml"))));


    }


    @FXML
    void announce(MouseEvent event) throws IOException {
        pane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(admin_dashboard.class.getResource("/announcement/announce_pane.fxml"))));

    }

    @FXML
    void show_feed(MouseEvent event) throws IOException {
        pane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(admin_dashboard.class.getResource("/feedback_ADMIN/d/feedback_pane.fxml"))));


    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        FXMLLoader loader = new FXMLLoader(admin_dashboard.class.getResource("/admin_panes/pane_dashboard.fxml"));
        Parent lagabo;
        try {
            lagabo = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pane.getChildren().add(lagabo);


        RotateTransition rotate = new RotateTransition();
        rotate.setNode(img);
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setDuration(Duration.millis(8000));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setAutoReverse(true);
     //   rotate.play();

    }



}
