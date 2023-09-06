package com.example.mist_computer_club;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Stack;

public class  universal {
    public static String warning_message = "";
    public static final String path = "E:/Java/Projects/MIST Computer CLub/MIST Computer Club/src/main/resources/database/accounts/member";

    public static final String path_team = "E:/Java/Projects/MIST Computer CLub/MIST Computer Club/src/main/resources/database/accounts/Teams";
    public static final String path_ctf = "E:/Java/Projects/MIST Computer CLub/MIST Computer Club/src/main/resources/database/accounts/CTF";

    public static final String path_announces = "E:/Java/Projects/MIST Computer CLub/MIST Computer Club/src/main/resources/database/accounts/announces";
    public static String string_part1;
    public static String string_part2;
    public static String string_part3;
    public static String a;
    public static String b;
    public static String c;
    public static int i;
    public static String current_acc_name_final;
    public static String Current_acc_roll_final;
    public static String Current_acc_dept_final;
    public static String current_acc_team_name;
    public static String current_acc_email_final;
    public static String Current_level;
    public static String feedback_path="E:/Java/Projects/MIST Computer CLub/MIST Computer Club/src/main/resources/database/accounts/Feedback";
    public static String current_feed;
    public static String class_name;
    public static VBox uni_vbox = null;

  //  public static  Node[] uni_node_team ;

    public static ArrayList<Node> uni_node_team = new ArrayList<Node>();
    public static Stack<String> uni_node_ctf = new Stack<String>();







    static File []file = new File(path_announces).listFiles();

    public static int count;

    public static String details_from_announce ;


    static {
        assert file != null;
        count = file.length;
    }


    public static void copyFile(File source, File dest) throws IOException, IOException {
        Files.copy(source.toPath(), dest.toPath());
    }

    public static  String current_path = "";

    public static String Current_acc_phone;
    public static String current_acc_name ;
    public static String Current_acc_roll ;
    public static String Current_acc_dept ;


    public static String CTF_name;
    public static String CTF_date;
    public static String link;



    public static void show_warning(String warning) throws IOException {
        warning_message = warning;
        FXMLLoader loader = new FXMLLoader(universal.class.getResource("/warning.fxml"));
        Parent pane = loader.load();
        Scene scene = new Scene(pane);
        Stage warn = new Stage();
        warn.setScene(scene);
        warn.setResizable(false);
        warn.initStyle(StageStyle.UNDECORATED);
        warn.show();
    }




    public static void show_success(String warning) throws IOException {
        warning_message = warning;
        FXMLLoader loader = new FXMLLoader(universal.class.getResource("/USER/success.fxml"));
        Parent pane = loader.load();
        Scene scene = new Scene(pane);
        Stage warn = new Stage();
        warn.setScene(scene);
        warn.setResizable(false);
        warn.initStyle(StageStyle.UNDECORATED);
        warn.show();
    }



    //for teams


    public static String [] Current_email = new String[4];
    public static String [] Current_pic = new String[4];
    public static String team_ame ;
    public static String path2;




    public static int OTP;

    public static final String path_Schedule = "E:/Java/Projects/MIST Computer CLub/MIST Computer Club/src/main/resources/database/accounts/Schedule";



}
