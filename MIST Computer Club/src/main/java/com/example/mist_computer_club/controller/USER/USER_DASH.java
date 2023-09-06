package com.example.mist_computer_club.controller.USER;

import com.example.mist_computer_club.controller.admin_dashboard;
import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class USER_DASH implements Initializable {

    @FXML
    private Label dept;

    @FXML
    private Label id;

    @FXML
    private Label name;

    @FXML
    private AnchorPane pane;

    @FXML
    private Circle pic;

    @FXML
    void announce(MouseEvent event) throws IOException {
        pane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(admin_dashboard.class.getResource("/USER/admin_panes/announcement/announce_pane.fxml"))));


    }

    @FXML
    void ctf(MouseEvent event) throws IOException {
        FXMLLoader loaderMainWindow = new FXMLLoader(getClass().getResource("/USER/admin_panes/CTF/CTF_pane.fxml"));
        Pane pan = loaderMainWindow.load();
        pane.getChildren().add(pan);




    }

    @FXML
    void logout(MouseEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to exit?");

        if(alert.showAndWait().get()== ButtonType.OK){
            ((Stage)((Node)event.getSource()).getScene().getWindow()).close();


        }



        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LOGIN_final.fxml"));
        Parent pane = loader.load();
        Scene scene = new Scene(pane);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);

        final double[] x = new double[1];
        final double[] y = new double[1];
        pane.setOnMousePressed(even -> {
            x[0] = even.getSceneX();
            y[0] = even.getSceneY();
        });
        pane.setOnMouseDragged(even -> {

            stage.setX(even.getScreenX() - x[0]);
            stage.setY(even.getScreenY() - y[0]);

        });


        stage.show();


}

    @FXML
    void my_profile(MouseEvent event) {
        String team = universal.path_team+"/"+universal.current_acc_team_name;
        try {
            pane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(admin_dashboard.class.getResource("/USER/admin_panes/my_profile.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }


    }

    @FXML
    void opem_dash(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(admin_dashboard.class.getResource("/USER/admin_panes/dashboard_pane/pane_dashboard.fxml"));
        Parent lagabo;
        try {
            lagabo = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pane.getChildren().add(lagabo);

    }

    @FXML
    void open_contact(MouseEvent event) {
        try {
            pane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(admin_dashboard.class.getResource("/USER/admin_panes/contacts/pane_contact_info.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }



    }

    @FXML
    void feedback(MouseEvent event) {
        try {
            pane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(admin_dashboard.class.getResource("/USER/admin_panes/feedback/feedback.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }



    }

    @FXML
    void schedule(MouseEvent event) {
        try {
            pane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(admin_dashboard.class.getResource("/USER/admin_panes/Class_Schedule/class_schedule_main.fxml"))));
        } catch (IOException e) {
            //  throw new RuntimeException(e);
            System.out.println("Problem in Open schedule");
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image ima = new Image(universal.current_path+"image.jpg", false);
        pic.setFill(new ImagePattern(ima));
        //circle.setEffect(new DropShadow(+25d));
        name.setText(universal.current_acc_name);
        System.out.println(universal.current_acc_name);
        id.setText(universal.Current_acc_roll);
        dept.setText(universal.Current_acc_dept);


        FXMLLoader loader = new FXMLLoader(admin_dashboard.class.getResource("/USER/admin_panes/dashboard_pane/pane_dashboard.fxml"));
        Parent lagabo;
        try {
            lagabo = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pane.getChildren().add(lagabo);


    }
}
