package com.example.mist_computer_club.controller.USER.CTF;

import com.example.mist_computer_club.controller.admin_dashboard;
import com.example.mist_computer_club.controller.panes.pane_manage_team_info;
import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ctf implements Initializable {

    @FXML
    private AnchorPane anchor;

    @FXML
    private VBox team_vbox;
    @FXML
    private admin_dashboard mainTestController;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File[] members = new File(universal.path_ctf).listFiles();
        assert members != null;
        Arrays.sort(members, Comparator.comparingLong(File::lastModified));
        System.out.println(members.length);
        Node[] nodes = new Node[Objects.requireNonNull(members).length];
        int i = 0;
        for (File filename : members) {
            // System.out.println(i);
            universal.current_path = universal.path_ctf + "/";
            universal.current_path = universal.current_path + filename.getName();
            System.out.println(universal.current_path);
            File p_info = new File(universal.current_path);
            if (p_info.exists()) System.out.println("exist");
            Scanner inforeader = null;
            try {
                inforeader = new Scanner(p_info);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println("yes");
            //  System.out.println(inforeader.nextLine());


            universal.current_acc_name = inforeader.nextLine();
            universal.Current_acc_roll = Integer.toString(inforeader.nextInt()) + "-" + Integer.toString(inforeader.nextInt()) + "-" + Integer.toString(inforeader.nextInt());
            //  inforeader.nextLine();
            universal.Current_acc_dept = inforeader.next();
            //   System.out.println(universal.current_acc_name);
            //  System.out.println(universal.Current_acc_roll);

            System.out.println(universal.Current_acc_dept);
            inforeader.close();


            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(Objects.requireNonNull(ctf.class.getResource("/USER/admin_panes/CTF/ctf_.fxml")));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });


                team_vbox.getChildren().add(nodes[i]);
                i++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



//cvOAR0;
//1OZEKP;