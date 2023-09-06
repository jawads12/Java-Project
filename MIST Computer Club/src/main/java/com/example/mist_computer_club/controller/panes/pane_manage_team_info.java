package com.example.mist_computer_club.controller.panes;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class pane_manage_team_info implements Initializable {

    @FXML
    private AnchorPane anchor;

    @FXML
    private VBox team_vbox;


    @FXML
    void addTeam(MouseEvent event) throws IOException {
        System.out.println("hi");
        anchor.getChildren().add(FXMLLoader.load(Objects.requireNonNull(pane_manage_team_info.class.getResource("/admin_panes/team_reg.fxml"))));

    }

    @FXML
    void deleteTeam(MouseEvent event) throws IOException {
        anchor.getChildren().add(FXMLLoader.load(Objects.requireNonNull(pane_manage_team_info.class.getResource("/admin_panes/team_min.fxml"))));


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if( universal.uni_node_team.size() !=0){
            team_vbox.getChildren().addAll(universal.uni_node_team);



        }
        else {





        File[] members = new File(universal.path_team).listFiles();
        assert members != null;
        System.out.println(members.length);
        Node[] nodes = new Node[Objects.requireNonNull(members).length];
        int i = 0;
        for (File filename : members) {
            // System.out.println(i);


            universal.current_path = universal.path_team + "/";
            universal.current_path = universal.current_path + filename.getName();//........403_Forbidden
            universal.team_ame = filename.getName();
            File[] members_vitore = new File(universal.current_path).listFiles();
            assert members_vitore != null;
            System.out.println(members_vitore.length);
            //  Node[] nodes_vitore = new Node[Objects.requireNonNull(members).length];
           // int i = 0;
            int l = 0;
            for (File filename_vitore : members_vitore) {
                // System.out.println(i);

                //
                universal.path2 = universal.current_path + "/";
                universal.path2 = universal.path2+ filename_vitore.getName();
                File file = new File(universal.path2+"/"+"info.txt");
                System.out.println(file.toPath());
                Scanner neww= null;
                try {
                   neww=  new Scanner(file);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }


                universal.Current_email[l] = neww.nextLine();
                universal.Current_pic[l] = universal.path2+"/"+"image.jpg";
               // System.out.println(universal.Current_pic[l]);
                l++;
                neww.close();


            }



            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(Objects.requireNonNull(pane_manage_team_info.class.getResource("/admin_panes/teams_.fxml")));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });

                team_vbox.getChildren().add(nodes[i]);
                universal.uni_node_team.add(nodes[i]); i++;
            } catch (IOException e) {
                e.printStackTrace();
            }



        }

        universal.uni_vbox =new VBox(team_vbox);

    }}
}