package com.example.mist_computer_club;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CopyFile
{
    public static void main(String[] args)
    {

        File oldFile =new File("test.txt");
        File newFile =new File("cook.txt");

        try {
            copyFileUsingJava7Files(oldFile,newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
   public static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }
}