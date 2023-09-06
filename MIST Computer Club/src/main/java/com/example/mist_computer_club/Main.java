package com.example.mist_computer_club;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/start.fxml"));
        Parent pane = loader.load();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MIST Computer Club");
        primaryStage.getIcons().add(new Image("E:\\Java\\Projects\\MIST Computer CLub\\MIST Computer Club\\src\\main\\resources\\icon\\ct.png"));
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        final double[] x = new double[1];
        final double[] y = new double[1];
        pane.setOnMousePressed(event -> {
            x[0] = event.getSceneX();
            y[0] = event.getSceneY();
        });
        pane.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x[0]);
            primaryStage.setY(event.getScreenY() - y[0]);

        });




        primaryStage.show();
    }
}

