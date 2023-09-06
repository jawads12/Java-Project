package com.example.mist_computer_club.controller.panes;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ctfrmv {

    @FXML
    private TextField ctf_name;

    @FXML
    void exit(MouseEvent event){
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }
    @FXML
    void OK_CTF(MouseEvent event) throws IOException {
        
        File file = new File(universal.path_ctf+"/"+ctf_name.getText()+".txt");
      //  System.out.println(universal.path_ctf+"/"+ctf_name.getText()+".txt");
        if(file.exists()){
            System.out.println("exist");
           FileUtils.forceDelete(file);
           System.out.println("Deleted");
           ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
        }
        else universal.show_warning("CTF is not in list");


    }

}
