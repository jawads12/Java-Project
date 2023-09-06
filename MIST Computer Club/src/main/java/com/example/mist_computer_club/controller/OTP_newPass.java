package com.example.mist_computer_club.controller;

import com.example.mist_computer_club.hash_generator;
import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class OTP_newPass {

    @FXML
    private TextField con_pass;

    @FXML
    private TextField new_pass;

    @FXML
    void set(MouseEvent event) throws IOException {
        if(Objects.equals(con_pass.getText(), new_pass.getText())){
            universal.current_path = universal.current_path+"/"+"hash.txt";
            File file = new File(universal.current_path);
            FileWriter neww_writer = new FileWriter(file);
            neww_writer.write(hash_generator.getHash(new_pass.getText(),"SHA-256"));
            neww_writer.close();
        }
        universal.show_warning("Password Updated");
         ((Stage) ((Node)event.getSource()).getScene().getWindow()).close();

    }

}
