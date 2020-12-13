package com.dkit.sd2a.jessicasavage;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;

public class ComputerDB {
    private static ArrayList<Computer> computers;
    private static Scanner keyboard = new Scanner(System.in);

    protected void readComputerFile() {
        try (Scanner studentFile = new Scanner(new BufferedReader(new FileReader("Computing.txt")))) {
            String input;
            while (studentFile.hasNextLine()) {
                input = studentFile.nextLine();
                String[] data = input.split(";");

                String type = data[0];
                String manufacturer = data[1];
                String processor = data[2];
                double ramSize = Double.parseDouble(data[3]);
                double diskSize = Double.parseDouble(data[4]);
                double weight = Double.parseDouble(data[5]);
                String assetTag = data[6];
                LocalDate purchaseDate = LocalDate.parse(data[7]);
                int option1 = Integer.parseInt(data[8]);
                int option2 = Integer.parseInt(data[9]);

                if (type.toLowerCase().equals("laptop")) {
                    computers.add(new Laptops(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchaseDate, option1, option2));
                } else if (type.toLowerCase().equals("desktop")) {
                    computers.add(new Desktop(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchaseDate, option1, option2));
                } else if (type.toLowerCase().equals("raspberry")) {
                    computers.add(new RaspberryPi(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchaseDate, option1, option2));
                }
            }

        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }


        public void saveComputersToFile(){
        try(BufferedWriter computersFile = new BufferedWriter(new FileWriter("Computing.txt") ))
        {
            for(Computer computer : computers)
            {
                computersFile.write(computer.getManufacturer() +","+computer.getProcessor()+","+computer.getRamSize()+","+computer.getDiskSize()+","+computer.getWeight()+","+computer.getAssetTag()+","+computer.getPurchaseDate());
                computersFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println(Colours.PURPLE + "Could not save computers." +Colours.RESET);
        }
    }

    public static void displayAllComputers(){
        computers.toString();
    }

    public static void addComputer(){
        System.out.println("Enter Computer Type, eg. laptop, desktop, raspberry:");
        String type = keyboard.nextLine();
        System.out.println("Enter Manufacturer:");
        String manufacturer = keyboard.nextLine();
        System.out.println("Enter Processor:");
        String processor = keyboard.nextLine();
        System.out.println("Enter Ram Size:");
        int ramSize = keyboard.nextInt();
        System.out.println("Enter Disk Size :");
        int diskSize = keyboard.nextInt();
        System.out.println("Enter Weight:");
        double weight = keyboard.nextDouble();
        System.out.println("Enter Asset Tag:");
        String assetTag = keyboard.nextLine();

        System.out.println("Enter Year Purchased:");
        int byear = keyboard.nextInt();
        System.out.println("Enter Month Purchased eg March = 03 :");
        int bmonth = keyboard.nextInt();
        System.out.println("Enter Date Purchased:");
        int bday = keyboard.nextInt();
        String bookingTimeDate = byear + "," + bmonth + "," +bday;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate purchase_Date = LocalDate.parse(bookingTimeDate, formatter);

        int option1;
        int option2;

        if(type.toLowerCase().equals("laptop")){
            System.out.println("Enter Year Screen Size:");
            option1 = keyboard.nextInt();
            System.out.println("Enter Battery Life :");
            option2 = keyboard.nextInt();

            computers.add(new Laptops(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchase_Date, option1, option2));
        }
        else if (type.toLowerCase().equals("desktop")){
            System.out.println("Enter Number of Monitors:");
            option1 = keyboard.nextInt();
            System.out.println("Enter Monitor Size:");
            option2 = keyboard.nextInt();
            computers.add(new Desktop(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchase_Date, option1, option2));
        }
        else if (type.toLowerCase().equals("raspberry")){
            System.out.println("Enter Number of GPIO Pins:");
            option1 = keyboard.nextInt();
            System.out.println("Enter Amount SD Storage :");
            option2 = keyboard.nextInt();
            computers.add(new RaspberryPi(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchase_Date, option1, option2));
        }
    }
}
