package com.example.mist_computer_club.controller.announcements;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class add_announce {

    @FXML
    private TextField annc_name;

    @FXML
    private TextField annc_name1;

    @FXML
    private TextField annc_name2;

    @FXML
    private TextField date;

    @FXML
    private TextField month;

    @FXML
    private TextField year;

    @FXML
    void OK_anc(MouseEvent event) throws IOException {

        if(!annc_name.getText().isBlank()&&!date.getText().isBlank()&&!month.getText().isBlank()&&!year.getText().isBlank()) {
            //int a = universal.count;
            File annc = new File(universal.path_announces + "/" + Integer.toString(++universal.count) + ".txt");

            annc.createNewFile();
            FileWriter file = new FileWriter(annc);
            file.write(annc_name.getText() + "\n" + annc_name1.getText() + "\n" + annc_name2.getText() + "\n");
            file.write(Integer.parseInt(date.getText()) + "-");
            file.write(Integer.parseInt(month.getText()) + "-");
            file.write(Integer.parseInt(year.getText()) + "\n");
            //  file.write(lonk.getText()+"\n");
            file.close();
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        }
        else universal.show_warning("Make announcement properly with date");



        }

        @FXML
    void exit(MouseEvent event){
            ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
        }

}
