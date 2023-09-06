module com.example.mist_computer_club {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.javadoc;
    requires org.apache.commons.io;
    requires com.jfoenix;
    requires javafx.web;
    requires java.desktop;
    requires java.mail;



    opens com.example.mist_computer_club to javafx.fxml;
    exports com.example.mist_computer_club;
    exports com.example.mist_computer_club.controller;
    exports com.example.mist_computer_club.controller.panes;
    exports com.example.mist_computer_club.controller.Class_Schedule;
    exports com.example.mist_computer_club.controller.announcements;
    exports com.example.mist_computer_club.controller.USER;
    exports com.example.mist_computer_club.controller.USER.announcements;
    exports com.example.mist_computer_club.controller.USER.CTF;
    exports com.example.mist_computer_club.controller.USER.contacts;
    exports com.example.mist_computer_club.controller.USER.Class_Schedule;
    exports com.example.mist_computer_club.controller.USER.feedback;


    opens com.example.mist_computer_club.controller to javafx.fxml;
    opens com.example.mist_computer_club.controller.panes to javafx.fxml;
    opens com.example.mist_computer_club.controller.Class_Schedule to javafx.fxml;
    opens com.example.mist_computer_club.controller.announcements to javafx.fxml;
    opens com.example.mist_computer_club.controller.USER to javafx.fxml;
    opens com.example.mist_computer_club.controller.USER.announcements to javafx.fxml;
    opens com.example.mist_computer_club.controller.USER.CTF to javafx.fxml;
    opens com.example.mist_computer_club.controller.USER.contacts to javafx.fxml;
    opens com.example.mist_computer_club.controller.USER.Class_Schedule to javafx.fxml;
    opens com.example.mist_computer_club.controller.USER.feedback to javafx.fxml;


}