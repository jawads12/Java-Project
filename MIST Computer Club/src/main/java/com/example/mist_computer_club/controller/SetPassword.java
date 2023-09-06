package com.example.mist_computer_club.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SetPassword {

    @FXML
    private TextField confirm_pass;

    @FXML
    private TextField password;

    private static String final_pass;

    boolean check(String str1, String str2)
    {
        return (!str1.equals("")) && str2.equals(str1);
    }
    @FXML
    public void set_pass(MouseEvent event) {
    String pass = password.getText();
    String confirm_passs = confirm_pass.getText();
    if(check(pass, confirm_passs)) {
        final_pass = password.getText();
    }
    else final_pass = "";
    }
    public static String get_pass()
    {
        return final_pass;
    }

}
