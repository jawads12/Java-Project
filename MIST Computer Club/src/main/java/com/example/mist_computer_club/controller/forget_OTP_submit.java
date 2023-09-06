package com.example.mist_computer_club.controller;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class forget_OTP_submit {

    @FXML
    private TextField otp;
    @FXML
    private Label label;

    @FXML
    void submit(MouseEvent event) throws IOException {
        if(Objects.equals(otp.getText(), Integer.toString(universal.OTP))) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/forget_pass_OTP_NewPass.fxml"));
            Parent panes = loader.load();
            Scene scene = new Scene(panes);
            Stage forget = new Stage();
            forget.setScene(scene);
            forget.setResizable(false);
            forget.initStyle(StageStyle.UNDECORATED);
            forget.show();

            ((Stage)((Node)event.getSource()).getScene().getWindow()).close();



        }

    }

}
