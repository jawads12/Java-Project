package com.example.mist_computer_club.controller.Class_Schedule;

import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class edit_page2 implements Initializable {

    @FXML
    private TextField class5;

    @FXML
    private TextField class6;

    @FXML
    private TextField class7;

    @FXML
    private TextField class8;

    @FXML
    private TextField date5;

    @FXML
    private TextField date6;

    @FXML
    private TextField date7;

    @FXML
    private TextField date8;

    @FXML
    private TextField date_5;

    @FXML
    private TextField date_6;

    @FXML
    private TextField date_7;

    @FXML
    private TextField date_8;

    @FXML
    void update(MouseEvent event) throws IOException {
        Thread edit2 = new Thread(new Runnable() {
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


                FileWriter writer1 = null;
                try {
                    writer1 = new FileWriter(file1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                FileWriter writer2 = null;
                try {
                    writer2 = new FileWriter(file2);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                FileWriter writer3 = null;
                try {
                    writer3 = new FileWriter(file3);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                FileWriter writer4 = null;
                try {
                    writer4 = new FileWriter(file4);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    writer1.write(class5.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer1.write(date5.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer1.write(date_5.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    writer2.write(class6.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer2.write(date6.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer2.write(date_6.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    writer3.write(class7.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer3.write(date7.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer3.write(date_7.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    writer4.write(class8.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer4.write(date8.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer4.write(date_8.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    writer1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer2.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer3.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer4.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });edit2.start();


    }

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
