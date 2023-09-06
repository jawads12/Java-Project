package com.example.mist_computer_club.controller.USER.Class_Schedule;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class edit_page2 implements Initializable {

    @FXML
    private Label class5;

    @FXML
    private Label class6;

    @FXML
    private Label class7;

    @FXML
    private Label class8;

    @FXML
    private Label date5;

    @FXML
    private Label date6;

    @FXML
    private Label date7;

    @FXML
    private Label date8;

    @FXML
    private Label date_5;

    @FXML
    private Label date_6;

    @FXML
    private Label date_7;

    @FXML
    private Label date_8;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                String Class1 = universal.path_Schedule+"/"+"Class5.txt";
                String Class2 = universal.path_Schedule+"/"+"Class6.txt";
                String Class3 = universal.path_Schedule+"/"+"Class7.txt";
                String Class4 = universal.path_Schedule+"/"+"Class8.txt";

                File file1 = new File(Class1);
                File file2 = new File(Class2);
                File file3 = new File(Class3);
                File file4 = new File(Class4);

                try {
                    Scanner scan1 = new Scanner(file1);
                    Scanner scan2 = new Scanner(file2);
                    Scanner scan3 = new Scanner(file3);
                    Scanner scan4 = new Scanner(file4);

                    class5.setText(scan1.nextLine());
                    date5.setText(scan1.nextLine());
                    date_5.setText(scan1.nextLine());
                    scan1.close();


                    class6.setText(scan2.nextLine());
                    date6.setText(scan2.nextLine());
                    date_6.setText(scan2.nextLine());
                    scan2.close();

                    class7.setText(scan3.nextLine());
                    date7.setText(scan3.nextLine());
                    date_7.setText(scan3.nextLine());
                    scan3.close();


                    class8.setText(scan4.nextLine());
                    date8.setText(scan4.nextLine());
                    date_8.setText(scan4.nextLine());
                    scan4.close();


                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t2.start();

    }
}
