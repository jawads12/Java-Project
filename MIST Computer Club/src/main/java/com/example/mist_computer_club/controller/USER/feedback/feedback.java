package com.example.mist_computer_club.controller.USER.feedback;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class feedback {

    @FXML
    private TextField class_name;

    @FXML
    private TextField feed;

    @FXML
    void store_feed(MouseEvent event) throws IOException {
        if(!class_name.getText().isBlank()&&!feed.getText().isBlank()) {
            String feedback = universal.feedback_path + "/" + class_name.getText();
            File neww = new File(feedback);
            if (!neww.exists()) {
                neww.mkdir();
            }

            FileWriter fileWriter = new FileWriter(new File(feedback + "/" + universal.current_acc_email_final + ".txt"));
            fileWriter.write(universal.current_acc_name_final + "\n");
            fileWriter.write(feed.getText());
            fileWriter.close();
            universal.show_success("Feedback sent successfully");
            feed.clear();
            class_name.clear();


        }else universal.show_warning("Give feedback correctly");

    }

}
