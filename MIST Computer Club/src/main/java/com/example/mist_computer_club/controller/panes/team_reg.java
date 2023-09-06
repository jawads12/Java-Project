package com.example.mist_computer_club.controller.panes;


import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.Object;
import org.apache.commons.io.FileUtils;


public class team_reg {

    @FXML
    private TextField email1;

    @FXML
    private TextField email2;

    @FXML
    private TextField email3;

    @FXML
    private TextField email4;

    @FXML
    private TextField team;

    @FXML
    void add_team(MouseEvent event) throws IOException {
        String email11 = email1.getText();
        String email22 = email2.getText();
        String email33 = email3.getText();
        String email44 = email4.getText();
        String team_name = team.getText();


        if(email11.isBlank()||email22.isBlank()||email33.isBlank()||email44.isBlank()||team_name.isBlank()) {
            universal.show_warning("No field can be kept empty");
        }
        else {
            String teampath = universal.path_team;
            teampath= teampath+"/";
            File teams = new File(teampath+team_name);
            if(teams.exists()) {
                System.out.println("Team created already");
                universal.show_warning("OOPS! Team created already!");


            }

            else{
                if(teams.mkdir()) System.out.println("Successfully Account Opened");
                Path source1 = Paths.get(universal.path+"/"+email11);
                Path source2 = Paths.get(universal.path+"/"+email22);
                Path source3 = Paths.get(universal.path+"/"+email33);
                Path source4 = Paths.get(universal.path+"/"+email44);
                Path target = Paths.get(universal.path_team+"/"+team_name);


               // Path Ttarget = Paths.get(universal.path_team+"/"+team_name);
               File team1 = new File(universal.path+"/"+email11+"/"+"team.txt");
               File team2 = new File(universal.path+"/"+email22+"/"+"team.txt");
               File team3 = new File(universal.path+"/"+email33+"/"+"team.txt");
               File team4 = new File(universal.path+"/"+email44+"/"+"team.txt");


                FileWriter file1 = new FileWriter(team1);
                file1.write(team_name); file1.close();

                FileWriter file2 = new FileWriter(team2);
                file2.write(team_name); file2.close();
                FileWriter file3 = new FileWriter(team3);
                file3.write(team_name); file3.close();
                FileWriter file4 = new FileWriter(team4);
                file4.write(team_name); file4.close();








                //   teampath=teampath+team_name;
               // universal.copyFile(source1.toFile(), target.toFile());
                FileUtils.copyDirectoryToDirectory(source1.toFile(),target.toFile());
                FileUtils.copyDirectoryToDirectory(source2.toFile(),target.toFile());
                FileUtils.copyDirectoryToDirectory(source3.toFile(),target.toFile());
                FileUtils.copyDirectoryToDirectory(source4.toFile(),target.toFile());



                universal.uni_node_team.clear();








            }



        }

    }

}
