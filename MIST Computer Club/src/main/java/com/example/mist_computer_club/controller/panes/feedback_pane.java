package com.example.mist_computer_club.controller.panes;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class feedback_pane implements Initializable {

    @FXML
    private VBox pnl_contacts;

    @FXML
    private TextField search_field;

    @FXML
    void search(MouseEvent event) {
        pnl_contacts.getChildren().clear();

        File[] members = new File(universal.feedback_path).listFiles();
        assert members != null;
        System.out.println(members.length);
        Node[] nodes = new Node[600];
        int i = 0;
        for (File filename : members) {
            // System.out.println(i);


            universal.current_path = universal.feedback_path + "/";
            universal.current_path = universal.current_path + filename.getName();//........class 1
            universal.team_ame = filename.getName();
            File[] members_vitore = new File(universal.current_path).listFiles();
            assert members_vitore != null;
            System.out.println(members_vitore.length);
            //  Node[] nodes_vitore = new Node[Objects.requireNonNull(members).length];
            // int i = 0;
            int l = 0;
            universal.class_name = filename.getName();
            if(filename.getName().contains(search_field.getText())) {
                for (File filename_vitore : members_vitore) {
                    // System.out.println(i);

                    //
                    universal.path2 = universal.current_path + "/";
                    universal.path2 = universal.path2 + filename_vitore.getName();
                    File file = new File(universal.path2);
                    System.out.println(file.toPath());
                    Scanner neww = null;
                    try {
                        neww = new Scanner(file);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }


                    // universal.Current_email[l] = neww.nextLine();
                    //universal.Current_pic[l] = universal.path2+"/"+"image.jpg";
                    universal.current_acc_name = neww.nextLine();
                    universal.current_feed = neww.nextLine();

                    System.out.println(universal.current_feed);
                    l++;
                    neww.close();


                }



            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(Objects.requireNonNull(pane_manage_team_info.class.getResource("/feedback_ADMIN/d/feed_items.fxml")));

                //give the items some effect

                nodes[i].setOnMouseEntered(even -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(even -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });

                pnl_contacts.getChildren().add(nodes[i]); i++;
            } catch (IOException e) {
                e.printStackTrace();
            }


        }}
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File[] members = new File(universal.feedback_path).listFiles();
        assert members != null;
        System.out.println(members.length);
        Node[] nodes = new Node[600];
        int i = 0;
        for (File filename : members) {
            // System.out.println(i);


            universal.current_path = universal.feedback_path + "/";
            universal.current_path = universal.current_path + filename.getName();//........class 1
            universal.team_ame = filename.getName();
            File[] members_vitore = new File(universal.current_path).listFiles();
            assert members_vitore != null;
            System.out.println(members_vitore.length);
            //  Node[] nodes_vitore = new Node[Objects.requireNonNull(members).length];
            // int i = 0;
            int l = 0;
            universal.class_name = filename.getName();
            for (File filename_vitore : members_vitore) {
                // System.out.println(i);

                //
                universal.path2 = universal.current_path + "/";
                universal.path2 = universal.path2+ filename_vitore.getName();
                File file = new File(universal.path2);
                System.out.println(file.toPath());
                Scanner neww= null;
                try {
                    neww=  new Scanner(file);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }


               // universal.Current_email[l] = neww.nextLine();
                //universal.Current_pic[l] = universal.path2+"/"+"image.jpg";
                universal.current_acc_name = neww.nextLine();
                universal.current_feed = neww.nextLine();

                 System.out.println(universal.current_feed );
                l++;
                neww.close();


            }



            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(Objects.requireNonNull(pane_manage_team_info.class.getResource("/feedback_ADMIN/d/feed_items.fxml")));

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
    }
}
