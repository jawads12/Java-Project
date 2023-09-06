package com.example.mist_computer_club.controller.announcements;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class items implements Initializable {

    @FXML
    private Label date;

    @FXML
    private HBox itemC;

    @FXML
    private Label statement;

    String a, b, c;
    @FXML
    void details(MouseEvent event) throws IOException {
        universal.a = a;
        universal.b=b;
        universal.c = c;

       // universal.details_from_announce = statement.getText();
       // Parent pane = (FXMLLoader.load(Objects.requireNonNull(getClass().getResource())));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/announcement/details.fxml"));
        Parent root = loader.load();
        details detailscontroller = loader.getController();
       //detailscontroller.;

        Scene scene = new Scene(root);
        Stage stg = new Stage();
        stg.setScene(scene);
        stg.setResizable(false);
        stg.initStyle(StageStyle.UNDECORATED);
        stg.show();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        a  = universal.string_part1;
        b = universal.string_part2;
        c = universal.string_part3;
        statement.setText(universal.current_acc_name);
        date.setText(universal.Current_acc_roll);
    }
}
