package com.example.mist_computer_club.controller.USER;

import com.example.mist_computer_club.universal;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class my_profile implements Initializable {


    @FXML
    private TextField address;

    @FXML
    private AnchorPane anchor;

    @FXML
    private TextField dept;

    @FXML
    private TextField dob;

    @FXML
    private TextField email;

    @FXML
    private TextField id;

    @FXML
    private ImageView im1;

    @FXML
    private ImageView im2;

    @FXML
    private ImageView im3;

    @FXML
    private ImageView im4;

    @FXML
    private ImageView im5;

    @FXML
    private ImageView im6;

    @FXML
    private ImageView im7;

    @FXML
    private ImageView im8;

    @FXML
    private TextField name;

    @FXML
    private TextField phone;

    @FXML
    private TextField team_name;
    @FXML
    private TextField level;

    @FXML
    void update_pass(MouseEvent event) throws IOException {
        FXMLLoader loaderMainWindow = new FXMLLoader(getClass().getResource("/forget_pass.fxml"));
        Pane pan = loaderMainWindow.load();
        Scene scn = new Scene(pan);
        Stage stg = new Stage();
        stg.setScene(scn);stg.initStyle(StageStyle.UNDECORATED); stg.show();
    }

    @FXML
    void update_profile(MouseEvent event) throws IOException {
        String path = universal.path + "/" + universal.current_acc_email_final + "/" + "info.txt";
       // FileWriter file = new FileWriter(path);
        FileWriter infos = new FileWriter(path);
        infos.write(name.getText()+"\n");
        infos.write(id.getText()+"\n");
        infos.write(dept.getText()+"\n");
        infos.write(email.getText()+"\n");
        infos.write(address.getText()+"\n");
        infos.write(phone.getText()+"\n");
        infos.write(dob.getText()+"\n");
        infos.write(level.getText()+"\n");
        infos.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String path = universal.path + "/" + universal.current_acc_email_final + "/" + "info.txt";
        Scanner scan;
        System.out.println(path);
        try {
            scan = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        name.setText(scan.nextLine());
        id.setText(scan.nextLine());
        dept.setText(scan.nextLine());
        email.setText(scan.nextLine());
        address.setText(scan.nextLine());
        phone.setText(scan.nextLine());
        dob.setText(scan.nextLine());
        level.setText(scan.nextLine());
        scan.close();

        String path_team = universal.path + "/" + universal.current_acc_email_final + "/" + "team.txt";
        Scanner scan_team;
       // System.out.println(path);
        try {
            scan_team = new Scanner(new File(path_team));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(scan_team.hasNextLine()){
        team_name.setText(scan_team.nextLine());
        scan_team.close();}


        FadeTransition rotate = new FadeTransition();
        rotate.setNode(im1);
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setDuration(Duration.millis(7000));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setFromValue(0);
        rotate.setToValue(1);
        // rotate.setAutoReverse(true);
        rotate.play();

        FadeTransition rotate1 = new FadeTransition();
        rotate1.setNode(im4);
        rotate1.setCycleCount(TranslateTransition.INDEFINITE);
        rotate1.setDuration(Duration.millis(4000));
        rotate1.setInterpolator(Interpolator.LINEAR);
        rotate1.setFromValue(0);
        rotate1.setToValue(1);
        //  rotate1.setAutoReverse(true);
        rotate1.play();

        FadeTransition rotate2 = new FadeTransition();
        rotate2.setNode(im3);
        rotate2.setCycleCount(TranslateTransition.INDEFINITE);
        rotate2.setDuration(Duration.millis(7000));
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.setFromValue(0);
        rotate2.setToValue(1);
        //  rotate2.setAutoReverse(true);
        rotate2.play();

        FadeTransition rotate3 = new FadeTransition();
        rotate3.setNode(im7);
        rotate3.setCycleCount(TranslateTransition.INDEFINITE);
        rotate3.setDuration(Duration.millis(5000));
        rotate3.setInterpolator(Interpolator.LINEAR);
        rotate3.setFromValue(0);
        rotate3.setToValue(1);
        //  rotate3.setAutoReverse(true);
        rotate3.play();


    }
}
