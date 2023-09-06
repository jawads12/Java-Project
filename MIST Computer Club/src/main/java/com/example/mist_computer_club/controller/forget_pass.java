package com.example.mist_computer_club.controller;

import com.example.mist_computer_club.Mail_background_task;
import com.example.mist_computer_club.universal;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

public class forget_pass {

    @FXML
    private TextField email;

    @FXML
    private void exit(MouseEvent e){
        ((Stage)((Node)e.getSource()).getScene().getWindow()).close();

    }

    @FXML
    void send_OTP(MouseEvent event) throws IOException {
        if(email.getText().isBlank())
        {
            universal.show_warning("Give Email");
        }
        else
        {
            try
            {
                Mail_background_task mail_background_task = new Mail_background_task(email.getText());
                universal.current_acc_name = email.getText();
                universal.current_path = universal.path+"/"+universal.current_acc_name;
                if(new File(universal.path+"/"+universal.current_acc_name).exists()) {
                    Thread thread = new Thread(mail_background_task);
                    thread.setDaemon(true);
                    thread.start();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/forget_pass_OTP.fxml"));
                    Parent panes = loader.load();
                    Scene scene = new Scene(panes);
                    Stage forget = new Stage();
                    forget.setScene(scene);
                    forget.setResizable(false);
                    forget.initStyle(StageStyle.UNDECORATED);
                    forget.show();
                    ((Stage) ((Node)event.getSource()).getScene().getWindow()).close();

                }
                else universal.show_warning("It is not a member's Email");


               // third_pane.setVisible(true);
            }
            catch (Exception e)
            {
                System.out.println("Email not sent");
            }
        }




    }

}
