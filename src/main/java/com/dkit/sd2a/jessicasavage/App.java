package com.dkit.sd2a.jessicasavage;

/**
 * Hello world!
 *
 */

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App
{
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("\n*** COMPUTER LOANING SYSTEM ***\n");
        App app = new App();
        app.start();
    }

    public void start()
    {
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
        }
        catch (FileNotFoundException e) {
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
        }
        catch (FileNotFoundException e) {
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
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred with Booking data.");
            e.printStackTrace();
        }

        MenuOptions selectedOption = MenuOptions.CONTINUE;
        while(selectedOption != MenuOptions.QUIT){
            try {
                menu();
                selectedOption = MenuOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch (selectedOption){
                    case PRINT_STUDENT:
                        break;
                    case ADD_STUDENT:
                        break;
                    case EDIT_STUDENT:
                        break;
                    case DELETE_STUDENT:
                        break;
                    case PRINT_BOOKING:
                        break;
                    case ADD_BOOKING:
                        break;
                    case EDIT_BOOKING:
                        break;
                    case DELETE_BOOKING:
                        break;
                    case SORT_BOOKING:
                        break;
                    case AVERAGE_LENGTH:
                        break;
                    case QUIT:
                        break;
                    default:
                        System.out.println("Selection out of range. Please try again.");
                }
            }
            catch (IllegalArgumentException e){
                System.out.println("Selection out of range. Please try again: ");
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Selection out of range. Please try again: ");
            }
            catch (NoSuchElementException e){
                System.out.println("Selection out of range. Please try again: ");
            }
        }
    }

    private static void menu() {
        System.out.println("Enter: ");
        System.out.println("\t 1. Print Student Details");
        System.out.println("\t 2. Add Student Details");
        System.out.println("\t 3. Edit Student Details");
        System.out.println("\t 4. Delete Student Details");
        System.out.println("\t 5. Print Booking Details");
        System.out.println("\t 6. Add Booking Details");
        System.out.println("\t 7. Edit Booking Details");
        System.out.println("\t 8. Delete Booking Details");
        System.out.println("\t 9. Sort Booking Details");
        System.out.println("\t 10. Print Average Length of Bookings");
        System.out.println("\t 11. Quit");
        System.out.print("\n Selection : ");
    }
}
