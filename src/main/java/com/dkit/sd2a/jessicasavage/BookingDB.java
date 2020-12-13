package com.dkit.sd2a.jessicasavage;

import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingDB {
    private static ArrayList<StudentBooking> bookings;
    private static Scanner keyboard = new Scanner(System.in);

    public BookingDB() {
        bookings = new ArrayList<>();
    }

    protected static void readBookingFile(){

        try(Scanner studentFile = new Scanner(new BufferedReader(new FileReader("Booking.txt")))) {
            String input;
            while (studentFile.hasNextLine()) {
                input = studentFile.nextLine();
                String[] data = input.split(",");

                int bookingID = Integer.parseInt(data[0]);
                String bookingTimeDate = data[1];
                String returnTimeDate = data[2];
                String type = data[3];
                String assetTag = data[4];
                String studentID = data[5];

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate booking_Date = LocalDate.parse(bookingTimeDate);
                LocalDate return_Date = LocalDate.parse(returnTimeDate);


                bookings.add(new StudentBooking(bookingID, booking_Date, return_Date, type, assetTag, studentID));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred with Student data.");
        }
       }

    public void saveBookingToFile()
    {
        try(BufferedWriter bookingFile = new BufferedWriter(new FileWriter("Booking.txt") ))
        {
            for(StudentBooking booking : bookings)
            {
                bookingFile.write(booking.getBookingID() +","+booking.getBookingTimeDate()+","+booking.getReturnTimeDate()+","+booking.getType()+","+booking.getAssetTag()+","+booking.getStudentID());
                bookingFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println(Colours.PURPLE + "Could not save bookings." +Colours.RESET);
        }
    }

    public static void BookingMenu()
    {
        System.out.println("\nOptions:");
        for (int i = 0; i < BookingMenu.values().length; i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + BookingMenu.values()[i].toString() + Colours.RESET);
        }
        System.out.println("Select an option (0 to quit): ");//Don't allow duplicates, ID values unique
    }

    public static void displayAllBookings(){
        System.out.println(bookings);
    }

    public static void addBooking(){
        System.out.println("Enter Computer Type eg. laptop, desktop, raspberry:");
        String type = keyboard.nextLine();
        System.out.println("Enter Booking ID:");
        int bookingID = keyboard.nextInt();
        System.out.println("Enter Year Loan Took Place:");
        int byear = keyboard.nextInt();
        System.out.println("Enter Month Loan Took Place eg March = 03 :");
        int bmonth = keyboard.nextInt();
        System.out.println("Enter Date Loan Took Place:");
        int bday = keyboard.nextInt();

        String bookingTimeDate = byear + "," + bmonth + "," +bday;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate booking_Date = LocalDate.parse(bookingTimeDate, formatter);

        System.out.println("Do you know the return date? Enter yes or no:");
        String yesOrNo = keyboard.nextLine();
        LocalDate return_Date = null;
        if(yesOrNo.toLowerCase().equals("yes")){
            System.out.println("Enter Year of Return Took Place:");
            int ryear = keyboard.nextInt();
            System.out.println("Enter Month of Return Took Place eg March = 03 :");
            int rmonth = keyboard.nextInt();
            System.out.println("Enter Date of Return Took Place:");
            int rday = keyboard.nextInt();

            String returnTimeDate = ryear + "," + rmonth + "," +rday;
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return_Date = LocalDate.parse(returnTimeDate, formatter1);
        }
        else{
            return_Date = null;
        }

        System.out.println("Enter Asset Tag:");
        String assetTag = keyboard.nextLine();
        System.out.println("Enter Asset Tag:");
        String studentID = keyboard.nextLine();

        bookings.add(new StudentBooking(bookingID, booking_Date, return_Date, type, assetTag, studentID));
        }

    public static void deleteBooking(){
        System.out.println("Please enter the Booking ID");
        int specificBooking = keyboard.nextInt();
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingID() == specificBooking) {
                bookings.remove(i);
            }
            else{
                System.out.println("The booking ID that was entered cannot be found");
            }
        }
    }

    public static void editBooking(){

        System.out.println("Please enter the Booking ID");
        int specificBooking = keyboard.nextInt();
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingID() == specificBooking) {
                System.out.println(bookings.get(i));

                System.out.println("Please enter what you want to change, eg. 'booking ID', 'booking date', 'return date', 'computer type', asset tag or, student ID.");
                String change = keyboard.nextLine();

                if (change.toLowerCase().equals("booking id")){
                    System.out.println("Enter new booking ID :");
                    int edit = keyboard.nextInt();
                    for (int k = 0; k < bookings.size(); k++) {
                        if (bookings.get(k).getBookingID() == edit) {
                            System.out.println("Student ID has already been entered");
                        } else {
                            bookings.get(i).setBookingID(edit);
                            System.out.println(bookings.get(i));
                        }
                    }
                }
                else if(change.toLowerCase().equals("booking date")){
                    System.out.println("Enter Year Loan Took Place:");
                    int byear = keyboard.nextInt();
                    System.out.println("Enter Month Loan Took Place eg March = 03 :");
                    int bmonth = keyboard.nextInt();
                    System.out.println("Enter Date Loan Took Place:");
                    int bday = keyboard.nextInt();

                    String bookingTimeDate = byear + "," + bmonth + "," +bday;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate booking_Date = LocalDate.parse(bookingTimeDate, formatter);

                    bookings.get(i).setBookingTimeDate(booking_Date);
                }
                else if(change.toLowerCase().equals("booking date")){
                    System.out.println("Enter Year Return Took Place:");
                    int byear = keyboard.nextInt();
                    System.out.println("Enter Month Return Took Place eg March = 03 :");
                    int bmonth = keyboard.nextInt();
                    System.out.println("Enter Date Return Took Place:");
                    int bday = keyboard.nextInt();

                    String bookingTimeDate = byear + "," + bmonth + "," +bday;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate booking_Date = LocalDate.parse(bookingTimeDate, formatter);

                    bookings.get(i).setReturnTimeDate(booking_Date);
                }
                else if(change.toLowerCase().equals("computer type")){
                    System.out.println("Enter computer type, eg 'laptop', 'desktop', or 'raspberry':");
                    String edit = keyboard.nextLine();
                    if(edit.toLowerCase().equals("laptop") || edit.toLowerCase().equals("desktop") || edit.toLowerCase().equals("raspberry")){
                        bookings.get(i).setType(edit);
                        System.out.println(bookings.get(i));
                    }
                    else{
                        System.out.println("Invalid option entered");
                    }
                }
                else if(change.toLowerCase().equals("asset tag")){
                    System.out.println("Enter new asset tag :");
                    String edit = keyboard.nextLine();
                    for (int k = 0; k < bookings.size(); k++) {
                        if (bookings.get(k).getAssetTag().equals(edit)) {
                            System.out.println("Student ID has already been entered");
                        } else {
                            bookings.get(i).setAssetTag(edit);
                            System.out.println(bookings.get(i));
                        }
                    }
                }
                else{
                    System.out.println("Invalid option inputted.");
                }
            }
            else {
                System.out.println("The booking ID that was entered cannot be found");
            }
        }
    }

    public static void sortByDate(){
        for(StudentBooking date : bookings){
            System.out.println(date);
        }
    }

    public static void differenceBetweenDates(){
        System.out.println("Please enter the student's ID");
        int specificBooking = keyboard.nextInt();
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingID() == specificBooking) {
                LocalDate bookingTime = bookings.get(i).getBookingTimeDate();
                LocalDate returnTime = bookings.get(i).getReturnTimeDate();
                System.out.println( "Difference between LocalDateTime objects" );

                LocalDate start = bookingTime;
                LocalDate end   = returnTime;

                long difference = Duration.between(start, end).toMillis();

                long millisInDay = 1000 * 60 * 60 * 24;
                long millisInHour = 1000 * 60 * 60;
                long millisInMinute = 1000 * 60;
                long millisInSecond = 1000;

                long days = difference / millisInDay;   // integer division
                long daysDivisionResidueMillis = difference - (days * millisInDay); // subtract days to get remaining hours

                long hours = daysDivisionResidueMillis / millisInHour;
                long hoursDivisionResidueMillis = daysDivisionResidueMillis - (hours * millisInHour);

                long minutes = hoursDivisionResidueMillis / millisInMinute;
                long minutesDivisionResidueMillis = hoursDivisionResidueMillis - (minutes * millisInMinute);

                long seconds = minutesDivisionResidueMillis / millisInSecond;
                long secondsDivisionResidueMillis = minutesDivisionResidueMillis - (seconds * millisInSecond);

                System.out.println(
                        + difference
                                + " millis ("
                                + days
                                + " d. "
                                + hours
                                + " h. "
                                + minutes
                                + " min. "
                                + seconds
                                + " sec."
                                + secondsDivisionResidueMillis
                                + " millis).");
            }
            else {
                System.out.println("The booking ID that was entered cannot be found");
            }
        }
    }

    public static void averageBetweenDates(){
        int average = 0;
        long difference = 0;

        for (int i = 0; i < bookings.size(); i++) {
            LocalDate bookingTime = bookings.get(i).getBookingTimeDate();
            LocalDate returnTime = bookings.get(i).getReturnTimeDate();
                System.out.println( "Difference between LocalDateTime objects" );

            LocalDate start = bookingTime;
            LocalDate end   = returnTime;

            difference = Duration.between(start, end).toMillisPart();

            average += difference;
        }
        average = (int) (difference / bookings.size());

        System.out.println("The Average length of bookings is : " + average);
    }
}
