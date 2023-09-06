package com.example.mist_computer_club.controller.panes;

import com.example.mist_computer_club.universal;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class pane_contact_info implements Initializable {


    @FXML
    private VBox pnl_contacts;

    @FXML
    private TextField search_field;



    @FXML
    void search(MouseEvent event) {
        pnl_contacts.getChildren().clear();
        File[] members = new File(universal.path).listFiles();
        assert members != null;
        System.out.println(members.length);
        Node[] nodes = new Node[Objects.requireNonNull(members).length];
        int i = 0;
        for (File filename : members) {
            // System.out.println(i);
            universal.current_path = universal.path + "/";
            universal.current_path = universal.current_path + filename.getName() + "/";
            File p_info = new File(universal.current_path + "info.txt");
            Scanner inforeader;
            try {
                inforeader = new Scanner(p_info);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            universal.current_acc_name = inforeader.nextLine();
            universal.Current_acc_roll = inforeader.nextLine();
            universal.Current_acc_dept = inforeader.nextLine();
            inforeader.nextLine();
            inforeader.nextLine();
            universal.Current_acc_phone = inforeader.nextLine();inforeader.nextLine();
            universal.Current_level = inforeader.nextLine();
            inforeader.close();
            //   System.out.println(universal.current_acc_name);
            if (universal.current_acc_name.contains(search_field.getText()) || universal.Current_acc_roll.contains(search_field.getText()) || universal.Current_acc_phone.contains(search_field.getText()) || universal.Current_acc_dept.contains(search_field.getText())||universal.Current_level.contains(search_field.getText()))

            {
                try {
                    nodes[i] = FXMLLoader.load(Objects.requireNonNull(pane_contact_info.class.getResource("/admin_panes/contacts.fxml")));

                    pnl_contacts.getChildren().add(nodes[i]);
                    i++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //  universal.Current_acc_


        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Platform.runLater(()->{
            File [] members = new File(universal.path).listFiles();
            assert members != null;
            System.out.println(members.length);
            Node[] nodes = new Node[Objects.requireNonNull(members).length];
            int i  =0;
            for(File filename : members){
                // System.out.println(i);
                universal.current_path = universal.path+"/";
                universal.current_path = universal.current_path+filename.getName()+"/";
                File p_info = new File(universal.current_path + "info.txt");
                Scanner inforeader = null;
                try {
                    inforeader = new Scanner(p_info);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                universal.current_acc_name = inforeader.nextLine();
                universal.Current_acc_roll = inforeader.nextLine();
                universal.Current_acc_dept = inforeader.nextLine();
                inforeader.nextLine(); inforeader.nextLine();
                universal.Current_acc_phone = inforeader.nextLine();inforeader.nextLine();
                universal.Current_level=inforeader.nextLine();
                inforeader.close();
                //   System.out.println(universal.current_acc_name);
                try {

                    final int j = i;
                    nodes[i] = FXMLLoader.load(Objects.requireNonNull(pane_contact_info.class.getResource("/admin_panes/contacts.fxml")));

                    //give the items some effect

                    nodes[i].setOnMouseEntered(event -> {
                        nodes[j].setStyle("-fx-background-color : #0A0E3F");
                    });
                    nodes[i].setOnMouseExited(event -> {
                        nodes[j].setStyle("-fx-background-color : #02030A");
                    });
                    pnl_contacts.getChildren().add(nodes[i]); i++;
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

}}
