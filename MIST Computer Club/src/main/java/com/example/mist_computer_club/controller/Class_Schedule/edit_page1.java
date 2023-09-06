package com.example.mist_computer_club.controller.Class_Schedule;

import com.example.mist_computer_club.controller.admin_dashboard;
import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polyline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class edit_page1 implements Initializable {

    @FXML
    private TextField class1;

    @FXML
    private TextField class2;

    @FXML
    private TextField class3;

    @FXML
    private TextField class4;

    @FXML
    private TextField date1;

    @FXML
    private TextField date2;

    @FXML
    private TextField date3;

    @FXML
    private TextField date4;

    @FXML
    private TextField date_1;

    @FXML
    private TextField date_2;

    @FXML
    private TextField date_3;

    @FXML
    private TextField date_4;

    @FXML
    private Polyline load_page2;

    @FXML
    void update(MouseEvent event) throws IOException {
        Thread edit1 = new Thread(new Runnable() {
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
                    writer1.write(class1.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer1.write(date1.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer1.write(date_1.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    writer2.write(class2.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer2.write(date2.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer2.write(date_2.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    writer3.write(class3.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer3.write(date3.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer3.write(date_3.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    writer4.write(class4.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer4.write(date4.getText()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writer4.write(date_4.getText()+"\n");
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
        });  edit1.start();


    }






    @FXML
    private void load_page2(MouseEvent event) throws IOException {
      //  this.parentController.anchor.getChildren().add(FXMLLoader.load(Objects.requireNonNull(admin_dashboard.class.getResource("/admin_panes/Class_Schedule/edit_page2.fxml"))));



    }

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
                    if(scan1.hasNextLine())  date_1.setText(scan1.nextLine());
                    scan1.close();


                    if(scan2.hasNextLine())  class2.setText(scan2.nextLine());
                    if(scan2.hasNextLine()) date2.setText(scan2.nextLine());
                    if(scan2.hasNextLine()) date_2.setText(scan2.nextLine());
                    scan2.close();

                    if(scan3.hasNextLine()) class3.setText(scan3.nextLine());
                    if(scan3.hasNextLine()) date3.setText(scan3.nextLine());
                    if(scan3.hasNextLine()) date_3.setText(scan3.nextLine());
                    scan3.close();


                    if(scan4.hasNextLine()) class4.setText(scan4.nextLine());
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

