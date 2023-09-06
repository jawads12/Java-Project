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

public class edit_page3 implements Initializable {

    @FXML
    private TextField class10;

    @FXML
    private TextField class11;

    @FXML
    private TextField class12;

    @FXML
    private TextField class9;

    @FXML
    private TextField date10;

    @FXML
    private TextField date11;

    @FXML
    private TextField date12;

    @FXML
    private TextField date9;

    @FXML
    private TextField date_10;

    @FXML
    private TextField date_11;

    @FXML
    private TextField date_12;

    @FXML
    private TextField date_9;

    @FXML
    void update(MouseEvent event) throws IOException {
        Thread edit3 = new Thread(new Runnable() {
            @Override
            public void run() {
                String Class1 = universal.path_Schedule+"/"+"Class9.txt";
                String Class2 = universal.path_Schedule+"/"+"Class10.txt";
                String Class3 = universal.path_Schedule+"/"+"Class11.txt";
                String Class4 = universal.path_Schedule+"/"+"Class12.txt";

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
                    writer1.write(class9.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer1.write(date9.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer1.write(date_9.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    writer2.write(class10.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer2.write(date10.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer2.write(date_10.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    writer3.write(class11.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer3.write(date11.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer3.write(date_11.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    writer4.write(class12.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer4.write(date12.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer4.write(date_12.getText()+"\n");
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
        }); edit3.start();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {

                String Class1 = universal.path_Schedule+"/"+"Class9.txt";
                String Class2 = universal.path_Schedule+"/"+"Class10.txt";
                String Class3 = universal.path_Schedule+"/"+"Class11.txt";
                String Class4 = universal.path_Schedule+"/"+"Class12.txt";

                File file1 = new File(Class1);
                File file2 = new File(Class2);
                File file3 = new File(Class3);
                File file4 = new File(Class4);

                try {
                    Scanner scan1 = new Scanner(file1);
                    Scanner scan2 = new Scanner(file2);
                    Scanner scan3 = new Scanner(file3);
                    Scanner scan4 = new Scanner(file4);

                    class9.setText(scan1.nextLine());
                    date9.setText(scan1.nextLine());
                    date_9.setText(scan1.nextLine());
                    scan1.close();


                    class10.setText(scan2.nextLine());
                    date10.setText(scan2.nextLine());
                    date_10.setText(scan2.nextLine());
                    scan2.close();

                    class11.setText(scan3.nextLine());
                    date11.setText(scan3.nextLine());
                    date_11.setText(scan3.nextLine());
                    scan3.close();


                    class12.setText(scan4.nextLine());
                    date12.setText(scan4.nextLine());
                    date_12.setText(scan4.nextLine());
                    scan4.close();


                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t3.start();

    }
}
