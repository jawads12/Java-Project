package com.example.mist_computer_club.controller;

public abstract class current_user {
    String name;
    String id;
    String dept;

    String text = "Congratulations! You are joined MIST Cyber Security Club";

    public current_user(String name, String id, String dept) {
        this.name=name;
        this.id=id;
        this.dept = dept;


    }


    public abstract void send_mail();

}



