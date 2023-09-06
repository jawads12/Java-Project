package com.example.mist_computer_club.controller.announcements;

import com.example.mist_computer_club.controller.panes.pane_contact_info;
import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class announcements_pane implements Initializable {
    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;


    @FXML
    private VBox announces;

    @FXML
    void add(MouseEvent event) throws IOException {

        //fxml load
        Parent pane = (FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/announcement/add_announce.fxml"))));
        Scene scene = new Scene(pane);
        Stage stg = new Stage();
        stg.setScene(scene);
        stg.setResizable(false);
        stg.initStyle(StageStyle.UNDECORATED);
        stg.show();

        if(!stg.isShowing()) System.out.println("Ekhon pore") ;




    }

    @FXML

    void up(MouseEvent event){
    update();
    }

    @FXML
    void dlt(MouseEvent event) throws IOException {
        //

        Parent pane = (FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/announcement/remove_annc.fxml"))));
        Scene scene = new Scene(pane);
        Stage stg = new Stage();
        stg.setScene(scene);
        stg.setResizable(false);
        stg.initStyle(StageStyle.UNDECORATED);
        stg.show();





    }

    public void update(){
        announces.getChildren().clear();
        File[] members = new File(universal.path_announces).listFiles();
        assert members != null;
        Arrays.sort(members, Comparator.comparingLong(File::lastModified));

        System.out.println(members.length);
        if(universal.count>0){
            Node[] nodes = new Node[Objects.requireNonNull(members).length];
            int i  =0;
            for(File filename : members) {
                // System.out.println(i);
                universal.current_path = universal.path_announces + "/";
                universal.current_path = universal.current_path + filename.getName() ;
                File p_info = new File(universal.current_path );
                System.out.println(universal.current_path);


                Scanner inforeader = null;
                try {
                    inforeader = new Scanner(p_info);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

                universal.string_part1 = inforeader.nextLine();
                universal.string_part2 = inforeader.nextLine();
                universal.string_part3 = inforeader.nextLine();

                universal.current_acc_name =" "+ Integer.toString(i+1)+"   "+ universal.string_part1+" "+ universal.string_part2+ " " + universal.string_part3 ;
                universal.Current_acc_roll = inforeader.nextLine();
                inforeader.close();
                // universal.Current_acc_dept = inforeader.nextLine();
                // inforeader.nextLine();
                //  inforeader.nextLine();
                // universal.Current_acc_phone = inforeader.nextLine();
                //   System.out.println(universal.current_acc_name);
                System.out.println("eddur aschi");


                final int j = i;
                try {
                    nodes[i] = FXMLLoader.load(Objects.requireNonNull(pane_contact_info.class.getResource("/announcement/announce_item.fxml")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });


                universal.i = i+1;
                announces.getChildren().add(nodes[i]);
                i++;
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       File[] members = new File(universal.path_announces).listFiles();
        assert members != null;
        Arrays.sort(members, Comparator.comparingLong(File::lastModified));

       System.out.println(members.length);
        if(universal.count>0){
        Node[] nodes = new Node[Objects.requireNonNull(members).length];
        int i  =0;
        for(File filename : members) {
            // System.out.println(i);
            universal.current_path = universal.path_announces + "/";
            universal.current_path = universal.current_path + filename.getName() ;
            File p_info = new File(universal.current_path );
            System.out.println(universal.current_path);


            Scanner inforeader = null;
            try {
                inforeader = new Scanner(p_info);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            universal.string_part1 = inforeader.nextLine();
            universal.string_part2 = inforeader.nextLine();
            universal.string_part3 = inforeader.nextLine();

            universal.current_acc_name =" "+ Integer.toString(i+1)+"   "+ universal.string_part1+" "+ universal.string_part2+ " " + universal.string_part3 ;
            universal.Current_acc_roll = inforeader.nextLine();
            inforeader.close();
           // universal.Current_acc_dept = inforeader.nextLine();
           // inforeader.nextLine();
          //  inforeader.nextLine();
           // universal.Current_acc_phone = inforeader.nextLine();
            //   System.out.println(universal.current_acc_name);
            System.out.println("eddur aschi");


            final int j = i;
            try {
                nodes[i] = FXMLLoader.load(Objects.requireNonNull(pane_contact_info.class.getResource("/announcement/announce_item.fxml")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //give the items some effect

            nodes[i].setOnMouseEntered(event -> {
                nodes[j].setStyle("-fx-background-color : #0A0E3F");
            });
            nodes[i].setOnMouseExited(event -> {
                nodes[j].setStyle("-fx-background-color : #02030A");
            });


            universal.i = i+1;
             announces.getChildren().add(nodes[i]);
            i++;
        }

        }
    }

}
