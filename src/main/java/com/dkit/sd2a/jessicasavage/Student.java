package com.dkit.sd2a.jessicasavage;

import java.util.*;

public class Student {
    private static String name;
    private static String studentID;
    private static String email;
    private static String phone;
    private String[] computersOnLoan;

    public Student(String name, String studentID, String email, String phone, String[] computersOnLoan) {
        this.name = name;
        this.studentID = studentID;
        this.email = email;
        this.phone = phone;
        this.computersOnLoan = computersOnLoan;
    }

    public String getName() {
        return name;
    }

    public static String getStudentID() {
        return studentID;
    }

    public static void setStudentID(String studentID) {
        Student.studentID = studentID;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String[] getComputersOnLoan() {
        return computersOnLoan;
    }

    public static void setName(String name) {
        Student.name = name;
    }

    public static void setEmail(String email) {
        Student.email = email;
    }

    public static void setPhone(String phone) {
        Student.phone = phone;
    }

    public void setComputersOnLoan(String[] computersOnLoan) {
        this.computersOnLoan = computersOnLoan;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", computersOnLoan=" + Arrays.toString(computersOnLoan) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(email, student.email) &&
                Objects.equals(phone, student.phone) &&
                Arrays.equals(computersOnLoan, student.computersOnLoan);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, email, phone);
        result = 31 * result + Arrays.hashCode(computersOnLoan);
        return result;
    }
}
