package com.example.mist_computer_club.controller;

import com.example.mist_computer_club.Mail_background_task;

public class reg_send_mail extends current_user{
    String email;

    public reg_send_mail(String name, String id, String dept, String new_email) {
        super(name,id, dept);
        this.email = new_email;
    }

    @Override
    public void send_mail() {
      //  Mail_background_task mail_background_task = new Mail_background_task(email.getText());
        universal_Mail_sender_bg_task<String> task = new universal_Mail_sender_bg_task<String>(email, text+"\n"+name+"\n"+id+"\n"+dept+"\n");
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }
}
