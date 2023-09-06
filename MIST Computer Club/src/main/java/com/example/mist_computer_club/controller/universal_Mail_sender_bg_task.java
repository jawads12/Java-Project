package com.example.mist_computer_club.controller;

import com.example.mist_computer_club.universal;
import javafx.concurrent.Task;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class  universal_Mail_sender_bg_task<T> extends Task<T> {
    T receiver;
    T text;
    public universal_Mail_sender_bg_task(T receiver, T text) {
        this.receiver = receiver;
        this.text=text;

    }

    @Override
    protected T call() throws Exception {

            String sender = (String) "mist.mcsc@gmail.com";
            String receiver = (String) this.receiver;
          //  universal.OTP = (int)((Math.random()*100000000)%100000);
           String message = (String) text;
            String subject = (String) "MIST Cyber Security Club";
            String host = (String) "smtp.gmail.com";

            Properties properties = System.getProperties();

            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port",587);
            properties.put("mail.smtp.starttls.enable","true");
            properties.put("mail.smtp.auth","true");

            Session session = Session.getInstance(properties, new Authenticator()
            {
                @Override
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication((String) sender,"sykluaaullimnxaz");
                }
            });

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom((String) sender);
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress((String) receiver));
            mimeMessage.setSubject((String) subject);
            mimeMessage.setText((String) message);
            Transport.send(mimeMessage);


        return null;
    }
}
