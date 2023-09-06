package com.example.mist_computer_club.controller;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class start implements Initializable {
    @FXML
    private Polyline pol1;

    @FXML
    private AnchorPane anc;
    @FXML
    private Polyline pol2;

    @FXML
    private Polyline pol3;

    @FXML
    private Polyline pol4;

    @FXML
    void startkoro(MouseEvent eventt) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LOGIN_final.fxml"));
        Parent pane = loader.load();
        Scene scene = new Scene(pane);

        Stage stage = (Stage) ((Node) eventt.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image("E:\\Java\\Projects\\MIST Computer CLub\\MIST Computer Club\\src\\main\\resources\\icon\\ct.png"));


        final double[] x = new double[1];
        final double[] y = new double[1];
        pane.setOnMousePressed(event -> {
            x[0] = event.getSceneX();
            y[0] = event.getSceneY();
        });
        pane.setOnMouseDragged(event -> {

            stage.setX(event.getScreenX() - x[0]);
            stage.setY(event.getScreenY() - y[0]);

        });


        stage.show();


    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int a = 1000;
        FadeTransition rotate = new FadeTransition();
        rotate.setNode(pol1);
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setDuration(Duration.millis(a));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setFromValue(0);
        rotate.setToValue(1);
        rotate.setAutoReverse(true);
        rotate.play();


        FadeTransition rotate1 = new FadeTransition();
        rotate1.setNode(pol2);
        rotate1.setCycleCount(TranslateTransition.INDEFINITE);
        rotate1.setDuration(Duration.millis(a));
        rotate1.setInterpolator(Interpolator.LINEAR);
        rotate1.setFromValue(0);
        rotate1.setAutoReverse(true);
        rotate1.setToValue(1);
        //  rotate1.setAutoReverse(true);
        rotate1.play();

        FadeTransition rotate2 = new FadeTransition();
        rotate2.setNode(pol3);
        rotate2.setCycleCount(TranslateTransition.INDEFINITE);
        rotate2.setDuration(Duration.millis(a));
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.setFromValue(0);
        rotate2.setAutoReverse(true);
        rotate2.setToValue(1);
        //  rotate2.setAutoReverse(true);
        rotate2.play();

        FadeTransition rotate3 = new FadeTransition();
        rotate3.setNode(pol4);
        rotate3.setCycleCount(TranslateTransition.INDEFINITE);
        rotate3.setDuration(Duration.millis(a));
        rotate3.setInterpolator(Interpolator.LINEAR);
        rotate3.setFromValue(0);
        rotate3.setToValue(1);
        rotate3.setAutoReverse(true);
        //  rotate3.setAutoReverse(true);
        rotate3.play();


    }
}