package com.example.mist_computer_club.controller.panes;

import com.example.mist_computer_club.CTF_names;
import com.example.mist_computer_club.universal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.application.HostServices;
import com.sun.javafx.application.HostServicesDelegate;


import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

//import static jdk.jpackage.internal.WixAppImageFragmentBuilder.ShortcutsFolder.Desktop;

public class ctf_ implements Initializable {
    public String lin;
    @FXML
    private WebView webview;

    @FXML
    private Label dte;

    @FXML
    private HBox itemC;

    @FXML
    private Label name;

    @FXML
    private Hyperlink link;



    @FXML
    void ctf_link(MouseEvent event) throws IOException, URISyntaxException {
        if( Desktop.isDesktopSupported() )
        {
            new Thread(() -> {
                try {
                    Desktop.getDesktop().browse( new URI(link.getText() ) );
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }).start();
        }





    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      //  String pat = universal.path_ctf+"/";
        CTF_names item = new CTF_names(universal.current_acc_name, universal.Current_acc_roll, universal.Current_acc_dept);
        name.setText(item.ctf_name);
        dte.setText(item.ctf_date);
        link.setText(item.lonko);





    }
}
