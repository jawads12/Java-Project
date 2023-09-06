package com.example.mist_computer_club;

import javafx.concurrent.Task;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail_background_task extends Task {
    String receiver;
    public Mail_background_task(String text) {
        this.receiver = text;

    }

    @Override
    protected Object call() throws Exception {

            String sender = "mist.mcsc@gmail.com";
            String receiver = this.receiver;
            universal.OTP = (int)((Math.random()*100000000)%100000);
            String message = String.valueOf("Your OTP is :"+ universal.OTP);
            String subject = "Authentication code for MIST Cyber Security Club";
            String host = "smtp.gmail.com";

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
                    return new PasswordAuthentication(sender,"sykluaaullimnxaz");
                }
            });

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(sender);
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);
            Transport.send(mimeMessage);


        return null;
    }
}
