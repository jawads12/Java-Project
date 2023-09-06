package com.example.mist_computer_club.controller;

import com.example.mist_computer_club.CopyFile;
import com.example.mist_computer_club.hash_generator;
import com.example.mist_computer_club.universal;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.lang.Object;


public class register implements Initializable {

    @FXML
    private TextField addr_fx;


    @FXML
    private ImageView im1;

    @FXML
    private ImageView im2;

    @FXML
    private ImageView im3;

    @FXML
    private ImageView im4;

    @FXML
    private ImageView im5;

    @FXML
    private ImageView im6;

    @FXML
    private ImageView im7;

    @FXML
    private ImageView im8;

    @FXML
    private ImageView img;


    @FXML
    private TextField dept_fx;

    @FXML
    private DatePicker dob;

    @FXML
    private TextField email_fx;

    @FXML
    private TextField level;

    @FXML
    private TextField id_fx;

    @FXML
    private PasswordField con_pass_fx;

    @FXML
    private TextField passfx;

    @FXML
    private TextField phone_fx;

    @FXML
    private Label photolabel;

    @FXML
    private TextField name_fx;








    String addr;
    String dept;
    String new_email;
    String id;
    String lvl;
    String name;
    String birthday="";
    String phone;
    String hash;

    String final_pass="";
    String conf_hash;
    String pic_path = "";

   // public static String path = "E:/Java/Projects/MIST Computer CLub/MIST Computer Club/src/main/resources/database/accounts/member";
    String path = universal.path;




    @FXML
    void photochoose(MouseEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter( "Image Files", "*.jpg", "*.jpeg",  "*.png"));
        File f = fc.showOpenDialog(null);

        if(f!=null) {
            pic_path = f.getAbsolutePath();
            photolabel.setText(pic_path);
        }
    }


    @FXML
    void getdate(ActionEvent event) {
        LocalDate date = dob.getValue();
        String myformat = date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        birthday = myformat;

    }

    @FXML
    void exit(MouseEvent event){
        ((Stage)(((Node)event.getSource()).getScene().getWindow())).close();
    }


    @FXML
    void joins(MouseEvent event) throws IOException {
        addr = addr_fx.getText();
        dept = dept_fx.getText();
        new_email = email_fx.getText();
        id = id_fx.getText();
        name = name_fx.getText();
        phone = phone_fx.getText();
        hash = passfx.getText();
        conf_hash = con_pass_fx.getText();
        lvl=level.getText();

        if(addr.isBlank() ||dept.isBlank()||new_email.isBlank()||id.isBlank()||name.isBlank()||phone.isBlank() ||hash.isBlank()||birthday.isBlank()||conf_hash.isBlank()||lvl.isBlank()||pic_path.isBlank())
        {
            universal.show_warning("All field must be filled up");
        }
        else  {
            path = path+"/";
            File members = new File(path+new_email);
            if(members.exists()) {
                universal.show_warning("OOPS! You joined already!");
            }

            else if(!hash.equals(conf_hash)){

                universal.show_warning("Passwords are not matched");
            }


            else {
                final_pass = hash_generator.getHash(hash, "SHA-256");

                //shutting join form



                //taking password
                if(members.mkdir()) System.out.println("Successfully Account Opened");
                path=path+new_email+"/";

                File info = new File(path+"info.txt");
                if(info.createNewFile()){
                    System.out.println("Info.txt is Created");
                }

                File noti = new File(path+"noti.txt");
                if(noti.createNewFile()){
                    System.out.println("noti.txt is Created");
                }

                File team = new File(path+"team.txt");
                if(team.createNewFile()){
                    System.out.println("team.txt is Created");
                }







                FileWriter infos = new FileWriter(path+"info.txt");
                infos.write(name+"\n");
                infos.write(id+"\n");
                infos.write(dept+"\n");
                infos.write(new_email+"\n");
                infos.write(addr+"\n");
                infos.write(phone+"\n");
                infos.write(birthday+"\n");
                infos.write(lvl+"\n");
                infos.close();


                File hashs = new File(path+"hash.txt");
                if(hashs.createNewFile()){
                    System.out.println("Hash.txt is Created");
                }

                FileWriter hashsh = new FileWriter(path+"hash.txt");
                hashsh.write(final_pass+"\n");
                hashsh.close();
                System.out.println(hash);

//mail confirmation
                current_user user = new reg_send_mail(name,id,dept,new_email);
                user.send_mail();





                //universal.copyFile(new File(pic_path), new File(universal.path + "/" + new_email + "/"));


                File oldFile =new File(pic_path);
                File newFile =new File(universal.path + "/" + new_email + "/"+"image.jpg");

                try {
                    CopyFile.copyFileUsingJava7Files(oldFile,newFile);


                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.close();

                    universal.show_success("You have joined successfully");


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


        path = universal.path;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       // rotate.play();


        FadeTransition rotate = new FadeTransition();
        rotate.setNode(im1);
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setDuration(Duration.millis(7000));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setFromValue(0);
        rotate.setToValue(1);
        // rotate.setAutoReverse(true);
        rotate.play();

        FadeTransition rotate1 = new FadeTransition();
        rotate1.setNode(im4);
        rotate1.setCycleCount(TranslateTransition.INDEFINITE);
        rotate1.setDuration(Duration.millis(4000));
        rotate1.setInterpolator(Interpolator.LINEAR);
        rotate1.setFromValue(0);
        rotate1.setToValue(1);
        //  rotate1.setAutoReverse(true);
        rotate1.play();

        FadeTransition rotate2 = new FadeTransition();
        rotate2.setNode(im3);
        rotate2.setCycleCount(TranslateTransition.INDEFINITE);
        rotate2.setDuration(Duration.millis(7000));
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.setFromValue(0);
        rotate2.setToValue(1);
        //  rotate2.setAutoReverse(true);
        rotate2.play();

        FadeTransition rotate3 = new FadeTransition();
        rotate3.setNode(im7);
        rotate3.setCycleCount(TranslateTransition.INDEFINITE);
        rotate3.setDuration(Duration.millis(5000));
        rotate3.setInterpolator(Interpolator.LINEAR);
        rotate3.setFromValue(0);
        rotate3.setToValue(1);
        //  rotate3.setAutoReverse(true);
        rotate3.play();



    }
}
