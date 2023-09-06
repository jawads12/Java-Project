package com.example.mist_computer_club.controller.panes;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class team_min{

    @FXML
    private TextField team;

    @FXML
    void delete(MouseEvent event) throws IOException {
        String team_name = team.getText();
      //  System.out.println(team_name);
        String path = universal.path_team+"/"+team_name;

        if(!(new File(path)).exists()) universal.show_warning("Team doesn't exist!!!");
        else {
            universal.show_warning("Äre you sure? It will delete the whole team info");
            FileUtils.deleteDirectory(new File(path));
            team.setText("Team Removed");
            System.out.println("worked");
        }


        universal.uni_node_team.clear();

    }

}
