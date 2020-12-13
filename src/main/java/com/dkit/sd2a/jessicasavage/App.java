package com.dkit.sd2a.jessicasavage;

/**
 * Hello world!
 *
 */

import java.util.*;

public class App
{
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("\n*** COMPUTER LOANING SYSTEM ***\n");


       boolean loop= true;
       MainMenu menuOption;
       int option;
        while (loop)
        {
            printMainMenu();
//            printStudentMenu();
            try
            {
                option = keyboard.nextInt();
                keyboard.nextLine();
                menuOption = MainMenu.values()[option];
                switch (menuOption) {
                    case STUDENT_MENU:
                        StudentMenuLoop();
                        break;
                    case STUDENT_BOOKING_MENU:
                        BookingMenuLoop();
                        break;
                    case QUIT:
                        loop = false;
                        break;
                }
            }
            catch (IllegalArgumentException e){
                System.out.println("Selection out of range. Please try again: ");
                keyboard.nextLine();
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Selection out of range. Please try again: ");
                keyboard.nextLine();
            }
            catch (NoSuchElementException e){
                System.out.println("Selection out of range. Please try again: ");
                keyboard.nextLine();
            }
        }
    }

    private static void printMainMenu(){

        System.out.println("\n Options to select:");
        for(int i = 0; i < MainMenu.values().length; i++){
            System.out.println("\t" +i + ". " + MainMenu.values()[i].toString());
        }
        System.out.println("Enter a number to select option (enter 0 to cancel):>");
    }

    private static void StudentMenuLoop()
    {
        boolean loop = true;
        StudentDB studentdb = new StudentDB();
        studentdb.readStudentFile();
        studentdb.saveStudentsToFile();
        StudentMenu menuOption;
        int option1;
        while (loop)
        {
            StudentDB.StudentMenu();
//            printStudentMenu();
            try
            {
                option1 = keyboard.nextInt();
                keyboard.nextLine();
                menuOption = StudentMenu.values()[option1];
                switch (menuOption) {
                    case QUIT_STUDENT_MENU:
                        loop = false;
                        break;
                    case PRINT_STUDENTS:
                        StudentDB.displayAllStudents();
                        break;
                    case ADD_STUDENTS:
                        StudentDB.addStudent();
                        break;
                    case EDIT_STUDENTS:
                        StudentDB.editStudent();
                        break;
                    case SPECIFIC_STUDENT:
                        StudentDB.specificStudent();
                        break;
                    case DELETE_STUDENTS:
                        StudentDB.deleteStudent();
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(Colours.RED + "IllegalArgumentException, Try again" + Colours.RESET);
                keyboard.nextLine();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(Colours.RED + "ArrayIndexOutOfBoundsException, Try again" + Colours.RESET);
                keyboard.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println(Colours.RED + "InputMismatchException, Try again" + Colours.RESET);
                keyboard.nextLine();
            }
        }
        System.out.println(Colours.PURPLE + "Returning to Main Menu" + Colours.RESET);
    }

    private static void BookingMenuLoop() {
        boolean loop = true;
        BookingDB bookingdb = new BookingDB();
        bookingdb.readBookingFile();
        bookingdb.saveBookingToFile();
        BookingMenu menuOption;
        int option2;
        while (loop)
        {
            BookingDB.BookingMenu();
//            printStudentMenu();
            try
            {
                option2 = keyboard.nextInt();
                keyboard.nextLine();
                menuOption = BookingMenu.values()[option2];
                switch (menuOption) {
                    case QUIT_BOOKING_MENU:
                        loop = false;
                        break;
                    case PRINT_BOOKING:
                        BookingDB.displayAllBookings();
                        break;
                    case ADD_BOOKING:
                        BookingDB.addBooking();
                        break;
                    case EDIT_BOOKING:
                        BookingDB.editBooking();
                        break;
                    case DELETE_BOOKING:
                        BookingDB.deleteBooking();
                        break;
                    case SORT_BOOKING_BY_DATE:
                        BookingDB.sortByDate();
                        break;
                    case AVERAGE_LENGTH_OF_BOOKINGS:
                        BookingDB.averageBetweenDates();
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(Colours.RED + "IllegalArgumentException, Try again" + Colours.RESET);
                keyboard.nextLine();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(Colours.RED + "ArrayIndexOutOfBoundsException, Try again" + Colours.RESET);
                keyboard.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println(Colours.RED + "InputMismatchException, Try again" + Colours.RESET);
                keyboard.nextLine();
            }
        }
        System.out.println(Colours.PURPLE + "Returning to Main Menu" + Colours.RESET);
    }
}
