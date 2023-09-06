package com.example.mist_computer_club.controller.panes;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ctfadd  {

    @FXML
    private TextField ctf_name;

    @FXML
    private TextField date;

    @FXML
    private TextField lonk;

    @FXML
    private TextField month;

    @FXML
    private TextField year;

    @FXML
    void exit(MouseEvent event){
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void OK_CTF(MouseEvent event) throws IOException {
        if(!ctf_name.getText().isBlank()&&!date.getText().isBlank()&&!month.getText().isBlank()&&!year.getText().isBlank()&&!lonk.getText().isBlank()) {

        File CTF = new File(universal.path_ctf+"/"+ctf_name.getText()+".txt");
        if(CTF.exists()){
            universal.show_warning("This CTF is already added");
        }
        else {
            CTF.createNewFile();
            FileWriter file = new FileWriter(CTF);
            file.write(ctf_name.getText()+"\n");
            file.write(Integer.parseInt(date.getText())+"\n");
            file.write(Integer.parseInt(month.getText())+"\n");
            file.write(Integer.parseInt(year.getText())+"\n");
            file.write(lonk.getText()+"\n");
            file.close();


            ((Stage)((Node)event.getSource()).getScene().getWindow()).close();






        }

    }else universal.show_warning("Put all the required information");

}}
