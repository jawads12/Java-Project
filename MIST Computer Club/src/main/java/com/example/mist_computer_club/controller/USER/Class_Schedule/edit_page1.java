package com.example.mist_computer_club.controller.USER.Class_Schedule;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polyline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class edit_page1 implements Initializable {

    @FXML
    private Label class1;

    @FXML
    private Label class2;

    @FXML
    private Label class3;

    @FXML
    private Label class4;

    @FXML
    private Label date1;

    @FXML
    private Label date2;

    @FXML
    private Label date3;

    @FXML
    private Label date4;

    @FXML
    private Label date_1;

    @FXML
    private Label date_2;

    @FXML
    private Label date_3;

    @FXML
    private Label date_4;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                String Class1 = universal.path_Schedule+"/"+"Class1.txt";
                String Class2 = universal.path_Schedule+"/"+"Class2.txt";
                String Class3 = universal.path_Schedule+"/"+"Class3.txt";
                String Class4 = universal.path_Schedule+"/"+"Class4.txt";

                File file1 = new File(Class1);
                File file2 = new File(Class2);
                File file3 = new File(Class3);
                File file4 = new File(Class4);

                try {
                    Scanner scan1 = new Scanner(file1);
                    Scanner scan2 = new Scanner(file2);
                    Scanner scan3 = new Scanner(file3);
                    Scanner scan4 = new Scanner(file4);

                    if(scan1.hasNextLine()) class1.setText(scan1.nextLine());
                    if(scan1.hasNextLine()) date1.setText(scan1.nextLine());
                    if(scan1.hasNextLine()) date_1.setText(scan1.nextLine());
                    scan1.close();


                    if(scan2.hasNextLine()) class2.setText(scan2.nextLine());
                    if(scan2.hasNextLine()) date2.setText(scan2.nextLine());
                    if(scan2.hasNextLine())  date_2.setText(scan2.nextLine());
                    scan2.close();

                    if(scan3.hasNextLine()) class3.setText(scan3.nextLine());
                    if(scan3.hasNextLine()) date3.setText(scan3.nextLine());
                    if(scan3.hasNextLine())  date_3.setText(scan3.nextLine());
                    scan3.close();


                  if(scan4.hasNextLine())  class4.setText(scan4.nextLine());
                  if(scan4.hasNextLine()) date4.setText(scan4.nextLine());
                  if(scan4.hasNextLine()) date_4.setText(scan4.nextLine());
                  scan4.close();


                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();



    }
}

