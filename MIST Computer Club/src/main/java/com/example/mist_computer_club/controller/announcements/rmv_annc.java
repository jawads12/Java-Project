package com.example.mist_computer_club.controller.announcements;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class rmv_annc {

    @FXML
    private TextField serial;
    @FXML
    void exit(MouseEvent event){
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }


    @FXML
    void remove(MouseEvent event) throws IOException {
        if(!serial.getText().isBlank()){

        File[] members = new File(universal.path_announces).listFiles();
        assert members != null;
        if(universal.count>0){
            int i  =1;
            for(File filename : members) {
                if (i == Integer.parseInt(serial.getText())) {

                    File file = new File(filename.toURI());

                    System.out.println(filename);
                    if (file.exists()) {
                        System.out.println("exist");
                        FileUtils.forceDelete(file);
                        System.out.println("Deleted");
                        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
                    }

                }
                i++;
            }
    }

}
    else universal.show_warning("Put Serial");

    }}
