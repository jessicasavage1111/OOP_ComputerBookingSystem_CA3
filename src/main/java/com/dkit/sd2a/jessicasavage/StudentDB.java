package com.dkit.sd2a.jessicasavage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;

public class StudentDB {
    private static ArrayList<Student> students;
    private static Scanner keyboard = new Scanner(System.in);

    public StudentDB() {
        students = new ArrayList<>();
    }

    protected void readStudentFile(){

        try(Scanner studentFile = new Scanner(new BufferedReader(new FileReader("Student.txt")))) {
            String input;
            while (studentFile.hasNextLine()) {
                input = studentFile.nextLine();
                String[] data = input.split(",");

                String name = data[0];
                String id = data[1];
                String email = data[2];
                String phone = data[3];
                String[] computersOnLoan = {data[4], data[5]};

                this.students.add(new Student(name, id, email, phone, computersOnLoan));
                System.out.println(students);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred with Student data.");
        }
    }

    public void saveStudentsToFile()
    {
        try(BufferedWriter studentFile = new BufferedWriter(new FileWriter("Student.txt") ))
        {
            for(Student student : students)
            {
                studentFile.write(student.getStudentID() +","+student.getName()+","+student.getEmail()+","+student.getPhone()+","+student.getComputersOnLoan().toString());
                studentFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println(Colours.PURPLE + "Could not save students." +Colours.RESET);
        }
    }

    public static void StudentMenu()
    {
        System.out.println("\nOptions:");
        for (int i = 0; i < StudentMenu.values().length; i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + StudentMenu.values()[i].toString() + Colours.RESET);
        }
        System.out.println("Select an option (0 to quit): ");//Don't allow duplicates, ID values unique
    }

    public static void displayAllStudents(){
        System.out.println(students);
    }

    public static void specificStudent(){
        System.out.println("Please enter the student's ID");
        String specificStudent = keyboard.nextLine();
        for (int i = 0; i < students.size(); i++){
            if(students.get(i).getStudentID().equals(specificStudent.toUpperCase())){
                System.out.println(students.get(i));
            }
            else{
                System.out.println("The student ID that was entered cannot be found");
            }
        }
    }

    public static void addStudent(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Student Name:");
        String sName = keyboard.nextLine();
        System.out.println("Enter Student ID:");
        String sID = keyboard.nextLine();
        System.out.println("Enter Student Email:");
        String sEmail = keyboard.nextLine();
        System.out.println("Enter Student Phone:");
        String sPhone = keyboard.nextLine();
        String[] computersOnLoan = new String[2];
        for (int k = 0; k<=3; k++) {
            System.out.println("Enter new asset tag or enter exit:");
            String entry = keyboard.nextLine();
            if (entry.equals("exit")){
                k = 5;
            }
            else{
                computersOnLoan[k] = entry;
            }
        }

        students.add(new Student(sName, sID, sEmail, sPhone, computersOnLoan));
    }

    public static void deleteStudent(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the student's ID");
        String specificStudent = keyboard.nextLine();
        for (int i = 0; i < students.size(); i++){
            if(students.get(i).getStudentID().equals(specificStudent.toUpperCase())){
                students.remove(i);
            }
            else{
                System.out.println("The student ID that was entered cannot be found");
            }
        }
    }

    public static void editStudent(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the student's ID");
        String specificStudent = keyboard.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID().equals(specificStudent.toUpperCase())) {
                System.out.println(students.get(i));

                System.out.println("Please enter what you want to change, eg. 'name', 'student ID', 'email', 'phone number', or asset tag.");
                String change = keyboard.nextLine();

                if (change.toLowerCase().equals("name")){
                    System.out.println("Enter new name:");
                    String edit = keyboard.nextLine();
                    students.get(i).setName(edit);
                    System.out.println(students.get(i));
                }
                else if(change.toLowerCase().equals("student id")){
                    System.out.println("Enter new ID:");
                    String edit = keyboard.nextLine();
                    if(students.get(i).getStudentID().equals(edit)){
                        System.out.println("Student ID has already been entered");
                    }
                    else {
                        students.get(i).setStudentID(edit);
                        System.out.println(students.get(i));
                    }
                }
                else if(change.toLowerCase().equals("email")){
                    System.out.println("Enter new email:");
                    String edit = keyboard.nextLine();
                    students.get(i).setEmail(edit);
                    System.out.println(students.get(i));
                }
                else if(change.toLowerCase().equals("phone number")){
                    System.out.println("Enter new phone number:");
                    String edit = keyboard.nextLine();
                    students.get(i).setPhone(edit);
                    System.out.println(students.get(i));
                }
                else if(change.toLowerCase().equals("asset tag")){
                    String[] edit = new String[3];
                    for (int k = 0; k<=3; k++) {
                        System.out.println("Enter new asset tag or enter exit:");
                        String entry = keyboard.nextLine();
                        if (entry.equals("exit")){
                            k = 5;
                        }
                        else{
                            edit[k] = entry;
                        }
                    }
                    students.get(i).setComputersOnLoan(edit);
                    System.out.println(students.get(i));
                }
                else{
                    System.out.println("Invalid option inputted.");
                }
            }
            else {
                System.out.println("The student ID that was entered cannot be found");
            }
        }
    }
}
