package com.example.mist_computer_club.controller;

import com.example.mist_computer_club.hash_generator;
import com.example.mist_computer_club.universal;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

public class LoginReg {

    @FXML
    private TextField email;

    @FXML
    private PasswordField pass;

    @FXML
    private Text forget;



    @FXML
    void fb(MouseEvent event) {
        if( Desktop.isDesktopSupported() )
        {
            new Thread(() -> {
                try {
                    Desktop.getDesktop().browse( new URI("https://www.facebook.com/profile.php?id=100085653294890") );
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }).start();
        }
    }


    @FXML
    void linked(MouseEvent event) {
        if( Desktop.isDesktopSupported() )
        {
            new Thread(() -> {
                try {
                    Desktop.getDesktop().browse( new URI("https://www.linkedin.com/company/89561600/admin/") );
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }).start();
        }
    }



    @FXML
    void youtube(MouseEvent event) {
        if( Desktop.isDesktopSupported() )
        {
            new Thread(() -> {
                try {
                    Desktop.getDesktop().browse( new URI("https://www.youtube.com/watch?v=UarShE3-jio&list=PLxY81jSrbuR_X7EDsmaZK2mgdr1ECeU_t") );
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }).start();
        }
    }


    @FXML
    void forget_pass(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/forget_pass.fxml"));
        Parent panes = loader.load();
        Scene scene = new Scene(panes);
        Stage forget = new Stage();
        forget.setScene(scene);
        forget.setResizable(false);
        forget.initStyle(StageStyle.UNDECORATED);
        final double[] x = new double[1];
        final double[] y = new double[1];
        panes.setOnMousePressed(evet -> {
            x[0] = evet.getSceneX();
            y[0] = evet.getSceneY();
        });
        panes.setOnMouseDragged(evet -> {

            forget.setX(evet.getScreenX() - x[0]);
            forget.setY(evet.getScreenY() - y[0]);

        });


        forget.show();






    }







    @FXML
    void joinkor(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/register.fxml"));
        Parent pane = loader.load();
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
       // Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("MIST Cyber Security Club Joining Form");
        stage.getIcons().add(new Image("E:\\Java\\Projects\\MIST Computer CLub\\MIST Computer Club\\src\\main\\resources\\icon\\ct.png"));
       // "E:\Java\Projects\MIST Computer CLub\MIST Computer Club\src\main\resources\icon\ct.ico"
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        final double[] x = new double[1];
        final double[] y = new double[1];
        pane.setOnMousePressed(evet -> {
            x[0] = evet.getSceneX();
            y[0] = evet.getSceneY();
        });
        pane.setOnMouseDragged(evet -> {

            stage.setX(evet.getScreenX() - x[0]);
            stage.setY(evet.getScreenY() - y[0]);

        });


        stage.show();

    }


    @FXML
    void login(MouseEvent event) throws IOException {
        try {

            if (Objects.equals(pass.getText(), "123")) {
                //admin login
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/SuperAdmin.fxml"));
                Parent pane = loader.load();
                Scene scene = new Scene(pane);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.getIcons().add(new Image("E:\\Java\\Projects\\MIST Computer CLub\\MIST Computer Club\\src\\main\\resources\\icon\\ct.png"));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();


                Stage curr = (Stage) ((Node) event.getSource()).getScene().getWindow();
                curr.close();


            } else {

                String path_new_acc = universal.path + "/" + email.getText();
                File p = new File(path_new_acc);
                if (p.exists()) {
                    System.out.println("Account Exists");


                    path_new_acc = path_new_acc + "/";
                    File p_hash = new File(path_new_acc + "hash.txt");
                    Scanner myReader = new Scanner(p_hash);
                    String datas = myReader.nextLine();
                    myReader.close();
                    String password = hash_generator.getHash(pass.getText(), "SHA-256");

                    if (Objects.equals(password, datas)) {


                        File p_info = new File(path_new_acc + "info.txt");
                        Scanner inforeader = new Scanner(p_info);
                        universal.current_acc_name_final = inforeader.nextLine();
                        universal.Current_acc_roll_final = inforeader.nextLine();
                        universal.Current_acc_dept_final = inforeader.nextLine();
                        universal.current_acc_email_final = email.getText();

                        universal.current_acc_name = universal.current_acc_name_final;
                        universal.Current_acc_roll = universal.Current_acc_roll_final;
                        universal.Current_acc_dept = universal.Current_acc_dept_final;

                        File p_ = new File(path_new_acc + "team.txt");
                        Scanner neww = new Scanner(p_);

                        if (neww.hasNextLine()) {
                            universal.current_acc_team_name = neww.nextLine();
                            neww.close();
                        }
                        // System.out.println(universal.current_acc_name);


                        System.out.println("Password matched");
                        universal.current_path = path_new_acc;
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/USER/Student_DASH.fxml"));
                        Parent pane = loader.load();
                        Scene scene = new Scene(pane);
                        Stage stage = new Stage();
                        stage.setScene(scene);

                        stage.getIcons().add(new Image("E:\\Java\\Projects\\MIST Computer CLub\\MIST Computer Club\\src\\main\\resources\\icon\\ct.png"));
                        Stage curr = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        curr.close();


                        stage.setResizable(false);
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.show();

                        // stage.setMaximized(true);


                    } else{ universal.show_warning("Password not matched"); throw new Exception("Password not matched");}


                } else{ universal.show_warning("This is not a valid Email"); throw new Exception("This is not a valid email");}

            }


        }catch (Exception e){
            System.out.println(e);
        }

    }



}
