package com.dkit.sd2a.jessicasavage;

/**
 * Hello world!
 *
 */

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n*** COMPUTER LOANING SYSTEM ***\n");
        App app = new App();
        app.start();
    }

    public void start() {
        String studentData = null;
        String computerData = null;
        String bookingData = null;

        try {
            File sData = new File("Student.txt");
            Scanner myReader = new Scanner(sData);
            while (myReader.hasNextLine()) {
                studentData = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred with Student data.");
            e.printStackTrace();
        }

        try {
            File cData = new File("Computing.txt");
            Scanner myReader1 = new Scanner(cData);
            while (myReader1.hasNextLine()) {
                computerData = myReader1.next();
            }
            myReader1.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred with Computer data.");
            e.printStackTrace();
        }

        try {
            File bData = new File("Booking.txt");
            Scanner myReader2 = new Scanner(bData);
            while (myReader2.hasNextLine()) {
                bookingData = myReader2.nextLine();
            }
            myReader2.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred with Booking data.");
            e.printStackTrace();
        }

    }
}
